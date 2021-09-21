package top.t5d.administration.Entity;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * Commodity
 * @author 
 */
@Data
@AllArgsConstructor
public class Commodity implements Serializable {
    /**
     * 商品货号
     */
    private Integer cId;

    /**
     * 商品名
     */
    private String cName;

    /**
     * 是否上架(取值：0或1)(默认为0)
     */
    private Boolean cOn;

    /**
     * 商品类型
     */
    private Integer cClass;

    /**
     * 商品价格
     */
    private Integer price;

    /**
     * 商品库存
     */
    private Integer stock;

    /**
     * 销量
     */
    private Integer salesvolume;

    private String cMemo;

    private String cFilename;

    private static final long serialVersionUID = 1L;
}