package com.example.demo.service;

import com.example.demo.model.*;

import java.util.Collection;
import java.util.List;

public interface Return_Service {
//    List<nursereturnrecord> get_nurse_record();
//    Boolean insert_nurse_record(nursereturnrecord content);
//    Boolean delete_nurse_record(Integer id);
//    nursereturnrecord get_one_record(Integer id);
//    Boolean update_nurse_record(nursereturnrecord content);
//    List<cusreturnrecord> get_cus_record();
//    Boolean insert_cus_record(cusreturnrecord content);
//    Boolean delete_cus_record(Integer id);
//    cusreturnrecord get_a_record(Integer id);
//    Boolean update_cus_record(cusreturnrecord content);
//    List<cusreturn> get_cus_return();
//    nursereturn get_anurse_return(Integer id);
//    cusreturn get_acus_return(Integer id);
List<nursereturnrecord> get_nurse_record();
    Boolean insert_nurse_record(nursereturnrecord content);
    Boolean delete_nurse_record(Integer id);
    nursereturnrecord get_one_record(Integer id);
    Boolean update_nurse_record(nursereturnrecord content);
    List<cusreturnrecord> get_cus_record();
    Boolean insert_cus_record(cusreturnrecord content);
    Boolean delete_cus_record(Integer id);
    cusreturnrecord get_a_record(Integer id);
    Boolean update_cus_record(cusreturnrecord content);

    List<cusreturn> get_cus_return();

    cusreturn get_acus_return(Integer id);

    List<nursereturn> get_nurse_return();
    nursereturn get_anurse_return(Integer id);
}
