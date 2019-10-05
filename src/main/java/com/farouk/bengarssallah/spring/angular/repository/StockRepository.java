package com.farouk.bengarssallah.spring.angular.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.farouk.bengarssallah.spring.angular.model.Stock;

public interface StockRepository extends MongoRepository<Stock, Long> {
	
	@Query("{ 'symbol' : ?0 }")
	public Stock findBySymbol(String symbol);

}
