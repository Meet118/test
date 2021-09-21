package top.t5d.administration.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.t5d.administration.Entity.User;
import top.t5d.administration.Mapper.UserMapper;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

@Service
public class AboutUser {

    @Autowired
    UserMapper userMapper;

    public Integer getAllUserCount() {
        return userMapper.getAllUserCount();
    }

    public List<HashMap<String, String>> selectAllUserByOffsetandLimit(Integer offset, Integer limit) {
        return userMapper.selectAllUserByOffsetandLimit(offset,limit);
    }

    public HashMap<String, String> getPhoneNumberandMailaddressById(Integer id) {
        return userMapper.getPhoneNumberandMailaddressById(id);
    }

    public List<LinkedHashMap<String, Object>> getLatestLoginUser() {
        return userMapper.getLatestLoginUser();
    }

    public Integer getOnlineUserNumber() {
        return userMapper.getOnlineUserNumber();
    }

    public String getNameById(Integer id) {
        return userMapper.getNameById(id);
    }

    public String getMailAddressById(Integer id) {
        return userMapper.getMailAddressById(id);
    }
}
