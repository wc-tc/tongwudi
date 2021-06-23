package com.tongwudi.algorithm.bean;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

@Data
public class SimpleDetail implements Serializable {
    //名字
    private String p_name;
    //数量
    private Integer quantity;
    //价格
    private BigDecimal price_unit;
}
