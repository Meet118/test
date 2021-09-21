package top.t5d.administration.Mapper;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;

@Repository
public interface AdminMapper {

    int selectByAdminNameAndPassword(@Param("AdminName") String AdminName,@Param("Password") String Password) ;

    String getNameByAdminName(String AdminName);

    Integer createAdmin(@Param("AdminName") String AdminName,@Param("Password") String Password,@Param("Name") String Name);

    Integer selectByAdminName(String adminName);

    List<HashMap<String,String>> selectAllAdminByOffsetandLimit(@Param("offset") Integer offset, @Param("limit") Integer limit);

    Integer getAllAdminCount();

    void updateAdminPassword(@Param("adminName") String adminName, @Param("newPassword") String newPassword);
}