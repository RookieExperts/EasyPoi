package com.easypoi.domain;


import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

/**
 * UserDomain
 * @author brb
 * @date 2020年08月30日
 */
@Data
@TableName(value = "e_user")
public class UserDomain {

    private Integer userId;

    private Integer sex;

    private BigDecimal money;

    private String userName;

    private Float price;

    private Date now;
}