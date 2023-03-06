package com.ewolff.microservice.customer.repositories;


import com.ewolff.microservice.customer.Customer;
import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@EnableScan
@RepositoryRestResource(collectionResourceRel = "customer", path = "customer")
public interface CustomerRepository extends
        CrudRepository<Customer, String> {

    Optional<Customer> findById(@Param("id") String id);

    List<Customer> findByName(@Param("name") String name);

}
