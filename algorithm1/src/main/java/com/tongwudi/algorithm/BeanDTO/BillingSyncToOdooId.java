package com.tongwudi.algorithm.BeanDTO;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;
@Data
public class BillingSyncToOdooId {
    private String  partner_type;
    private String  partner_id;
    private BigDecimal amount;
    private String date;
    private String currency;
    private String bank_name;
    private String  bank_no;
    private String id;
}
