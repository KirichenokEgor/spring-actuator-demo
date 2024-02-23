package com.azati.study.springactuatordemo.repository;

import com.azati.study.springactuatordemo.entity.MyItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MyItemRepository extends JpaRepository<MyItem, Integer> {
}
