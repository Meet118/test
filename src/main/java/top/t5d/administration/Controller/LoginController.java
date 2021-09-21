package top.t5d.administration.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import top.t5d.administration.Service.AboutAdmin;

import java.util.HashMap;

@RestController
@CrossOrigin
public class LoginController {

    @Autowired
    AboutAdmin aboutAdmin;

    @PostMapping("/login")
    public String Login(@RequestParam("AdminName") String AdminName,@RequestParam("Password") String Password){
        HashMap<String,String> AdminNameAndPassword=new HashMap<>();
        AdminNameAndPassword.put("AdminName",AdminName);
        AdminNameAndPassword.put("Password",Password);
        boolean result=aboutAdmin.haveThisAdminByAdminNameAndPassword(AdminNameAndPassword);
        if(result) return "yes";
        return "no";
    }

    @PostMapping("/getName")
    public String Get_Name(@RequestParam("AdminName") String AdminName)
    {
        String Name=aboutAdmin.getNameByAdminName(AdminName);
        return Name;
    }
}
