package top.t5d.administration.Controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import top.t5d.administration.Entity.Commodity;
import top.t5d.administration.Service.AboutCommodity;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

@RestController
@CrossOrigin
public class CommodityController {

    @Autowired
    AboutCommodity aboutCommodity;

    ObjectMapper objectMapper=new ObjectMapper();

    @PostMapping("/getAddingID")
    public String getAddingID()
    {
        return aboutCommodity.getAddingID().toString();
    }

    @PostMapping("/CommodityTable")
    public String getAllCommodity(@RequestParam("limit") Integer limit, @RequestParam("page") Integer page) throws JsonProcessingException {
        Integer offset=(page-1)*limit;
        List<HashMap<Object,Object>> result=aboutCommodity.selectAllCommodityByOffsetandLimit(offset,limit);

        LinkedHashMap<String,Object> data=new LinkedHashMap<>();
        data.put("code",0);
        data.put("msg","");
        Integer total=aboutCommodity.getAllCommodityCount();
        data.put("count",total);
        data.put("data",result);
//        System.out.println(data);
        return objectMapper.writeValueAsString(data);
    }

    @PostMapping("/CreateCommodity")
    public String createCommodity(
            @RequestParam("Src") String Src,
            @RequestParam("CommodityId") Integer CommodityId,
            @RequestParam("CommodityName") String CommodityName,
            @RequestParam("WhetherOn") Boolean WhetherOn,
            @RequestParam("CommodityType") Integer CommodityType,
            @RequestParam("Price") Integer Price,
            @RequestParam("Stock") Integer Stock,
            @RequestParam("SalesVolume") Integer SalesVolume,
            @RequestParam("CommodityMemo") String CommodityMemo
    )
    {
        Src=Src.substring(Src.lastIndexOf("/")+1);
        Commodity commodity=new Commodity(CommodityId,CommodityName,WhetherOn,CommodityType,Price,Stock,SalesVolume,CommodityMemo,Src);
        aboutCommodity.createCommodity(commodity);
        return "yes";
    }

    @PostMapping("/GetNowStock")
    public String getNowStock(@RequestParam("C_Id") Integer id) throws JsonProcessingException {
        return objectMapper.writeValueAsString(aboutCommodity.getNowStock(id));
    }

    @PostMapping("/GetNowPic")
    public String getNowPic(@RequestParam("C_Id") Integer id)
    {
        return "http://1.15.188.201/CommodityImage/"+aboutCommodity.getNowPic(id);
    }

    @PostMapping("/ModifyStock")
    public String modifyStock(@RequestParam("C_Id") Integer id,@RequestParam("NewStock") Integer newStock)
    {
        aboutCommodity.updateStockById(id,newStock);
        return "yes";
    }

    @PostMapping("/ModifyNewPicture")
    public String modifyNewPicture(@RequestParam("C_Id") Integer id,@RequestParam("NewPic") String picSrc)
    {
        picSrc=picSrc.substring(picSrc.lastIndexOf("/")+1);
        aboutCommodity.updatePicById(id,picSrc);
        return "yes";
    }

    @PostMapping("/COnEvent")
    public String modifyState(@RequestParam("C_Id") Integer id) {
        int state=aboutCommodity.selectStateByCId(id);
        if(state==0) aboutCommodity.setStateByCId(id,1);
        else aboutCommodity.setStateByCId(id,0);
        return "yes";
    }
}
