package com.dhc.ddshop.service.impl;

import com.dhc.ddshop.common.dto.Order;
import com.dhc.ddshop.common.dto.Page;
import com.dhc.ddshop.common.dto.Result;
import com.dhc.ddshop.dao.TbItemCustomMapper;
import com.dhc.ddshop.dao.TbItemMapper;
import com.dhc.ddshop.pojo.po.TbItem;
import com.dhc.ddshop.pojo.po.TbItemExample;
import com.dhc.ddshop.pojo.vo.TbItemCustom;
import com.dhc.ddshop.service.ItemService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ItemServiceImpl implements ItemService {
    private Logger logger= LoggerFactory.getLogger(this.getClass());
    @Autowired
    private TbItemMapper iteamDao;
    @Autowired
    private TbItemCustomMapper itemCustomMapper;
    @Override
    public TbItem getById(Long itemId) {
       TbItem TbItem=iteamDao.selectByPrimaryKey(itemId);
       return TbItem;
    }

    @Override
    public List<TbItem> listItem() {
        List<TbItem>list=null;
        try {
            list=iteamDao.selectByExample(null);

        }catch (Exception e){
            logger.error(e.getMessage(),e);
            e.printStackTrace();
        }

        return list;
    }

    @Override
    public Result<TbItemCustom> listItemsByPage(Page page, Order order) {
        Result<TbItemCustom>result=null;
        try {
            //创建一个map接受前面的数据
            Map<String,Object> map=new HashMap<String,Object>();
            map.put("page",page);
            map.put("order",order);
            //创建一个响应参数实体类
            result=new Result<TbItemCustom>();
            //
            int total=itemCustomMapper.countItems();
            result.setTotal(total);
            List<TbItemCustom>list=itemCustomMapper.listItemByPage(map);
            result.setRows(list);
        }catch (Exception e){
            logger.error(e.getMessage(),e);
            e.printStackTrace();
        }

        return result;
    }

    @Override
    public int updateBatch(List<Long> ids) {
        int i=0;
        try {
            TbItem record=new TbItem();
            record.setStatus((byte)3);
            //创建更新模板
            TbItemExample example=new TbItemExample();
            TbItemExample.Criteria criteria=example.createCriteria();
            criteria.andIdIn(ids);

            //执行更新
            i=iteamDao.updateByExampleSelective(record,example);
        }catch (Exception e){
            logger.error(e.getMessage(),e);
            e.printStackTrace();
        }
        return i;
    }

}