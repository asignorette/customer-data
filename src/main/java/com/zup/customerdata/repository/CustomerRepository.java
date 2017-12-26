package com.zup.customerdata.repository;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.zup.customerdata.entity.Customer;



/**
 * Interface that represent Customer Dao.
 * The method findByName and findByNameOrderByName are example of the spring data, but there many extends from 
 * PagingAndSortingRepository.
 * @author asignorette.
 *
 */
@RepositoryRestResource(collectionResourceRel = "customer", path = "customers")
public interface CustomerRepository  extends PagingAndSortingRepository<Customer, Long> { 
	
	
    /**
     * Method for find Customer by name.
     * @param name String.
     * @return list Customer.
     */     
    List<Customer> findByName(@Param("name") String name);
    
    /**
     * Method for find by name and order by name.
     *  
     * @param name String.
     * @return list Customer.
     */
    List<Customer> findByNameOrderByName(@Param("name") String name);

}
