package com.sren.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.util.Date;

@Entity(name = "order_t")
@Data
public class Order {

    @Id
    private String orderId;

    //渠道id
    private String chanId;

    private String chanUserId;


    private String orderType;

    private String productId;

    private BigDecimal amount;

    private String outerOrderId;


    private String orderStatus;

    private String memo;

    private Date createAt;

    private Date updateAt;
}
