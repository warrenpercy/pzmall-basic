package com.pz.basic.mall.domain.base;

import java.util.List;

/**
 * @author percy
 * @date 2020/8/21 11:01
 */
public class Result<T> {

    // 是否成功的标识
    private boolean success;
    // 传递消息
    private String message;
    // 数据总数
    private long totalItem;
    // 当前页码
    private long page;
    // 每页数据条数
    private long pageSize;
    // 成功时返回的数据
    private T model;

    public void addDefaultModel(T model){
        this.model = model;
    }

    public void addDefaultModel(String message, T model){
        this.model = model;
        this.message = message;
    }

    public Result() {
        super();
    }

    public Result(boolean success) {
        this.success = success;
    }

    public Result(boolean success, String message) {
        this.success = success;
        this.message = message;
    }

    public Result(boolean success, T data) {
        this.success = success;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public long getTotalItem() {
        return totalItem;
    }

    public void setTotalItem(long totalItem) {
        this.totalItem = totalItem;
    }

    public long getPageSize() {
        return pageSize;
    }

    public void setPageSize(long pageSize) {
        this.pageSize = pageSize;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public long getPage() {
        return page;
    }

    public void setPage(long page) {
        this.page = page;
    }

    public T getModel() {
        return model;
    }

    public void setModel(T model) {
        this.model = model;
    }
}
