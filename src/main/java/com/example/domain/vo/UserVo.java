/**
 * Copyright (C) 2017 IFlyTek. All rights reserved.
 */
package com.example.domain.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * <p>
 * <code>User</code>
 * </p>
 * Description:
 *
 * @author Mcchu
 * @date 2017/9/26 14:15
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserVo {

    private String username;

    private String password;
}
