package top.t5d.administration.Controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import top.t5d.administration.Entity.Admin;
import top.t5d.administration.Service.AboutAdmin;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

@Controller
@CrossOrigin
public class AdminController {

    @Autowired
    AboutAdmin aboutAdmin;

    ObjectMapper objectMapper=new ObjectMapper();

    @ResponseBody
    @PostMapping("/CreateAdmin")
    public String createAdmin(@RequestParam("AdminName") String AdminName,@RequestParam("Password") String Password,@RequestParam("Name") String Name) throws JsonProcessingException {
        boolean isHaveAdmin=aboutAdmin.getAdminByAdminName(AdminName);
        if(isHaveAdmin) return "no";
        Admin admin=new Admin(AdminName,Password,Name);
        aboutAdmin.createAdmin(admin);
        return "yes";
    }

    @ResponseBody
    @PostMapping("/AdminTable")
    public String adminTable(@RequestParam("limit") Integer limit,@RequestParam("page") Integer page) throws JsonProcessingException {
        Integer offset=(page-1)*limit;
        List<HashMap<String,String>> result=aboutAdmin.selectAllAdminByOffsetandLimit(offset,limit);

        LinkedHashMap<String,Object> data=new LinkedHashMap<>();
        data.put("code",0);
        data.put("msg","");
        Integer total=aboutAdmin.getAllAdminCount();
        data.put("count",total);
        data.put("data",result);
        return objectMapper.writeValueAsString(data);
    }

    @ResponseBody
    @PostMapping("/ModifyAdminPassword")
    public String modifyAdminPassword(@RequestParam("AdminName") String AdminName , @RequestParam("OldPassword") String OldPassword, @RequestParam("NewPassword") String NewPassword)
    {
        HashMap<String,String> AdminNameAndPassword=new HashMap<>();
        AdminNameAndPassword.put("AdminName",AdminName);
        AdminNameAndPassword.put("Password",OldPassword);
        boolean haveTheAdmin=aboutAdmin.haveThisAdminByAdminNameAndPassword(AdminNameAndPassword);
        if(!haveTheAdmin) return "原密码输入错误";
        else
        {
            aboutAdmin.modifyAdminPassword(AdminName,NewPassword);
            return "yes";
        }
    }
}
