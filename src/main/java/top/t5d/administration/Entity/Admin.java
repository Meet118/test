package top.t5d.administration.Entity;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.apache.ibatis.annotations.ConstructorArgs;

/**
 * Admin
 * @author 
 */
@Data
@AllArgsConstructor
public class Admin implements Serializable {
    /**
     * 管理员用户名
     */
    private String adminname;

    /**
     * 管理员密码
     */
    private String password;

    /**
     * 管理员姓名
     */
    private String name;

    private static final long serialVersionUID = 1L;
}