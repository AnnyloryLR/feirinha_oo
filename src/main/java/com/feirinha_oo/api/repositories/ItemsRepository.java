package com.feirinha_oo.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.feirinha_oo.api.models.ItemsModel;

@Repository
public interface ItemsRepository extends JpaRepository<ItemsModel, Long> {
    boolean existsByName(String name);
}
