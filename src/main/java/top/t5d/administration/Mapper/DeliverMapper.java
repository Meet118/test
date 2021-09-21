package top.t5d.administration.Mapper;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import top.t5d.administration.Entity.Deliver;

import java.util.HashMap;
import java.util.List;

@Repository
public interface DeliverMapper {

    List<HashMap<String, String>> selectAllDeliverByOffsetandLimit(@Param("offset") Integer offset, @Param("limit") Integer limit);

    Integer getAllDeliverCount();

    void insertDeliver(@Param("orderId") Integer orderId, @Param("address") String address, @Param("deliverbrand") String deliverBrand);

    Integer getDeliverIdByOrderId(Integer orderId);
}