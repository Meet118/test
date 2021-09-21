package top.t5d.administration.Entity;

import java.io.Serializable;
import lombok.Data;

/**
 * Deliver
 * @author 
 */
@Data
public class Deliver implements Serializable {
    /**
     * 快递唯一标识(快递单号)
     */
    private Integer deliverId;

    /**
     * 订单唯一标识
     */
    private String oId;

    /**
     * 收货地址
     */
    private String deliverAddress;

    /**
     * 快递公司
     */
    private String deliverBrand;

    private static final long serialVersionUID = 1L;
}