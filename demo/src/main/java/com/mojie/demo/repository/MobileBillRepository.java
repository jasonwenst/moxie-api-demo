package com.mojie.demo.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.mojie.demo.entity.MobileBillEntity;

@Repository
public interface MobileBillRepository extends CrudRepository<MobileBillEntity, Integer>{

}
