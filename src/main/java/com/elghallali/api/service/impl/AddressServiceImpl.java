package com.elghallali.api.service.impl;

import com.elghallali.api.model.Address;
import com.elghallali.api.repository.AddressRepository;
import com.elghallali.api.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddressServiceImpl implements AddressService {

    @Autowired
    private AddressRepository addressRepository;
    @Override
    public Address createAddress(Address address) {
        return addressRepository.save(address);
    }

    @Override
    public Address updateAddress(Address address) {
        Address addressDB = this.getAddress(address.getId());
        if (addressDB==null){
            return null;
        }
        addressDB.setName(address.getName());
        return addressRepository.save(addressDB);
    }

    @Override
    public Address deleteAddress(Address address) {
        return null;
    }

    @Override
    public Address getAddress(Long id) {
        return addressRepository.findById(id).orElse(null);
    }
}
