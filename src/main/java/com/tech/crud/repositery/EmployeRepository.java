package com.tech.crud.repositery;

import org.springframework.stereotype.Repository;

import com.tech.crud.model.EmployeModel;

import org.springframework.data.mongodb.repository.MongoRepository;

@Repository
public interface EmployeRepository extends MongoRepository<EmployeModel, String> {

}
