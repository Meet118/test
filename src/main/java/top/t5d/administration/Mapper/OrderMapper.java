package top.t5d.administration.Mapper;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import top.t5d.administration.Entity.Order;

import java.util.HashMap;
import java.util.List;

@Repository
public interface OrderMapper {

    List<HashMap<String, String>> selectAllOrderByOffsetandLimit(@Param("offset") Integer offset, @Param("limit") Integer limit);

    Integer selectAllOrderCount();

    List<HashMap<String, String>> selectAllBadOrderByOffsetandLimit(@Param("offset") Integer offset, @Param("limit") Integer limit);

    Integer selectAllBadOrderCount();

    Integer getIdByOId(Integer o_id);

    Integer getCIdByOId(Integer o_id);

    void updateOrder(@Param("orderId") Integer orderId, @Param("deliverId") Integer deliverId);

    List<HashMap<String, Object>> getOrderByClass(@Param("type") Integer i);
}