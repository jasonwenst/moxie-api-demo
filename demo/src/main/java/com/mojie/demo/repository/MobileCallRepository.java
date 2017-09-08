package com.mojie.demo.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.mojie.demo.entity.MobileCallEntity;

@Repository
public interface MobileCallRepository extends CrudRepository<MobileCallEntity, Integer> {

}
