package com.sn.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.sn.dbo.ItemDBO;
import com.sn.repository.ItemRepository;

@Service
public class ItemService {

	@Autowired
	private ItemRepository itemRepository;
	
	public List<ItemDBO> getItems() {
		return itemRepository.findAll();
	}
	
	public List<ItemDBO> getItems(String itemname) {
		return  itemRepository.findByName(itemname);
	}
	
	public ItemDBO getItem(String itemname) {
		return  itemRepository.findByName(itemname).get(0);
	}

	
	@HystrixCommand(fallbackMethod = "getDefaultCount")
	public String getItemCount(Long id) {
		ItemDBO itemDbo=itemRepository.findById(id).orElseThrow(()->new RuntimeException("No data found"));
		return "Item Found :"+itemDbo.getName();
	}
	
	public String getDefaultCount(Long id) {
		return "********** No Item found for id:"+id;
		
	}

}
