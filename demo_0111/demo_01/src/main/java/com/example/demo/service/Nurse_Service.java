package com.example.demo.service;

import com.example.demo.model.newnurseinfo;
import com.example.demo.model.nurse;

import java.util.Collection;
import java.util.Date;

public interface Nurse_Service {
    Collection<nurse> getAll();
    void save(nurse new_nurse);
    nurse get(String nurse_account);
    void delete(String nurse_account);
    void delete_new(String new_nurse);
    void insert(newnurseinfo newnurse);
    newnurseinfo get_new(String account);
    Collection<newnurseinfo> show_new();
}
