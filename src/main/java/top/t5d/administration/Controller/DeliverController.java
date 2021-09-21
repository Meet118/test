package top.t5d.administration.Controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import top.t5d.administration.Service.AboutDeliver;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

@RestController
@CrossOrigin
public class DeliverController {

    @Autowired
    AboutDeliver aboutDeliver;

    ObjectMapper objectMapper=new ObjectMapper();

    @PostMapping("/DeliverTable")
    public String deliverTable(@RequestParam("limit") Integer limit,@RequestParam("page") Integer page) throws JsonProcessingException {
        Integer offset=(page-1)*limit;
        List<HashMap<String,String>> result=aboutDeliver.selectAllDeliverByOffsetandLimit(offset,limit);

        LinkedHashMap<String,Object> data=new LinkedHashMap<>();
        data.put("code",0);
        data.put("msg","");
        Integer total=aboutDeliver.getAllDeliverCount();
        data.put("count",total);
        data.put("data",result);
        return objectMapper.writeValueAsString(data);
    }

    @PostMapping("/CreateDeliver")
    public String createDeliver(@RequestParam("OrderId") Integer orderId,@RequestParam("Address") String address,@RequestParam("DeliverBrand") String deliverBrand)
    {
        aboutDeliver.createDeliver(orderId,address,deliverBrand);
        return "yes";
    }
}
