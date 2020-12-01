package com.javasm.util;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class PageInfo {
    private Integer rows = 5; //每页条数
    private Integer total; //总条数
    private Integer page = 1; //当前的页码
    private Integer totalPage = 1; //总页码

    public void setTotal(Integer total) {
        this.total = total;
        totalPage = total / rows;
        if (total % rows > 0) {
            totalPage++;
        }
    }

    /**
     * 是否有下一页
     *
     * @return
     */
    public boolean hashNextPage() {
        if (page < totalPage) {
            page++;
            return true;
        } else {
            return false;
        }
    }

    /**
     * 是否有上一页
     *
     * @return
     */
    public boolean hashUpPage() {
        if (page > 1) {
            page--;
            return true;
        } else {
            return false;
        }
    }

    /**
     * 获取当前的开始索引
     *
     * @return
     */
    public int getNowIndex() {
        return (page - 1) * rows;
    }

}
