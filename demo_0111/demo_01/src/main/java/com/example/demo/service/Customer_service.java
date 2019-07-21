package com.example.demo.service;

import com.example.demo.model.customer;

import java.util.Collection;

public interface Customer_service {
    void save(customer new_customer);
    Collection<customer> getAll();
    customer get(String account);
    void delete(String account);
}
