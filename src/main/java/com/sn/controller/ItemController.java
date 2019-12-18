package com.sn.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sn.dbo.ItemDBO;
import com.sn.repository.ItemRepository;

@RestController
@RequestMapping(value="/service2")
public class ItemController {
	
	
	@Autowired
	private ItemRepository itemRepository;
	
	
	@RequestMapping(value="/items",method=RequestMethod.GET)
	public List<ItemDBO> getItems() {
		return itemRepository.findAll();
	}
	
	@RequestMapping(value="/items/{itemname}",method=RequestMethod.GET)
	public List<ItemDBO> getItems(@PathVariable String itemname) {
		return  itemRepository.findByName(itemname);
	}


}
