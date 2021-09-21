package top.t5d.administration.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.t5d.administration.Mapper.DeliverMapper;
import top.t5d.administration.Mapper.OrderMapper;

import java.util.HashMap;
import java.util.List;

@Service
public class AboutDeliver {

    @Autowired
    DeliverMapper deliverMapper;

    @Autowired
    OrderMapper orderMapper;

    public List<HashMap<String, String>> selectAllDeliverByOffsetandLimit(Integer offset, Integer limit) {
        return deliverMapper.selectAllDeliverByOffsetandLimit(offset,limit);
    }

    public Integer getAllDeliverCount() {
        return deliverMapper.getAllDeliverCount();
    }

    public void createDeliver(Integer orderId, String address, String deliverBrand) {
        deliverMapper.insertDeliver(orderId,address,deliverBrand);
        Integer deliverId=deliverMapper.getDeliverIdByOrderId(orderId);
        orderMapper.updateOrder(orderId,deliverId);
    }
}
