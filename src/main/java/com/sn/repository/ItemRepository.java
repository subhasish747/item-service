package com.sn.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sn.dbo.ItemDBO;

public interface ItemRepository extends JpaRepository<ItemDBO, Long> {
	
	public List<ItemDBO> findByName(String name);

}
