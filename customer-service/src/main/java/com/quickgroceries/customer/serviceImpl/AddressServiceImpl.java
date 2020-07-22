package com.quickgroceries.customer.serviceImpl;

import com.quickgroceries.customer.entity.AddressEntity;
import com.quickgroceries.customer.repository.AddressRepository;
import com.quickgroceries.customer.service.AddressEntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AddressServiceImpl implements AddressEntityService {

    @Autowired
    AddressRepository addressRepository;

    public AddressEntity addCustomerAddress(AddressEntity addressEntity) {

        return addressRepository.save(addressEntity);
    }

    public Optional<AddressEntity> getCustomerAddress(long uidpk){
        return addressRepository.findById(uidpk);

    }

}
