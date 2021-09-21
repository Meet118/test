package top.t5d.administration.Mapper;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;
import top.t5d.administration.Entity.Commodity;

import java.util.HashMap;
import java.util.List;

@Repository
public interface CommodityMapper {

    Integer getAddingID();

    List<HashMap<Object, Object>> selectAllCommodityByOffsetandLimit(@Param("offset") Integer offset, @Param("limit") Integer limit);

    Integer getAllCommodityCount();

    void createCommodity(@Param("Co") Commodity commodity);

    Integer getNowStock(Integer id);

    String getNowPic(Integer id);

    String getNameByCId(Integer c_id);

    void updateStockById(@Param("id") Integer id, @Param("newStock") Integer newStock);

    void updatePicById(@Param("id") Integer id, @Param("picSrc") String picSrc);

    void setStateByCId(@Param("id") Integer id,@Param("state") Integer state);

    int selectStateByCId(Integer id);

    List<String> getTop7CommodityName();

    List<Integer> getTop7CommoditySalesVolume();

    List<Integer> getTop7CommodityStock();

    Integer getGeRenFangHuLeiZongXiaoShouLiang();

    Integer getYiLiaoXiaoHaoPinZongXiaoShouLiang();

    Integer getYiLiaoSheBeiZongXiaoShouLiang();

    Integer getYaoPinZongXiaoShouLiang();
}