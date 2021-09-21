package top.t5d.administration.Controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import top.t5d.administration.Service.AboutCommodity;
import com.fasterxml.jackson.databind.ObjectMapper;
import top.t5d.administration.Service.aboutOrder;

import java.util.*;

@RestController
@CrossOrigin
public class ChartController {


    @Autowired
    AboutCommodity aboutCommodity;

    @Autowired
    aboutOrder aboutOrder;

    ObjectMapper objectMapper=new ObjectMapper();

    @PostMapping("/getChart1")
    public String getChart1() throws JsonProcessingException {
        List<String> top7CommodityName=aboutCommodity.getTop7CommodityName();
        List<Integer> top7CommoditySalesVolume=aboutCommodity.getTop7CommoditySalesVolume();
        List<Integer> top7CommodityStock=aboutCommodity.getTop7CommodityStock();
        HashMap<Object,Object> result=new HashMap<>();
        result.put("C_Name",top7CommodityName);
        result.put("C_SalesVolume",top7CommoditySalesVolume);
        result.put("C_Stock",top7CommodityStock);
        return objectMapper.writeValueAsString(result);
    }

    @PostMapping("/getChart2")
    public String getChart2() throws JsonProcessingException {
        Integer geRenFangHuLeiZongXiaoShouLiang=aboutCommodity.getGeRenFangHuLeiZongXiaoShouLiang();
        Integer yiLiaoXiaoHaoPinZongXiaoShouLiang=aboutCommodity.getYiLiaoXiaoHaoPinZongXiaoShouLiang();
        Integer yiLiaoSheBeiZongXiaoShouLiang=aboutCommodity.getYiLiaoSheBeiZongXiaoShouLiang();
        Integer yaoPinZongXiaoShouLiang=aboutCommodity.getYaoPinZongXiaoShouLiang();
        HashMap<Object,Object> result=new HashMap<>();
        result.put("C_GRFHL",geRenFangHuLeiZongXiaoShouLiang);
        result.put("C_YLXHP",yiLiaoXiaoHaoPinZongXiaoShouLiang);
        result.put("C_YLSB",yiLiaoSheBeiZongXiaoShouLiang);
        result.put("C_YP",yaoPinZongXiaoShouLiang);
        return objectMapper.writeValueAsString(result);
    }

    @PostMapping("/getChart3")
    public String getChart3() throws JsonProcessingException{
        List<HashMap<String,Object>> gRFHLOrder=aboutOrder.getOrderByClass(1);
        List<HashMap<String,Object>> yLXHPOrder=aboutOrder.getOrderByClass(2);
        List<HashMap<String,Object>> yLSBOrder=aboutOrder.getOrderByClass(3);
        List<HashMap<String,Object>> yPOrder=aboutOrder.getOrderByClass(4);
        int[] C_GRFHL_A=new int[12];
        int[] C_YLXHP_A=new int[12];
        int[] C_YLSB_A=new int[12];
        int[] C_YP_A=new int[12];
        for (HashMap<String, Object> stringObjectHashMap : gRFHLOrder) {
            Calendar calendar = Calendar.getInstance();
            calendar.setTime((Date) stringObjectHashMap.get("Order_Time"));
            int o_year = calendar.get(Calendar.YEAR);
            int o_month = calendar.get(Calendar.MONTH);
            int o_day = calendar.get(Calendar.DATE);
            int o_hour = calendar.get(Calendar.HOUR_OF_DAY);
            calendar.setTime(new Date());
            int n_year = calendar.get(Calendar.YEAR);
            int n_month = calendar.get(Calendar.MONTH);
            int n_day = calendar.get(Calendar.DATE);
            if(o_year==n_year&&o_month==n_month&&o_day==n_day)
            {
                C_GRFHL_A[o_hour/2]+=(int) stringObjectHashMap.get("C_Count");
            }
        }
        for (HashMap<String, Object> stringObjectHashMap : yLXHPOrder) {
            Calendar calendar = Calendar.getInstance();
            calendar.setTime((Date) stringObjectHashMap.get("Order_Time"));
            int o_year = calendar.get(Calendar.YEAR);
            int o_month = calendar.get(Calendar.MONTH);
            int o_day = calendar.get(Calendar.DATE);
            int o_hour = calendar.get(Calendar.HOUR_OF_DAY);
            calendar.setTime(new Date());
            int n_year = calendar.get(Calendar.YEAR);
            int n_month = calendar.get(Calendar.MONTH);
            int n_day = calendar.get(Calendar.DATE);
            if(o_year==n_year&&o_month==n_month&&o_day==n_day)
            {
                C_YLXHP_A[o_hour/2]+=(int) stringObjectHashMap.get("C_Count");
            }
        }
        for (HashMap<String, Object> stringObjectHashMap : yLSBOrder) {
            Calendar calendar = Calendar.getInstance();
            calendar.setTime((Date) stringObjectHashMap.get("Order_Time"));
            int o_year = calendar.get(Calendar.YEAR);
            int o_month = calendar.get(Calendar.MONTH);
            int o_day = calendar.get(Calendar.DATE);
            int o_hour = calendar.get(Calendar.HOUR_OF_DAY);
            calendar.setTime(new Date());
            int n_year = calendar.get(Calendar.YEAR);
            int n_month = calendar.get(Calendar.MONTH);
            int n_day = calendar.get(Calendar.DATE);
            if(o_year==n_year&&o_month==n_month&&o_day==n_day)
            {
                C_YLSB_A[o_hour/2]+=(int) stringObjectHashMap.get("C_Count");
            }
        }
        for (HashMap<String, Object> stringObjectHashMap : yPOrder) {
            Calendar calendar = Calendar.getInstance();
            calendar.setTime((Date) stringObjectHashMap.get("Order_Time"));
            int o_year = calendar.get(Calendar.YEAR);
            int o_month = calendar.get(Calendar.MONTH);
            int o_day = calendar.get(Calendar.DATE);
            int o_hour = calendar.get(Calendar.HOUR_OF_DAY);
            calendar.setTime(new Date());
            int n_year = calendar.get(Calendar.YEAR);
            int n_month = calendar.get(Calendar.MONTH);
            int n_day = calendar.get(Calendar.DATE);
            if(o_year==n_year&&o_month==n_month&&o_day==n_day)
            {
                C_YP_A[o_hour/2]+=(int)stringObjectHashMap.get("C_Count");
            }
        }
        HashMap<String,Object> result=new HashMap<>();
        result.put("C_GRFHL_A",C_GRFHL_A);
        result.put("C_YLXHP_A",C_YLXHP_A);
        result.put("C_YLSB_A",C_YLSB_A);
        result.put("C_YP_A",C_YP_A);
        return objectMapper.writeValueAsString(result);
    }

}
