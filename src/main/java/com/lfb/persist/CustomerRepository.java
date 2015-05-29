package com.lfb.persist;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


@Repository
public interface CustomerRepository extends CrudRepository<Customer, Long> {

	@Query("select c from Customer c where c.lastname = :lastname")
    List<Customer> findByLastName(@Param("lastname")String lastName);
}