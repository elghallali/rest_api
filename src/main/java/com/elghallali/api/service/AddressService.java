package com.elghallali.api.service;

import com.elghallali.api.model.Address;
import com.elghallali.api.model.Customer;

public interface AddressService {
    Address createAddress(Address address);
    Address updateAddress(Address address);
    Address deleteAddress(Address address);
    Address getAddress(Long id);
}
