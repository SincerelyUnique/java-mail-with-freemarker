/**
 * Copyright (C) 2017 IFlyTek. All rights reserved.
 */
package com.example.controller;

import com.example.domain.vo.EmailVo;
import com.example.domain.vo.ResponseVo;
import com.example.service.SmsService;
import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * <p>
 * <code>SmsController</code>
 * </p>
 * Description:
 *
 * @author Mcchu
 * @date 2017/9/29 14:21
 */
@Controller
@Log4j
public class SmsController {

    @Autowired
    SmsService smsService;

    @PostMapping("sendEmail")
    @ResponseBody
    public ResponseVo sendEmail(EmailVo emailVo){
        try {
            log.info("发送邮件：");
            return smsService.sendEmail(emailVo);
        }catch (Exception e){
            e.printStackTrace();
            log.info("邮件发送失败!",e);
            return new ResponseVo("10000","error","");
        }
    }

    @PostMapping("sendEmailByFreemarker")
    @ResponseBody
    public ResponseVo sendEmailByFreemarker(EmailVo emailVo){
        try {
            log.info("发送邮件：");
            return smsService.sendEmailByFreemarker(emailVo);
        }catch (Exception e){
            e.printStackTrace();
            log.info("邮件发送失败!",e);
            return new ResponseVo("10000","error","");
        }
    }
}
