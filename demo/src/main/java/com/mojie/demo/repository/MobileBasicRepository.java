package com.mojie.demo.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.mojie.demo.entity.MobileBasicEntity;

@Repository
public interface MobileBasicRepository extends CrudRepository<MobileBasicEntity, Integer> {

}
