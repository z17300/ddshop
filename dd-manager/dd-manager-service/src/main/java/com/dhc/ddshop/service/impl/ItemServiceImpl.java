package com.dhc.ddshop.service.impl;

import com.dhc.ddshop.dao.TbItemMapper;
import com.dhc.ddshop.pojo.po.TbItem;
import com.dhc.ddshop.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ItemServiceImpl implements ItemService {
    @Autowired
    private TbItemMapper iteamDao;
    @Override
    public TbItem getById(Long itemId) {
       TbItem TbItem=iteamDao.selectByPrimaryKey(itemId);
       return TbItem;
    }
}
