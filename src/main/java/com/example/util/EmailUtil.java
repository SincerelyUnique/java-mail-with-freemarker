/**
 * Copyright (C) 2017 IFlyTek. All rights reserved.
 */
package com.example.util;

import com.example.domain.entry.Email;
import com.example.domain.entry.EmailEntry;
import org.springframework.util.StringUtils;

import java.util.List;

/**
 * <p>
 * <code>EmailUtil</code>
 * </p>
 * Description:
 *
 * @author Mcchu
 * @date 2017/9/29 14:41
 */
public class EmailUtil {

    public static EmailEntry createEmail(List<String> emailAddressList,String subject,String context){
        EmailEntry entry = new EmailEntry();
        entry.setSubject(subject);
        entry.setContext(context);
        entry.setReceivers(emailAddressList);
        return entry;
    }

    public static Boolean sendEmail(EmailEntry entry){
        Email mail = new Email();

        // 1.设置地址
        String generalAddress = convertListToString(entry.getReceivers());
        mail.setAddress(generalAddress,Email.TO);

        String copyAddress = convertListToString(entry.getCopyReceivers());
        if (!StringUtils.isEmpty(copyAddress)){
            mail.setAddress(copyAddress, Email.CC);
        }

        // 2.设置发送邮箱(保密)
        /** 邮件相关信息 - 发件人邮件地址（或者说是授权人的邮箱地址） */
        mail.setFromAddress("xxx@qq.com");
        /** 设置 SMTP 服务器:邮件服务器名称或 IP,邮件用户名,密码 */
        mail.setSMTPHost("smtp.qq.com", "xxx","xxx");

        // 3.邮件标题
        mail.setSubject(entry.subject);

        // 4.设置html格式文本
        mail.setHtmlBody(entry.getHtmlEmilContext("xxx管理员", "财务部办公室", "http://www.baidu.com"));

        // 添加附件
        if (null != entry.getFilePath()) {
            for (String filePath : entry.getFilePath()) {
                mail.setFileAttachment(filePath);
            }
        }

        return mail.sendBatch("xxx管理员");
    }

    private static String convertListToString(List<String> addresses) {
        StringBuffer resultAddresses = new StringBuffer();
        if (null == addresses || addresses.size() == 0) {
            return null;
        }
        for (String address : addresses) {
            resultAddresses.append(address + ";");
        }
        return resultAddresses.toString();
    }
}
