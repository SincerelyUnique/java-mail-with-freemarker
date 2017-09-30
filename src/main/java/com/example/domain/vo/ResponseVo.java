/**
 * Copyright (C) 2017 IFlyTek. All rights reserved.
 */
package com.example.domain.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * <p>
 * <code>ResponseVo</code>
 * </p>
 * Description:
 *
 * @author Mcchu
 * @date 2017/9/29 14:29
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResponseVo<T> {

    private String code;

    private String msg;

    private T content;
}
