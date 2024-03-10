package com.tech.crud.repositery;


import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.tech.crud.model.DepartmentModel;

public interface employeeDepartmentRepository extends MongoRepository<DepartmentModel, String>{

}
