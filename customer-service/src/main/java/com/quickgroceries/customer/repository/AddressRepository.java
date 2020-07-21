package com.quickgroceries.customer.repository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.quickgroceries.customer.entity.AddressEntity;

@Repository
public interface AddressRepository extends CrudRepository<AddressEntity, Long>{

}
