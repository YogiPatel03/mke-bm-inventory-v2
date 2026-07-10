package com.yogipatel.inventory.item;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;


public interface  ItemRepository extends JpaRepository<Item, Long>{
    public List<Item> findByBinIdOrderByNameAsc(Long binId);
}
