package com.github.carloscontrerasruiz.MockitoPractice.repository;

import com.github.carloscontrerasruiz.MockitoPractice.entity.ItemEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemRepository extends JpaRepository<ItemEntity, Integer> {
}
