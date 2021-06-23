package com.tongwudi.algorithm.bean;

import lombok.Data;

@Data
public class SimpleEmailEntity {
    /**

     * 主题
     */
    private String subject;

    /**

     * 主题内容
     */
    private String content;

    /**

     * 接收人邮箱列表
     */
    private String[] tos;
}
