package top.t5d.administration.Entity;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * Order
 * @author 
 */
@Data
public class Order implements Serializable {
    /**
     * 订单唯一标识
     */
    private Integer oId;

    /**
     * 用户唯一标识
     */
    private String id;

    /**
     * 商品唯一标识
     */
    private String cId;

    /**
     * 快递单号
     */
    private String deliverId;

    private Date orderTime;

    /**
     * 买家备注
     */
    private String memo;

    /**
     * 是否已发货(默认为0)
     */
    private Boolean ifDelivering;

    /**
     * 是否为退换货(默认为0)
     */
    private Boolean entitle;

    private static final long serialVersionUID = 1L;
}