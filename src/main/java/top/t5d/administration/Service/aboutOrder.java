package top.t5d.administration.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.t5d.administration.Mapper.OrderMapper;

import java.util.HashMap;
import java.util.List;

@Service
public class aboutOrder {

    @Autowired
    OrderMapper orderMapper;

    public List<HashMap<String, String>> selectAllOrderByOffsetandLimit(Integer offset, Integer limit) {
        return orderMapper.selectAllOrderByOffsetandLimit(offset,limit);
    }

    public Integer getAllOrderCount() {
        return orderMapper.selectAllOrderCount();
    }

    public List<HashMap<String, String>> selectAllBadOrderByOffsetandLimit(Integer offset, Integer limit) {
        return orderMapper.selectAllBadOrderByOffsetandLimit(offset,limit);
    }

    public Integer getAllBadOrderCount() {
        return orderMapper.selectAllBadOrderCount();
    }

    public Integer getIdByOId(Integer o_id) {
        return orderMapper.getIdByOId(o_id);
    }

    public Integer getCIdByOId(Integer o_id) {
        return orderMapper.getCIdByOId(o_id);
    }

    public List<HashMap<String, Object>> getOrderByClass(int i) {
        return orderMapper.getOrderByClass(i);
    }
}
