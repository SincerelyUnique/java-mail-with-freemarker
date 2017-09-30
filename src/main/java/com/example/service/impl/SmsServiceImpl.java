/**
 * Copyright (C) 2017 IFlyTek. All rights reserved.
 */
package com.example.service.impl;

import com.example.domain.entry.EmailEntry;
import com.example.domain.vo.EmailVo;
import com.example.domain.vo.FtlDataVo;
import com.example.domain.vo.ResponseVo;
import com.example.service.SmsService;
import com.example.util.EmailUtil;
import freemarker.template.Configuration;
import freemarker.template.TemplateException;
import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * <code>SmsServiceImpl</code>
 * </p>
 * Description:
 *
 * @author Mcchu
 * @date 2017/9/29 14:28
 */
@Service
@Log4j
public class SmsServiceImpl implements SmsService{

    @Autowired
    private Configuration freemarkerConfiguration;

    /**
     * 发送邮件,不通过模板
     * @param emailVo 页面传参
     * @return 结果
     */
    public ResponseVo<String> sendEmail(EmailVo emailVo) {
        String emailAddress = emailVo.getAddress();

        List<String> emailAddressList = new ArrayList<String>();
        emailAddressList.add(emailAddress);
        EmailEntry entry = EmailUtil.createEmail(emailAddressList,"发送简单邮件","发送简单邮件，不通过配置Freemarker模板。");
        Boolean sendResult = EmailUtil.sendEmail(entry);

        if (sendResult){
            log.info("邮件发送成功！");
            return new ResponseVo<String>("10000","邮件发送成功！","");
        }

        return new ResponseVo<String>("10001","邮件发送失败！","");
    }

    /**
     * 通过模板发送邮件
     * @param emailVo 页面传参
     * @return 结果
     */
    public ResponseVo<String> sendEmailByFreemarker(EmailVo emailVo) {
        String emailAddress = emailVo.getAddress();

        List<String> emailAddressList = new ArrayList<String>();
        emailAddressList.add(emailAddress);

        Map<String,Object> resultMap = (Map<String,Object>)createByFreemarker();
        String body = (String)resultMap.get("body");

        EmailEntry entry = EmailUtil.createEmail(emailAddressList,"通过Freemarker模板发送邮件",body);
        Boolean sendResult = EmailUtil.sendEmail(entry);

        if (sendResult){
            log.info("邮件发送成功！");
            return new ResponseVo<String>("10000","邮件发送成功！","");
        }

        return new ResponseVo<String>("10001","邮件发送失败！","");
    }

    /**
     * 封装假数据
     * @return  map
     * @throws IOException 抛io异常
     * @throws TemplateException 抛模板异常
     */
    private Map<String,Object> createByFreemarker(){
        Map<String,Object> resultMap = new HashMap<String,Object>();

        FtlDataVo vo1 = new FtlDataVo(1,"jjfa","小红","通过","由于xxx原因评审通过。","");
        FtlDataVo vo2 = new FtlDataVo(2,"jjfa","小白","未通过","由于xxx原因评审未通过。","意见");
        FtlDataVo vo3 = new FtlDataVo(5,"cjfa","小黑","未通过","由于xxx原因评审未通过。","意见");
        FtlDataVo vo4 = new FtlDataVo(4,"xsclysw","小可","通过","由于xxx原因评审通过。","");
        FtlDataVo vo5 = new FtlDataVo(3,"jffa","小明","通过","由于xxx原因评审通过。","");

        List<FtlDataVo> records = new ArrayList<FtlDataVo>();
        records.add(vo1);
        records.add(vo2);
        records.add(vo3);
        records.add(vo4);
        records.add(vo5);

        try {
            Map<String,Object> map = new HashMap<String,Object>();
            map.put("records",records);
            map.put("requisitionName","小新");
            map.put("distributeCount",5);
            String body = FreeMarkerTemplateUtils.processTemplateIntoString(
                    freemarkerConfiguration.getTemplate("email-format-dh.ftl"), map);

            resultMap.put("body",body);
        }catch (Exception e){
            e.printStackTrace();
            log.error(e);
        }

        return resultMap;
    }

}
