package com.quickgroceries.customer.service;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.quickgroceries.customer.entity.AddressEntity;
import com.quickgroceries.customer.repository.AddressRepository;

@Service
public class AddressEntityService {
    
	@Autowired
	AddressRepository addressRepository;
	
	public AddressEntity addCustomerAddress(AddressEntity addressEntity) {
		
		return addressRepository.save(addressEntity);
	}
	
	public Optional<AddressEntity> getCustomerAddress(int uidpk){
		return addressRepository.findById(uidpk);
		
	}
	
	
}
