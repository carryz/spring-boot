package com.example.demo.mapper;

import com.example.demo.model.nursereturnrecord;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Repository
public class NurseReturn_TestDao {
    private static Map<Integer, nursereturnrecord> nurse_record = null;

    //private nursereturnrecord record = new nursereturnrecord();
    static{
        String content[] ={"强啊！","牛逼啊！","厉害啊！","有钱啊！"};
        nurse_record = new HashMap<Integer,nursereturnrecord>();
        nursereturnrecord record = new nursereturnrecord();
        record.setNursereturn_id(1001);
        record.setNursereturn_content(content[0]);
        nursereturnrecord record1 = new nursereturnrecord();
        record1.setNursereturn_id(1002);
        record1.setNursereturn_content(content[1]);
        nursereturnrecord record2 = new nursereturnrecord();
        record2.setNursereturn_id(1003);
        record2.setNursereturn_content(content[2]);
        nursereturnrecord record3 = new nursereturnrecord();
        record3.setNursereturn_id(1004);
        record3.setNursereturn_content(content[3]);
        nurse_record.put(1001,record);
        nurse_record.put(1002,record1);
        nurse_record.put(1003,record2);
        nurse_record.put(1004,record3);
    }

    private static Integer initId = 1005;

    public void save(nursereturnrecord record){
        if(record.getNursereturn_id() == null){
            record.setNursereturn_id(initId++);
        }
        System.out.println(record.getNursereturn_content());
        nurse_record.put(record.getNursereturn_id(), record);
    }

    public Collection<nursereturnrecord> getAll(){
        return nurse_record.values();
    }

    public nursereturnrecord get(Integer id){
        return nurse_record.get(id);
    }

    public void delete(Integer id){
        nurse_record.remove(id);
    }
}
