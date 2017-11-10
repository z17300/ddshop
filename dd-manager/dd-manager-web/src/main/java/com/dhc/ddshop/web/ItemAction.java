package com.dhc.ddshop.web;

import com.dhc.ddshop.common.dto.Order;
import com.dhc.ddshop.common.dto.Page;
import com.dhc.ddshop.common.dto.Result;
import com.dhc.ddshop.pojo.po.TbItem;
import com.dhc.ddshop.pojo.vo.TbItemCustom;
import com.dhc.ddshop.service.ItemService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
@Scope("prototype")
public class ItemAction {
    @Autowired
    private ItemService itemService;
    private Logger logger= LoggerFactory.getLogger(this.getClass());

    @ResponseBody
    @RequestMapping(value="item/{itemId}",method = RequestMethod.GET)//当前方法为get方法来接受指定的id
    public TbItem getById(@PathVariable("itemId")Long itemId){
        TbItem tbItem= itemService.getById(itemId);
        System.out.print(tbItem);
        return tbItem;
    }
    @RequestMapping("/{page}")
    public String page(@PathVariable("page")String page){
        return page;
    }

//    @RequestMapping("/items")
//    @ResponseBody
//    public List<TbItem>listItem(){
//        List<TbItem>list=null;
//        try {
//            list=itemService.listItem();
//
//        }catch (Exception e){
//            logger.error(e.getMessage(),e);
//            e.printStackTrace();
//        }
//
//        return list;
//    }

    @RequestMapping("/items")
    @ResponseBody
    public Result<TbItemCustom> listItem(Page page, Order order){
        Result<TbItemCustom>list=null;
        try {
            list=itemService.listItemsByPage(page,order);

        }catch (Exception e){
            logger.error(e.getMessage(),e);
            e.printStackTrace();
        }

        return list;

    }
    @ResponseBody
    @RequestMapping("/items/batch")
    public int updateBatch(@RequestParam("ids[]")List<Long>ids){
        System.out.print(ids);
        int i=0;
        try {
            i=itemService.updateBatch(ids);
        }catch (Exception e){
            logger.error(e.getMessage(),e);
            e.printStackTrace();
        }

        return i;
    }
}
