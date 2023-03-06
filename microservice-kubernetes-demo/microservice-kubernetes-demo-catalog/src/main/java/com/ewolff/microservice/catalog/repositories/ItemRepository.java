package com.ewolff.microservice.catalog.repositories;


import com.ewolff.microservice.catalog.Item;
import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
@EnableScan
@RepositoryRestResource(collectionResourceRel = "catalog", path = "catalog")
public interface ItemRepository extends
        CrudRepository<Item, String> {

    Optional<Item> findById(@Param("id") String id);

    List<Item> findAllByName(@Param("name") String name);

    List<Item> findAllByNameContaining(@Param("name") String name);

}