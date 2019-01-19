package com.farouk.bengarssallah.spring.angular.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.farouk.bengarssallah.spring.angular.model.Portfolio;

@RepositoryRestResource
public interface PortfolioRepository extends MongoRepository<Portfolio, Long> {

	@Query("{ 'reference' : ?0 }")
	public Portfolio findByReference(String reference);
	
	

}
