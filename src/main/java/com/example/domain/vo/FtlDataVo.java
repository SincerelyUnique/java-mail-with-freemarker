/**
 * Copyright (C) 2017 IFlyTek. All rights reserved.
 */
package com.example.domain.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * <p>
 * <code>FtlDataVo</code>
 * </p>
 * Description:评审表单实体
 *
 * @author Mcchu
 * @date 2017/9/30 13:45
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class FtlDataVo {

    // 轮次
    private Integer count;

    // 专业方向
    private String type;

    // 评审人
    private String username;

    // 评审结果
    private String reviewResult;

    // 评审意见
    private String reviewOpintion;

    // 反馈意见
    private String feedback;
}
