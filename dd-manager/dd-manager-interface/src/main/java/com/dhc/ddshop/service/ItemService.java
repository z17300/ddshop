package com.dhc.ddshop.service;

import com.dhc.ddshop.common.dto.Order;
import com.dhc.ddshop.common.dto.Page;
import com.dhc.ddshop.common.dto.Result;
import com.dhc.ddshop.pojo.po.TbItem;
import com.dhc.ddshop.pojo.vo.TbItemCustom;

import java.util.List;

public interface ItemService {
    TbItem getById(Long itemId);

    List<TbItem> listItem();

    Result<TbItemCustom> listItemsByPage(Page page, Order order);
    //批量修改
    int updateBatch(List<Long> ids);
}
