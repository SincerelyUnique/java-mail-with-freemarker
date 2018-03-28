/**
 * Copyright (C) 2017 IFlyTek. All rights reserved.
 */
package com.example.domain.entry;

import com.example.util.StringHelper;

import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.*;
import javax.mail.internet.*;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Date;
import java.util.Properties;

/**
 * <p>
 * <code>Email</code>
 * </p>
 * Description:
 *
 * @author Mcchu
 * @date 2017/9/29 14:50
 */
public class Email {
    /** 发件方式 - 普通发送 */
    public static final int TO = 0;
    /** 发件方式 - 抄送 */
    public static final int CC = 1;
    /** 发件方式 - 密件抄送 */
    public static final int BCC = 2;

    /** 邮件相关信息 - SMTP 服务器 */
    private String mailSMTPHost = null;
    /** 邮件相关信息 - 邮件用户名 */
    private String mailUser = null;
    /** 邮件相关信息 - 密码 */
    private String mailPassword = null;
    /** 邮件相关信息 - 发件人邮件地址 */
    private String mailFromAddress = null;
    /** 邮件相关信息 - 邮件主题 */
    private String mailSubject = "";
    /** 邮件相关信息 - 邮件发送地址 */
    private Address[] mailTOAddress = null;
    /** 邮件相关信息 - 邮件抄送地址 */
    private Address[] mailCCAddress = null;
    /** 邮件相关信息 - 邮件密件抄送地址 */
    private Address[] mailBCCAddress = null;
    /** 邮件相关信息 - 邮件正文(复合结构) */
    private MimeMultipart mailBody = null;

    public Email() {
        mailBody = new MimeMultipart();
    }

    /**
     * 设置 SMTP 服务器
     *
     * @param strSMTPHost 邮件服务器名称或 IP
     * @param strUser 邮件用户名
     * @param strPassword 密码
     */
    public void setSMTPHost(String strSMTPHost, String strUser, String strPassword) {
        this.mailSMTPHost = strSMTPHost;
        this.mailUser = strUser;
        this.mailPassword = strPassword;
    }

    /**
     * 设置邮件发送地址
     *
     * @param strFromAddress 邮件发送地址
     */
    public void setFromAddress(String strFromAddress) {
        this.mailFromAddress = strFromAddress;
    }

    /**
     * 设置邮件目的地址
     *
     * @param strAddress 邮件目的地址列表, 不同的地址可用;号分隔
     * @param iAddressType 邮件发送方式 (TO 0, CC 1, BCC 2) 常量已在本类定义
     */
    public void setAddress(String strAddress, int iAddressType) {
        switch (iAddressType) {
            case Email.TO: {
                String[] alAddress = StringHelper.split(strAddress, ";");
                mailTOAddress = new Address[alAddress.length];
                for (int i = 0; i < alAddress.length; i++) {
                    try {
                        mailTOAddress[i] = new InternetAddress((String) alAddress[i]);
                    } catch (AddressException e) {
                        System.out.println("收件箱地址错误!");
                        e.printStackTrace();
                    }
                }
                break;
            }
            case Email.CC: {
                String[] alAddress = StringHelper.split(strAddress, ";");
                mailCCAddress = new Address[alAddress.length];
                for (int i = 0; i < alAddress.length; i++) {
                    try {
                        mailCCAddress[i] = new InternetAddress((String) alAddress[i]);
                    } catch (AddressException e) {
                        System.out.println("抄送地址错误!");
                        e.printStackTrace();
                    }
                }
                break;
            }
            case Email.BCC: {
                String[] alAddress = StringHelper.split(strAddress, ";");
                mailBCCAddress = new Address[alAddress.length];
                for (int i = 0; i < alAddress.length; i++) {
                    try {
                        mailBCCAddress[i] = new InternetAddress((String) alAddress[i]);
                    } catch (AddressException e) {
                        System.out.println("密件抄送地址错误!");
                        e.printStackTrace();
                    }
                }
                break;
            }
        }
    }

    /**
     * 设置邮件主题
     *
     * @param strSubject 邮件主题
     */
    public void setSubject(String strSubject) {
        this.mailSubject = strSubject;
    }

    /**
     * 设置邮件文本正文
     *
     * @param strTextBody 邮件文本正文
     */
    public void setTextBody(String strTextBody) {
        MimeBodyPart mimebodypart = new MimeBodyPart();
        try {
            mimebodypart.setText(strTextBody, "GBK");
        } catch (MessagingException e) {
            System.out.println("邮件文本正文设置错误!");
            e.printStackTrace();
        }
        try {
            mailBody.addBodyPart(mimebodypart);
        } catch (MessagingException e) {
            System.out.println("邮件文本正文增加错误!");
            e.printStackTrace();
        }
    }

    /**
     * 设置邮件超文本正文
     *
     * @param strHtmlBody 邮件超文本正文
     */
    public void setHtmlBody(String strHtmlBody) {
        MimeBodyPart mimebodypart = new MimeBodyPart();
        try {
            mimebodypart.setDataHandler(new DataHandler(strHtmlBody, "text/html;charset=GBK"));
        } catch (MessagingException e) {
            System.out.println("邮件超文本正文设置错误!");
            e.printStackTrace();
        }
        try {
            mailBody.addBodyPart(mimebodypart);
        } catch (MessagingException e) {
            System.out.println("邮件超文本正文增加错误!");
            e.printStackTrace();
        }
    }

    /**
     * 设置邮件正文外部链接 URL, 信体中将包含链接所指向的内容
     *
     * @param strURLAttachment 邮件正文外部链接 URL
     */
    public void setURLAttachment(String strURLAttachment) {
        MimeBodyPart mimebodypart = new MimeBodyPart();
        try {
            mimebodypart.setDataHandler(new DataHandler(new URL(strURLAttachment)));
            mailBody.addBodyPart(mimebodypart);
        } catch (MalformedURLException e) {
            System.out.println("邮件正文外部链接 URL错误!");
            e.printStackTrace();
        } catch (MessagingException e) {
            System.out.println("邮件正文外部链接 URLMessage错误!");
            e.printStackTrace();
        }
    }

    /**
     * 设置邮件附件
     *
     * @param strFileAttachment 文件的全路径
     */
    public void setFileAttachment(String strFileAttachment) {
        File path = new File(strFileAttachment);
        if (!path.exists() || path.isDirectory()) {
            return;
        }
        String strFileName = path.getName();
        MimeBodyPart mimebodypart = new MimeBodyPart();
        try {
            mimebodypart.setDataHandler(new DataHandler(new FileDataSource(strFileAttachment)));
            mimebodypart.setFileName(MimeUtility.encodeText(strFileName));
            mailBody.addBodyPart(mimebodypart);
        } catch (MessagingException e) {
            System.out.println("附件设置错误");
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            System.out.println("附件设置编码错误");
            e.printStackTrace();
        }

    }

    /**
     * @description 邮件发送(一次发送多个地址, 优点速度快, 但是有非法邮件地址时将中断发送操作)
     * @param sysName 主题内容
     * @return 发送结果
     */
    // CSOFF: MethodLength
    public boolean sendBatch(String sysName) {
        Properties properties = new Properties();
        properties.put("mail.smtp.host", this.mailSMTPHost);
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.ssl.enable", "true");
        MyAuthenticator myauth = new MyAuthenticator(this.mailUser, this.mailPassword);
        Session session = Session.getDefaultInstance(properties, myauth);
        MimeMessage mimemessage = new MimeMessage(session);
        try {
            String nick = MimeUtility.encodeText(sysName);
            mimemessage.setFrom(new InternetAddress(nick + "<" + this.mailFromAddress + ">"));
        } catch (AddressException e) {
            System.out.println("发送邮箱Address异常!" + e.toString());
            return false;
        } catch (MessagingException e) {
            System.out.println("发送邮箱Messaging异常!" + e.toString());
            return false;
        } catch (UnsupportedEncodingException e) {
            System.out.println("发送邮箱异常!" + e.toString());
            return false;
        }
        try {
            if (mailTOAddress != null) {
                mimemessage.addRecipients(javax.mail.Message.RecipientType.TO, this.mailTOAddress);
            }
            if (mailCCAddress != null) {
                mimemessage.addRecipients(javax.mail.Message.RecipientType.CC, this.mailCCAddress);
            }
            if (mailBCCAddress != null) {
                mimemessage.addRecipients(javax.mail.Message.RecipientType.BCC, this.mailBCCAddress);
            }
        } catch (MessagingException e) {
            System.out.println("接受邮箱Messaging异常!" + e.toString());
            return false;
        }
        try {
            mimemessage.setSubject(this.mailSubject);
        } catch (MessagingException e) {
            System.out.println("设置主题Messaging异常!" + e.toString());
            return false;
        }
        try {
            mimemessage.setContent(this.mailBody);
        } catch (MessagingException e) {
            System.out.println("设置内容Messaging异常!" + e.toString());
            return false;
        }
        try {
            mimemessage.setSentDate(new Date());
        } catch (MessagingException e) {
            System.out.println("设置发送日期Messaging异常!" + e.toString());
            return false;
        }
        Transport transport;
        try {
            transport = session.getTransport("smtp");
            transport.connect(this.mailSMTPHost, this.mailUser, this.mailPassword);
        } catch (NoSuchProviderException e) {
            System.out.println("获取SMTP时NoSuchProvider异常!" + e.toString());
            return false;
        } catch (MessagingException e) {
            System.out.println("连接发送邮箱服务器Messaging异常!" + e.toString());
            return false;
        }
        try {
            Transport.send(mimemessage);
        } catch (MessagingException e) {
            System.out.println("邮件发送Messaging异常!" + e.toString());
            return false;
        }
        //emailPrint();
        return true;
    }

    // CSOFF: MethodLength

    /**
     * @description 邮件信息打印
     */
    private void emailPrint() {
        System.out.println("已向下列邮箱发送了邮件");
        if (mailTOAddress != null) {
            for (int i = 0; i < mailTOAddress.length; i++) {
                System.out.println(mailTOAddress[i]);
            }
        }
        if (mailCCAddress != null) {
            for (int i = 0; i < mailTOAddress.length; i++) {
                System.out.println(mailCCAddress[i]);
            }
        }
        if (mailBCCAddress != null) {
            for (int i = 0; i < mailTOAddress.length; i++) {
                System.out.println(mailBCCAddress[i]);
            }
        }
    }
}

/**
 * @function 校验发信人权限
 */
class MyAuthenticator extends javax.mail.Authenticator {
    /**
     * 用户名
     */
    private String strUser;
    /**
     * 密码
     */
    private String strPwd;

    public MyAuthenticator(String user, String password) {
        this.strUser = user;
        this.strPwd = password;
    }

    protected PasswordAuthentication getPasswordAuthentication() {
        return new PasswordAuthentication(strUser, strPwd);
    }
}
