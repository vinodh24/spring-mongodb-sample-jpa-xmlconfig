package com.vinodh.repository;


import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.NoRepositoryBean;
@NoRepositoryBean
public interface GenericDAO<T> extends MongoRepository<T, Long>{
   
    
}
