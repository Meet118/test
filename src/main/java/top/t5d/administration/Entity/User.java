package top.t5d.administration.Entity;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * User
 * @author 
 */
@Data
@AllArgsConstructor
public class User implements Serializable {
    /**
     * 用户身份标识
     */
    private Integer id;

    /**
     * 用户名
     */
    private String username;

    private Integer studentid;

    private String phonenumber;

    /**
     * 密码
     */
    private String password;

    /**
     * 收货地址
     */
    private String address1;

    /**
     * 第二收货地址(可空)
     */
    private String address2;

    /**
     * 第二收货地址(可空)
     */
    private String address3;

    private static final long serialVersionUID = 1L;
}