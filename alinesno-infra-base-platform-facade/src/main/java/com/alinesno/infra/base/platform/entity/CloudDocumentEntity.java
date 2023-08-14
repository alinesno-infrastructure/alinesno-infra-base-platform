package com.alinesno.infra.base.platform.entity;

import cn.afterturn.easypoi.excel.annotation.Excel;
import com.alinesno.infra.common.facade.mapper.entity.InfraBaseEntity;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;

/**
 * 这是一个用于存储云文档的实体类
 *
 * @author luoxiaodong
 * @version 1.0.0
 */
@TableName("cloud_document")
public class CloudDocumentEntity extends InfraBaseEntity {

    /**
     * 文档类型
     */
    @Excel(name = "文档类型")
    @TableField("document_type")
    private String documentType;

    /**
     * 链接名称
     */
    @Excel(name = "链接名称")
    @TableField("link_name")
    private String linkName;

    /**
     * 链接地址
     */
    @Excel(name = "链接地址")
    @TableField("link_path")
    private String linkPath;

    /**
     * 链接图标
     */
    @Excel(name = "链接图标")
    @TableField("link_logo")
    private String linkLogo;

    /**
     * 链接描述
     */
    @TableField("link_desc")
    private String linkDesc;

    /**
     * 链接打开状态
     */
    @Excel(name = "链接打开状态")
    @TableField("link_target")
    private String linkTarget;

    /**
     * 链接状态
     */
    @Excel(name = "链接状态")
    @TableField("link_design")
    private String linkDesign;

    /**
     * 链接排序
     */
    @Excel(name = "链接排序")
    @TableField("link_sort")
    private Integer linkSort;


    public String getDocumentType() {
        return documentType;
    }

    public void setDocumentType(String documentType) {
        this.documentType = documentType;
    }

    public String getLinkName() {
        return linkName;
    }

    public void setLinkName(String linkName) {
        this.linkName = linkName;
    }

    public String getLinkPath() {
        return linkPath;
    }

    public void setLinkPath(String linkPath) {
        this.linkPath = linkPath;
    }

    public String getLinkLogo() {
        return linkLogo;
    }

    public void setLinkLogo(String linkLogo) {
        this.linkLogo = linkLogo;
    }

    public String getLinkDesc() {
        return linkDesc;
    }

    public void setLinkDesc(String linkDesc) {
        this.linkDesc = linkDesc;
    }

    public String getLinkTarget() {
        return linkTarget;
    }

    public void setLinkTarget(String linkTarget) {
        this.linkTarget = linkTarget;
    }

    public String getLinkDesign() {
        return linkDesign;
    }

    public void setLinkDesign(String linkDesign) {
        this.linkDesign = linkDesign;
    }

    public Integer getLinkSort() {
        return linkSort;
    }

    public void setLinkSort(Integer linkSort) {
        this.linkSort = linkSort;
    }

    @Override
    public String toString() {
        return "CloudDocumentEntity{" +
                "documentType='" + documentType + '\'' +
                ", linkName='" + linkName + '\'' +
                ", linkPath='" + linkPath + '\'' +
                ", linkLogo='" + linkLogo + '\'' +
                ", linkDesc='" + linkDesc + '\'' +
                ", linkTarget='" + linkTarget + '\'' +
                ", linkDesign='" + linkDesign + '\'' +
                ", linkSort=" + linkSort +
                '}';
    }
}
