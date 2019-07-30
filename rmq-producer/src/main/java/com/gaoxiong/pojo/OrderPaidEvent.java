package com.gaoxiong.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @author gaoxiong
 * @ClassName OrderPaidEvent
 * @Description TODO
 * @date 2019/7/30 11:49
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderPaidEvent implements Serializable {
    private String orderId;
    private BigDecimal paidMoney;
}
