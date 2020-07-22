package com.quickgroceries.customer.service;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.quickgroceries.customer.entity.AddressEntity;
import com.quickgroceries.customer.repository.AddressRepository;

@Service
public interface AddressEntityService {

	public AddressEntity addCustomerAddress(AddressEntity addressEntity);
	public Optional<AddressEntity> getCustomerAddress(long uidpk);

	
}
