package top.t5d.administration.Controller;


import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.fasterxml.jackson.databind.ObjectMapper;
import top.t5d.administration.Service.AboutCommodity;
import top.t5d.administration.Service.AboutUser;
import top.t5d.administration.Service.aboutOrder;

import com.tencentcloudapi.common.Credential;
import com.tencentcloudapi.common.profile.ClientProfile;
import com.tencentcloudapi.common.profile.HttpProfile;
import com.tencentcloudapi.common.exception.TencentCloudSDKException;

import com.tencentcloudapi.ses.v20201002.SesClient;
import com.tencentcloudapi.ses.v20201002.models.*;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import top.t5d.administration.Utils.*;

@RestController
@CrossOrigin
public class OrderController {

    ObjectMapper objectMapper=new ObjectMapper();

    @Autowired
    aboutOrder aboutOrder;

    @Autowired
    AboutUser aboutUser;

    @Autowired
    AboutCommodity aboutCommodity;

    @PostMapping("/OrderTable")
    public String getAllOrder(@RequestParam("limit") Integer limit, @RequestParam("page") Integer page) throws JsonProcessingException {
        Integer offset=(page-1)*limit;
        List<HashMap<String,String>> result= aboutOrder.selectAllOrderByOffsetandLimit(offset,limit);

        LinkedHashMap<String,Object> data=new LinkedHashMap<>();
        data.put("code",0);
        data.put("msg","");
        Integer total=aboutOrder.getAllOrderCount();
        data.put("count",total);
        data.put("data",result);
        return objectMapper.writeValueAsString(data);
    }

    @PostMapping("/BadOrder")
    public String getAllBadOrder(@RequestParam("limit") Integer limit,@RequestParam("page") Integer page) throws JsonProcessingException {
        Integer offset=(page-1)*limit;
        List<HashMap<String,String>> result= aboutOrder.selectAllBadOrderByOffsetandLimit(offset,limit);

        LinkedHashMap<String,Object> data=new LinkedHashMap<>();
        data.put("code",0);
        data.put("msg","");
        Integer total=aboutOrder.getAllBadOrderCount();
        data.put("count",total);
        data.put("data",result);
        return objectMapper.writeValueAsString(data);
    }

    @PostMapping("/SendEmail")
    public String sendMail(@RequestParam("O_Id") Integer O_Id) throws JsonProcessingException {
        try {
            Integer Id = aboutOrder.getIdByOId(O_Id);
            String Name = aboutUser.getNameById(Id);
            Integer C_Id = aboutOrder.getCIdByOId(O_Id);
            String Commdity = aboutCommodity.getNameByCId(C_Id);
            String mailAddress = aboutUser.getMailAddressById(Id);
            if(mailAddress==null|| mailAddress.equals("")) return "该用户没有绑定邮箱";
            SendMail sendMail = new SendMail();
            sendMail.setCredential(new Credential("AKIDB8csriuM7bntqSn58C0ZrpStxjHXHAaV", "pOuDF0UwA7pTv74lmPx12oNgidJhrqlF"));
            sendMail.setHttpProfile(new HttpProfile());
            sendMail.getHttpProfile().setEndpoint("ses.tencentcloudapi.com");
            sendMail.setClientProfile(new ClientProfile());
            sendMail.getClientProfile().setHttpProfile(sendMail.getHttpProfile());
            sendMail.setSesClient(new SesClient(sendMail.getCredential(), "ap-hongkong", sendMail.getClientProfile()));
            sendMail.setSendEmailRequest(new SendEmailRequest());
            sendMail.getSendEmailRequest().setFromEmailAddress("t5d_medical@t5d.top");
            String[] destination = new String[1];
            destination[0] = mailAddress;
            sendMail.getSendEmailRequest().setDestination(destination);
            sendMail.setTemplate(new Template());
            sendMail.getTemplate().setTemplateID(15391L);
            HashMap<String, String> requestParam = new HashMap<>();
            requestParam.put("name", Name);
            requestParam.put("commoditys", Commdity);
            sendMail.getTemplate().setTemplateData(objectMapper.writeValueAsString(requestParam));
            sendMail.getSendEmailRequest().setTemplate(sendMail.getTemplate());
            sendMail.getSendEmailRequest().setSubject("t5d医疗物流通知");
            SendEmailResponse sendEmailResponse=sendMail.getSesClient().SendEmail(sendMail.getSendEmailRequest());
            if(sendEmailResponse.getMessageId().equals("")) return "邮箱不存在";
            else return "发送成功";
        }catch (TencentCloudSDKException e)
        {
            return "服务器错误";
        }
    }

}
