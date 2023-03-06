package com.ewolff.microservice.order.logic.repositories;

import com.ewolff.microservice.order.logic.Order;
import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;


@Repository
@EnableScan
@RepositoryRestResource(collectionResourceRel = "order", path = "order")
public interface OrderRepository extends
        CrudRepository<Order, String> {


}
