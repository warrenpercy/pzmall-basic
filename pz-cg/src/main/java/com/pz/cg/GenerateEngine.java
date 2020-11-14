package com.pz.cg;

import com.pz.cg.db.ConnectionPool;
import com.pz.cg.db.Field;
import com.pz.cg.db.util.MetaDataUtil;
import com.pz.cg.test.CgTest;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.time.DateFormatUtils;
import org.apache.log4j.Logger;
import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.Velocity;

import javax.swing.plaf.nimbus.State;
import javax.xml.crypto.Data;
import java.io.*;
import java.sql.*;
import java.util.*;

/**
 * @author percy
 * @date 2020/8/26 13:54
 */
public class GenerateEngine {

    protected static final String FIELDS ="fields";
    protected static final String PACKAGE_NAME = "package";
    protected static final String CLASS_NAME = "className";
    protected static final String QUERY_CLASS_NAME = "queryClassName";
    protected static final String TABLE_NAME = "tableName";
    protected static final String INST_NAME= "instName";
    protected static final String QUERY_INST_NAME = "queryInstName";
    protected static final String IMPORTS ="imports";
    protected static final String AUTHOR ="author";
    protected static final String PK_ID ="pkid";
    protected static final String PK_TYPE="pkType";
    protected static final String PK_FILED="pkFiled";
    protected static final String PK_SIMPLE_TYPE= "pkSimpleType";
    protected static final String PK_NAME ="pkname";

    public static final String configFile ="config.properties";
    protected static Properties prop = new Properties();
    protected static Map<String,Object> context = null;
    protected static Map<String,Object> commonContext = null;

    protected String tableName;
    protected String className ="";
    public String classType = "";
    protected String queryClassType ="";
    protected static final String ANOTATION= "annotation";
    protected static final String DOMAIN ="domain";
    protected static final String DAO ="dao";
    protected static final String DAO_IMPL= "dao.impl";
    protected static final String DAO_TEST= "dao.test";
    protected static final String MANAGER ="manager";
    protected static final String MANAGER_IMPL = "manager.impl";
    protected static final String SERVICE ="service";
    protected static final String SERVICE_IMPL = "service.impl";
    protected static final String SQL_MAP ="sqlmap";
    protected static final String QUERYDOMAIN = "querydomain";


    private String location;
    private String fileName;
    private String packagee;
    private Set<String> imports = new HashSet<String>();
    private String template;

    private static Logger log =Logger.getLogger(GenerateEngine.class);

    protected String getSecondDir(){
        if (StringUtils.isEmpty(prop.getProperty(PACKAGE_NAME + ".catalog"))){
            return "";
        } else {
            return "."+prop.getProperty(PACKAGE_NAME + ".catalog");
        }
    }

    static {
        try {
            log.info("正在初始化环境");
            context = new HashMap<String, Object>();
            File file = FileUtils.toFile(CgTest.class.getResource("/config/config-local.properties"));
            prop.load(new FileInputStream(file));
        } catch (IOException e) {
            e.printStackTrace();
            log.info("初始化失败", e);
        }
    }

    protected void init(String classType) {
        this.classType = classType;
        this.queryClassType = "query" + classType;
        if (commonContext == null) {
            initCommonContext();
        }
        initClassMetaInfo();
        initLocation();
        this.setTemplate(prop.getProperty(classType));
    }

    //根据配置完成数据库到字段的映射
    protected void initCommonContext() {
        commonContext = new HashMap<String, Object>();
        List<Field> fields = new ArrayList<Field>();
        Connection conn = null;
        Statement st = null;
        ResultSet rs = null;
        Set<String> ip = null;
        Field pkField = new Field();
        String pkId = "";
        String pkName = "";
        String pkType = "";
        String pkSimpleType = "";
        Map<String, String> comment = new HashMap<String, String>();
        try {
            log.info("正在初始化表：" +tableName+ "元数据...");
            conn = ConnectionPool.getConnection();
            DatabaseMetaData dmd = conn.getMetaData();
            rs = dmd.getPrimaryKeys(null, null, tableName);
            if (rs.next()) {
                pkId = rs.getString("COLUMN_NAME");
                pkName = rs.getString("PK_NAME");
            }

            // 获取列的注释
            rs = dmd.getColumns(null, null, tableName, null);
            int ix = 1;
            while (rs.next()) {
                comment.put(String.valueOf(ix), rs.getString("REMARKS"));
                ix += 1;
            }

            st = conn.createStatement();
            rs = st.executeQuery("select * from " + tableName);
            ResultSetMetaData meta= rs.getMetaData();
            Field field = null;
            String propertyName = "";
            String fieldName = "";
            String javaType = "";
            ip = new HashSet<String>();
            System.out.println(meta.getColumnCount());
            for (int i = 1; i <= meta.getColumnCount(); i++) {
                fieldName = meta.getColumnName(i);
                javaType = meta.getColumnClassName(i);
                propertyName = MetaDataUtil.fieldToProperty(fieldName);
                field = new Field();
                field.setPropertyName(propertyName);
                field.setFieldName(meta.getColumnName(i));
                field.setSetterName(MetaDataUtil.createSetterName(propertyName));
                field.setGetterName(MetaDataUtil.createGetterName(propertyName));
                field.setJavaType(MetaDataUtil.createJavaType(meta.getColumnClassName(i)));
                field.setJdbcType(meta.getColumnTypeName(i));
                field.setJavaFullType(meta.getColumnClassName(i));
                field.setComment(comment.get(String.valueOf(i)));
                fields.add(field);
                // 一定要放在最后
                if (pkId.equals(fieldName)) {
                    pkType = javaType;
                    pkSimpleType = MetaDataUtil.createJavaType(meta.getColumnClassName(i));
                    if (pkSimpleType.equals("Integer")) {
                        pkSimpleType = "int";
                    } else if (pkSimpleType.equals("Long")) {
                        pkSimpleType = "long";
                    }
                    pkField = field;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            log.info("初始化表：" +tableName+ "元数据失败", e);
        } finally {
            ConnectionPool.close(rs);
            ConnectionPool.close(st);
            ConnectionPool.close(conn);
        }
        commonContext.put(CLASS_NAME, className);
        commonContext.put(TABLE_NAME, tableName);
        commonContext.put(INST_NAME, className.substring(0, 1).toLowerCase() + className.substring(1));
        commonContext.put(QUERY_INST_NAME, "query" + className);
        commonContext.put(FIELDS, fields);
        commonContext.put(PK_ID, pkId);
        commonContext.put(PK_SIMPLE_TYPE, pkSimpleType);
        commonContext.put(PK_NAME, pkName);
        commonContext.put(PK_TYPE, pkType);
        commonContext.put(PK_FILED, pkField);
        context.putAll(commonContext);
        if ("true".equals(prop.getProperty(ANOTATION))) {
            context.put("Resource", "@Resource");
            context.put("Component", "@Component");
        }
        this.setImports(ip);
        log.info("元数据初始化完成。");
        System.out.println();
    }

    public void initLocation() {
        String path = this.getPackagee();
        location = prop.getProperty(this.classType + ".out.path");
        // 为减少配置,config.properties中并没有配置impl的输出位置
        // 因此在生成impl类时需要替换其中中impl获取得其接口的输出位置
        if (StringUtils.isBlank(location)) {
            String str = "";
            // 替换掉impl用接口的输出位置
            // 如:在生成dao.impl时,实际上取的是配置文件中
            // dao.out.path的值
            if (this.classType.indexOf(".impl") != -1) {
                str = this.classType.substring(0, this.classType.indexOf(".impl"));
            }
            location = prop.getProperty(str + ".out.path");
        }
        // 除了sqlmap之外其它文件的输出位置均与package有关
        if (StringUtils.isNotBlank(path)) {
            path = path.replace(".", System.getProperty("file.separator"));
            location += System.getProperty("file.separator") + path;
        }
        location += System.getProperty("file.separator");
        try {
            FileUtils.forceMkdir(new File(location));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void initClassMetaInfo() {
        context.put(PACKAGE_NAME, this.getPackagee());
        context.put(AUTHOR, prop.getProperty("class.author"));
        context.put("year", DateFormatUtils.format(System.currentTimeMillis(), "yyyy"));
        context.put("dataTime", DateFormatUtils.format(System.currentTimeMillis(), "yyyy-MM-ddHH:mm:ss"));
    }

    public void generate() {
        try {
            log.info("正在生成" + context.get(CLASS_NAME) + " -> " + this.classType + "代码。。。");
            Properties p = new Properties();
            p.put("resource.loader","file");
            p.put("file.resource.loader.class","org.apache.velocity.runtime.resource.loader.FileResourceLoader");
            p.put("file.resource.loader.path",FileUtils.toFile(CgTest.class.getResource("/com/pz/cg/vm/")).getAbsolutePath());
            p.put("input.encoding",prop.getProperty("in.encoding"));
            p.put("output.encoding",prop.getProperty("out.encoding"));
            Velocity.init(p);
            //Template template= Velocity.getTemplate("./resources/com/pz/cg/vm/" +this.getTemplate());
            Template template =Velocity.getTemplate(this.getTemplate());
            VelocityContext ctx= new VelocityContext(context);
            //Writer writer =new StringWriter();
            Writer writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(new File(this.getLocation() + "/" + this.getFileName())),prop.getProperty("out.encoding")));
            template.merge(ctx,writer);
            writer.flush();
            writer.close();
            log.info("生成 " +context.get(CLASS_NAME) + " -> " + this.classType + "代码结束.");
            log.info("输出位置:" +this.getLocation() + this.getFileName());
            System.out.println();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //清理common上下文
    public static void clearContext() {
        commonContext = null;
    }


    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getPackagee() {
        return packagee;
    }

    public void setPackagee(String packagee) {
        this.packagee = packagee;
    }

    public Set<String> getImports() {
        return imports;
    }

    public void setImports(Set<String> imports) {
        this.imports = imports;
    }

    public String getTemplate() {
        return template;
    }

    public void setTemplate(String template) {
        this.template = template;
    }

    public static Properties getProp() {
        return prop;
    }
}
