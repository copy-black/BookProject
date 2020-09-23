package com.guigu.pojo;

import java.security.PrivateKey;
import java.util.List;


/**
 * TODO
 *
 * @author Administrator
 * @date 2020/9/25
 */
public class Page<T> {
    /**
     * Page是分页的模型对象
     * T是具体的模块的JavaBean类
     */
    public static  final Integer PAGE_SIZE=4;
    //当前页面
    private Integer pageNO;
    //总页码
    private Integer pageTotal;
    //当前页显示数量
    private Integer pageSize=PAGE_SIZE;
    //总记录数
    private  Integer pageTotalCount;
    //当前页面数据
    private  List<T> items;

    //分页跳的请求地址
    private  String url;


    public Integer getPageNO() {
        return pageNO;
    }

    public void setPageNO(Integer pageNO) {
        this.pageNO = pageNO;
    }

    public Integer getPageTotal() {
        return pageTotal;
    }

    public void setPageTotal(Integer pageTotal) {
        this.pageTotal = pageTotal;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getPageTotalCount() {
        return pageTotalCount;
    }

    public void setPageTotalCount(Integer pageTotalCount) {
        this.pageTotalCount = pageTotalCount;
    }

    public List<T> getItems() {
        return items;
    }

    public void setItems(List<T> items) {
        this.items = items;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "Page{" +
                "pageNO=" + pageNO +
                ", pageTotal=" + pageTotal +
                ", pageSize=" + pageSize +
                ", pageTotalCount=" + pageTotalCount +
                ", items=" + items +
                ", url='" + url + '\'' +
                '}';
    }
}

