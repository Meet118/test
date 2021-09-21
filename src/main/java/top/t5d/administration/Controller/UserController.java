package top.t5d.administration.Controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import top.t5d.administration.Service.AboutUser;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin
public class UserController {
    @Autowired
    AboutUser aboutUser;

    ObjectMapper objectMapper=new ObjectMapper();

    @PostMapping("/UserTable")
    public String userTable(@RequestParam("limit") Integer limit, @RequestParam("page") Integer page) throws JsonProcessingException {
        Integer offset=(page-1)*limit;
        List<HashMap<String,String>> result=aboutUser.selectAllUserByOffsetandLimit(offset,limit);

        LinkedHashMap<String,Object> data=new LinkedHashMap<>();
        data.put("code",0);
        data.put("msg","");
        Integer total=aboutUser.getAllUserCount();
        data.put("count",total);
        data.put("data",result);
        return objectMapper.writeValueAsString(data);
    }

    @PostMapping("/QueryUserInfo")
    public String quertUserInfo(@RequestParam("Id") Integer id) throws JsonProcessingException {
        HashMap<String,String> queryResult=aboutUser.getPhoneNumberandMailaddressById(id);
        HashMap<String,Object> result=new HashMap<>();
        result.put("data",queryResult);
        return objectMapper.writeValueAsString(result);
    }

    @PostMapping("/LatestLoginUser")
    public String latestLoginUser() throws JsonProcessingException {
        LinkedHashMap<String,Object> convertResult,result;
        List<LinkedHashMap<String,Object>> queryResult=aboutUser.getLatestLoginUser();
        int i=queryResult.size()-1;
        convertResult=new LinkedHashMap<>();
        int j=1;
        while(i>=0)
        {
            String value= String.format("用户 %s 在 %s 登录", queryResult.get(i).get("UserName"), queryResult.get(i).get("Utime"));
            convertResult.put("U"+j,value);
            j++;
            i--;
        }
        result=new LinkedHashMap<>();
        result.put("data",convertResult);
        result.put("size",queryResult.size());

        return objectMapper.writeValueAsString(result);
    }

    @PostMapping("/GetOnlineUserNumber")
    public String getOnlineUserNumber() throws JsonProcessingException {
        return objectMapper.writeValueAsString(aboutUser.getOnlineUserNumber());
    }

}
