package com.example.demo.service;

import com.example.demo.model.manager;

import java.util.Collection;

public interface Manager_Service {
    void save(manager man);
    manager get(String manager_account);
    void delete(String manager_account);
}
