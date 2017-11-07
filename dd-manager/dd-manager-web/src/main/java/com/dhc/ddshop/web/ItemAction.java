package com.dhc.ddshop.web;

import com.dhc.ddshop.pojo.po.TbItem;
import com.dhc.ddshop.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@Scope("prototype")
public class ItemAction {
    @Autowired
    private ItemService itemService;


    @ResponseBody
    @RequestMapping(value="item/{itemId}",method = RequestMethod.GET)//当前方法为get方法来接受指定的id
    public TbItem getById(@PathVariable("itemId")Long itemId){
        TbItem tbItem=itemService.getById(itemId);
        System.out.print(tbItem);
        return tbItem;
    }
    @RequestMapping("/{page}")
    public String page(@PathVariable("page")String page){
        return page;
    }
}