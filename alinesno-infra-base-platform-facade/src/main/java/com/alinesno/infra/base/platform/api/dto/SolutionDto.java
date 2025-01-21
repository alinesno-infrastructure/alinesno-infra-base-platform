package com.alinesno.infra.base.platform.api.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * 方案数据传输对象
 */
@NoArgsConstructor
@Data
public class SolutionDto {

    private String title;  // 方案标题
    private String content;  // 方案内容
    private String link;  // 方案链接
    private Date addDate ;  // 添加日期

    public SolutionDto(String title, String content, String link, Date addTime) {
        this.title = title;
        this.content = content;
        this.link = link;
        this.addDate = addTime;
    }
}
