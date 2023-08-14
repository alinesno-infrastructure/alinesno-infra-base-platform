package com.alinesno.infra.base.platform.entity;

import cn.afterturn.easypoi.excel.annotation.Excel;
import com.alinesno.infra.common.facade.mapper.entity.InfraBaseEntity;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;

/**
 * 这是一个用于存储云内容的实体类
 *
 * @author luoxiaodong
 * @version 1.0.0
 */
@TableName("cloud_content")
public class CloudContentEntity extends InfraBaseEntity {

    /**
     * 内容类型
     */
    @Excel(name = "内容类型")
    @TableField("content_type_value")
    private String contentTypeValue;

    /**
     * 标题
     */
    @Excel(name = "标题")
    @TableField("title")
    private String title;

    /**
     * 内容描述
     */
    @TableField("content_desc")
    private String contentDesc;

    /**
     * 背景图片
     */
    @TableField("banner")
    private String banner;

    /**
     * 图片描述
     */
    @TableField("banner_desc")
    private String bannerDesc;

    /**
     * 查看次数
     */
    @TableField("view_count")
    private int viewCount ;

    public int getViewCount() {
        return viewCount;
    }

    public void setViewCount(int viewCount) {
        this.viewCount = viewCount;
    }

    public String getContentTypeValue() {
        return contentTypeValue;
    }

    public void setContentTypeValue(String contentTypeValue) {
        this.contentTypeValue = contentTypeValue;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContentDesc() {
        return contentDesc;
    }

    public void setContentDesc(String contentDesc) {
        this.contentDesc = contentDesc;
    }

    public String getBanner() {
        return banner;
    }

    public void setBanner(String banner) {
        this.banner = banner;
    }

    public String getBannerDesc() {
        return bannerDesc;
    }

    public void setBannerDesc(String bannerDesc) {
        this.bannerDesc = bannerDesc;
    }

    @Override
    public String toString() {
        return "CloudContentEntity{" +
                "contentTypeValue='" + contentTypeValue + '\'' +
                ", title='" + title + '\'' +
                ", contentDesc='" + contentDesc + '\'' +
                ", banner='" + banner + '\'' +
                ", bannerDesc='" + bannerDesc + '\'' +
                '}';
    }
}
