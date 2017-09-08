package com.mojie.demo.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.mojie.demo.entity.MobileSmsEntity;

@Repository
public interface MobileSmsRepository extends CrudRepository<MobileSmsEntity, Integer> {

}
