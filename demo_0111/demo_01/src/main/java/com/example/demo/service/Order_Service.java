package com.example.demo.service;


import com.example.demo.model.orderinfo;

import java.util.Collection;
import java.util.Date;

public interface Order_Service {
    void save(orderinfo order);
    Collection<orderinfo> getAll();
    orderinfo get(Integer id);

    Collection<orderinfo> get_order_cusbefore(String account, Date date);
    Collection<orderinfo> get_order_cusfinish(String account, Date date);



    Collection<orderinfo> get_order(String account, Date date);

    Collection<orderinfo> get_order_finish(String account, Date date);

    void delete(Integer id);
}
