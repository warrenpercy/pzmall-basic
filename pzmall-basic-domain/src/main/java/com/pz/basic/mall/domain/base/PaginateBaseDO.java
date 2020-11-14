package com.pz.basic.mall.domain.base;

import java.io.Serializable;

/**
 * @author percy
 * @date 2020/8/21 10:11
 */
public class PaginateBaseDO implements Serializable {
    /**
     * 默认每页的记录数量
     */
    public static final int PAGESIZE_DEFAULT = 20;
    /**
     * 每页大小
     */
    private long pageSize;
    /**
     * 当前页。第一页是1
     */
    private long page;

    /**
     * 总记录数
     */
    private long totalItem;
    /**
     * 总页数
     */
    private long totalPage;

    /**
     * 分页后的记录开始的地方
     * 第一条记录是1
     */
    private long startRow;
    /**
     * 分页后的记录结束的地方
     */
    private long endRow;

    /**排序字段**/
    private String orderField;

    /**升序 还是 降序,true为升序，false为降序*/
    private Boolean isAsc;

    /**
     * 默认构造方法
     */
    public PaginateBaseDO() {
        repaginate();
    }

    /**
     * 带当前页和页大小的构造方法
     * @param page 当前页
     * @param pageSize 页大小
     */
    public PaginateBaseDO(long page, long pageSize) {
        this.page = page;
        this.pageSize =pageSize;
        repaginate();
    }

    public void setStartRow(long startRow) {
        this.startRow =startRow;
    }

    public void setEndRow(long endRow) {
        this.endRow =endRow;
    }

    /**
     * 表示是不是第一页
     * @return true 是; false 不是
     */
    public boolean isFirstPage(){
        return page <=1;
    }


    public boolean isMiddlePage() {
        return!(isFirstPage() || isLastPage());
    }


    public boolean isLastPage() {
        return page >=totalPage;
    }


    public boolean isNextPageAvailable() {
        return !isLastPage();
    }

    public boolean isPreviousPageAvailable() {
        return!isFirstPage();
    }

    /**
     * 下一页号
     * @return 取得下一页号
     */
    public long getNextPage() {
        if(isLastPage()) {
            return totalItem;
        } else {
            return page+1;
        }
    }

    public long getPreviousPage() {
        if(isFirstPage()){
            return 1;
        } else {
            return page -1;
        }
    }
    /**
     * Method getPageSizereturns the pageSize of this PaginatedArrayList object.
     *
     *  每页大小
     *
     * @return thepageSize (type int) of this PaginatedArrayList object.
     */

    public long getPageSize() {
        return pageSize;
    }

    /**
     * Method setPageSizesets the pageSize of this PaginatedArrayList object.
     *
     *  每页大小
     *
     * @param pageSize thepageSize of this PaginatedArrayList object.
     *
     */

    public void setPageSize(long pageSize) {
        this.pageSize =pageSize;
        repaginate();
    }

    /**
     * Method getpagereturns the page of this PaginatedArrayList object.
     *
     *  当前页。第一页是1
     *
     * @return the page(type int) of this PaginatedArrayList object.
     */

    public long getPage(){
        return page;
    }

    /**
     * Method setpage setsthe page of this PaginatedArrayList object.
     *
     *  当前页。第一页是1
     *
     * @param page thepage of this PaginatedArrayList object.
     *
     */

    public void setPage(long page) {
        this.page = page;
        repaginate();
    }

    /**
     * Method getTotalItemreturns the totalItem of this PaginatedArrayList object.
     *
     *  总记录数
     *
     * @return thetotalItem (type int) of this PaginatedArrayList object.
     */

    public long getTotalItem() {
        return totalItem;
    }

    /**
     * Method setTotalItemsets the totalItem of this PaginatedArrayList object.
     *
     *  总记录数
     *
     * @param totalItem the totalItem of this PaginatedArrayList object.
     *
     */

    public void setTotalItem(long totalItem) {
        this.totalItem =totalItem;
        if( this.totalItem<= 0){
            totalPage = 0;
            page = 1;
            startRow = 0;
        }
        repaginate();
    }



    /**
     * Method getTotalPagereturns the totalPage of this PaginatedArrayList object.
     *
     *  总页数
     *
     * @return thetotalPage (type int) of this PaginatedArrayList object.
     */

    public long getTotalPage() {
        return totalPage;
    }

    /**
     * Method getStartRowreturns the startRow of this PaginatedArrayList object.
     *
     *  分页后的记录开始的地方
     *
     * @return the startRow(type int) of this PaginatedArrayList object.
     */

    public long getStartRow() {
        if (startRow >0) {
            return startRow;
        }
        if (page <= 0){
            page = 1;
        }
        return (page - 1)* pageSize;
    }

    /**
     * Method getEndRowreturns the endRow of this PaginatedArrayList object.
     *
     *  分页后的记录结束的地方
     *
     * @return the endRow(type int) of this PaginatedArrayList object.
     */

    public long getEndRow() {
        if (endRow > 0){
            return endRow;
        }
        return page *pageSize;
    }

    public String getOrderField() {
        return orderField;
    }


    public void setOrderField(String orderField) {
        this.orderField =orderField;
    }

    public Boolean getIsAsc() {
        return isAsc;
    }

    public void setIsAsc(Boolean isAsc) {
        this.isAsc = isAsc;
    }

    /**
     * Method repaginate...
     */
    public void repaginate() {
        if (pageSize <1) { //防止程序偷懒，list和分页的混合使用
            pageSize =PAGESIZE_DEFAULT;
        }
        if (page < 1) {
            page = 1;//恢复到第一页
        }
        if (totalItem >0) {
            totalPage =totalItem / pageSize + (totalItem % pageSize > 0 ? 1 : 0);
            if(page >totalPage) {
                page =totalPage; //最大页
            }
            endRow = page* pageSize;
            startRow =(page - 1) * pageSize;
            if(endRow>totalItem) {
                endRow =totalItem;
            }
        }
    }

}
