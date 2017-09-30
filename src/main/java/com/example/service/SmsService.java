/**
 * Copyright (C) 2017 IFlyTek. All rights reserved.
 */
package com.example.service;

import com.example.domain.vo.EmailVo;
import com.example.domain.vo.ResponseVo;

/**
 * <p>
 * <code>SmsService</code>
 * </p>
 * Description:
 *
 * @author Mcchu
 * @date 2017/9/29 14:27
 */
public interface SmsService {

    ResponseVo<String> sendEmail(EmailVo emailVo);

    ResponseVo<String> sendEmailByFreemarker(EmailVo emailVo);
}
