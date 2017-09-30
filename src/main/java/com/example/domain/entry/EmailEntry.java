/**
 * Copyright (C) 2017 IFlyTek. All rights reserved.
 */
package com.example.domain.entry;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * <p>
 * <code>EmailEntry</code>
 * </p>
 * Description:
 *
 * @author Mcchu
 * @date 2017/9/29 14:43
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmailEntry {

    /**
     * 收件人集合
     */
    public List<String> receivers = new ArrayList<String>();

    /**
     * 抄送人集合
     */
    public List<String> copyReceivers = new ArrayList<String>();

    /**
     * 内容文本
     */
    public String context = null;

    /**
     * 邮件主题名称
     */
    public String subject;

    /**
     * 邮件内容标题
     */
    public String title = null;

    /**
     * 附件路径
     */
    public List<String> filePath;

    /**
     * 邮件时间格式
     */
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日");


    /**
     * 获取html格式的邮件
     *
     * @description
     * @author bgfang
     * @create 2015年6月26日 20:20:21
     * @version 1.0
     * @param sysName 系统名称或系统管理员
     * @param officeName 办公室名字
     * @param rootServer （服务器）链接地址
     * @return 返回html格式的文本
     */
    public String getHtmlEmilContext(String sysName, String officeName, String rootServer) {
        StringBuffer emilContext = new StringBuffer();
        if (title != null) {
            emilContext.append("<h1>" + this.title + "</h1>");
        }
        if (context != null) {
            emilContext.append(this.context + "<br />");
        }
        emilContext.append("<p style='font-size: 12px;font-weight: bold;'>");
        emilContext.append(officeName + " <br /><br />");
        emilContext.append(sdf.format(new Date()));
        emilContext.append("<br /><br />" + sysName + "<a href='");
        emilContext.append(rootServer).append("'>");
        emilContext.append(rootServer);
        emilContext.append("</a></p>");
        emilContext.append("(这是一封自动产生的email，请勿回复)");
        return emilContext.toString();
    }
}
