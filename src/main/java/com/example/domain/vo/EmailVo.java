/**
 * Copyright (C) 2017 IFlyTek. All rights reserved.
 */
package com.example.domain.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * <p>
 * <code>EmailVo</code>
 * </p>
 * Description:
 *
 * @author Mcchu
 * @date 2017/9/29 14:25
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmailVo {

    private String address;

    private String sendPerson;
}
