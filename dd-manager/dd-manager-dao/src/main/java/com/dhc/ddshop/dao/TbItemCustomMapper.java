package com.dhc.ddshop.dao;

import com.dhc.ddshop.common.dto.Order;
import com.dhc.ddshop.common.dto.Page;
import com.dhc.ddshop.pojo.po.TbItem;
import com.dhc.ddshop.pojo.vo.TbItemCustom;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

//自定义接口
public interface  TbItemCustomMapper {
    int countItems();
    List<TbItemCustom>listItemByPage(Map<String,Object>map);
}
