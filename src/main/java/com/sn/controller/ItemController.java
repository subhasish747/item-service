package com.sn.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sn.dbo.ItemDBO;
import com.sn.service.ItemService;

@RestController
@RequestMapping(value="/service2")
public class ItemController {
	
	
	@Autowired
	private ItemService itemService;
	
	
	@RequestMapping(value="/items",method=RequestMethod.GET)
	public List<ItemDBO> getItems() {
		return itemService.getItems();
	}
	
	@RequestMapping(value="/itemnames/{itemname}",method=RequestMethod.GET)
	public List<ItemDBO> getItems(@PathVariable String itemname) {
		return  itemService.getItems(itemname);
	}
	
	@RequestMapping(value="/items/{itemname}",method=RequestMethod.GET)
	public ItemDBO getItemName(@PathVariable String itemname) {
		return  itemService.getItem(itemname);
	}

	
	
	@RequestMapping(value="/itemcount/{id}",method=RequestMethod.GET)
	public String getItemCount(@PathVariable Long id) {
		return itemService.getItemCount(id);
	}



}
