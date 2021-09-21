package top.t5d.administration.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.t5d.administration.Entity.Commodity;
import top.t5d.administration.Mapper.CommodityMapper;

import java.util.HashMap;
import java.util.List;

@Service
public class AboutCommodity {

    @Autowired
    CommodityMapper commodityMapper;

    public Integer getAddingID() {
        return commodityMapper.getAddingID();
    }

    public List<HashMap<Object, Object>> selectAllCommodityByOffsetandLimit(Integer offset, Integer limit) {
        return commodityMapper.selectAllCommodityByOffsetandLimit(offset,limit);
    }

    public Integer getAllCommodityCount() {
        return commodityMapper.getAllCommodityCount();
    }

    public void createCommodity(Commodity commodity) {
        commodityMapper.createCommodity(commodity);
    }

    public Integer getNowStock(Integer id) {
        return commodityMapper.getNowStock(id);
    }

    public String getNowPic(Integer id) {
        return commodityMapper.getNowPic(id);
    }

    public String getNameByCId(Integer c_id) {
        return commodityMapper.getNameByCId(c_id);
    }

    public void updateStockById(Integer id, Integer newStock) {
        commodityMapper.updateStockById(id,newStock);
    }

    public void updatePicById(Integer id, String picSrc) {
        commodityMapper.updatePicById(id,picSrc);
    }

    public void setStateByCId(Integer id,Integer state) {
        commodityMapper.setStateByCId(id,state);
    }

    public int selectStateByCId(Integer id) {
        return commodityMapper.selectStateByCId(id);
    }

    public List<String> getTop7CommodityName() {
        return commodityMapper.getTop7CommodityName();
    }

    public List<Integer> getTop7CommoditySalesVolume() {
        return commodityMapper.getTop7CommoditySalesVolume();
    }

    public List<Integer> getTop7CommodityStock() {
        return commodityMapper.getTop7CommodityStock();
    }

    public Integer getGeRenFangHuLeiZongXiaoShouLiang() {
        return commodityMapper.getGeRenFangHuLeiZongXiaoShouLiang();
    }

    public Integer getYiLiaoXiaoHaoPinZongXiaoShouLiang() {
        return commodityMapper.getYiLiaoXiaoHaoPinZongXiaoShouLiang();
    }

    public Integer getYiLiaoSheBeiZongXiaoShouLiang() {
        return commodityMapper.getYiLiaoSheBeiZongXiaoShouLiang();
    }

    public Integer getYaoPinZongXiaoShouLiang() {
        return commodityMapper.getYaoPinZongXiaoShouLiang();
    }
}
