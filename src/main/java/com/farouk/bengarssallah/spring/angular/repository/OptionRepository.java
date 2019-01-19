package com.farouk.bengarssallah.spring.angular.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.farouk.bengarssallah.spring.angular.model.Option;

@RepositoryRestResource
public interface OptionRepository extends MongoRepository<Option, Long> {

	@Query("{ 'reference' : ?0 }")
	public Option findByReference(String reference);
	
	
}
