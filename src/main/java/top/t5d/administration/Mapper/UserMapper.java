package top.t5d.administration.Mapper;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import top.t5d.administration.Entity.User;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

@Repository
public interface UserMapper {

    Integer getAllUserCount();

    List<HashMap<String, String>> selectAllUserByOffsetandLimit(@Param("offset") Integer offset, @Param("limit") Integer limit);

    HashMap<String, String> getPhoneNumberandMailaddressById(Integer id);

    List<LinkedHashMap<String, Object>> getLatestLoginUser();

    Integer getOnlineUserNumber();

    String getNameById(Integer id);

    String getMailAddressById(Integer id);
}