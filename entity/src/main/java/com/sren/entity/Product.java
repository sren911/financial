package com.sren.entity;


import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Data
public class Product {

    @Id
    String id;
    private String name;

    @ApiModelProperty(value = "状态", dataType = "com.sren.entity.enums.ProductStatus")
    private String status ;
    //起投金额
    private BigDecimal thresholdAmount ;
    //投资步长
    private BigDecimal stepAmount;
    //锁定期
    private Integer lockTerm;
    //收益率，因为要与其他数相乘，所以使用BigDecimal
    private BigDecimal rewardRate;
    private String memo;
    private Date createAt;
    private Date updateAt;
    private String createUser;
    private String updateUser;
}
