package top.t5d.administration.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.t5d.administration.Entity.Admin;
import top.t5d.administration.Mapper.AdminMapper;

import java.util.HashMap;
import java.util.List;

@Service
public class AboutAdmin {

    @Autowired
    private AdminMapper adminMapper;

    public boolean haveThisAdminByAdminNameAndPassword(HashMap<String,String> AdminNameAndPassword)
    {
        String AdminName=AdminNameAndPassword.get("AdminName");
        String Password=AdminNameAndPassword.get("Password");
        int isHave=adminMapper.selectByAdminNameAndPassword(AdminName,Password);
        return isHave == 1;
    }

    public String getNameByAdminName(String AdminName)
    {
        return adminMapper.getNameByAdminName(AdminName);
    }

    public boolean getAdminByAdminName(String AdminName)
    {
        Integer result=adminMapper.selectByAdminName(AdminName);
        return result == 1;
    }

    public void createAdmin(Admin admin)
    {
        adminMapper.createAdmin(admin.getAdminname(),admin.getPassword(),admin.getName());
    }

    public List<HashMap<String, String>> selectAllAdminByOffsetandLimit(Integer offset, Integer limit) {
        return adminMapper.selectAllAdminByOffsetandLimit(offset,limit);
    }

    public Integer getAllAdminCount() {
        return adminMapper.getAllAdminCount();
    }

    public void modifyAdminPassword(String AdminName,String NewPassword)
    {
        adminMapper.updateAdminPassword(AdminName,NewPassword);
    }

}
