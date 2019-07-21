package com.example.demo.mapper;

import com.example.demo.model.*;
import org.apache.ibatis.annotations.*;

import java.util.Date;
import java.util.List;

public interface CustomerMapper {
    //用户登录
    @Select("select * from customer where cus_account = #{arg0} and cus_password = #{arg1}")
    customer cus_login(String account, String password);
    //
    @Select("select * from customer where cus_name = #{arg0}")
    customer cus_name_get(String name);

    //用户登录时间登记
    @Update("update customer set cus_time_signin = #{arg1} where cus_account = #{cus_account}")
    int cus_sign_time(customer this_customer,Date sign);
    //查看用户信息
    @Select("select * from customer where cus_account = #{arg0} ")
    customer cus_info(String account);
    //修改用户信息
    @Update("update customer set cus_password = #{cus_password},cus_name = #{cus_name},cus_gender = #{cus_gender},cus_phone = #{cus_phone},cus_address = #{cus_address},cus_time_signin = #{cus_time_signin} where cus_account = #{cus_account} ")
    int cus_update(customer newinfo);
    //提交一个订单
    @Insert("insert into orderinfo(cus_account,nurse_account,order_begintime,order_endtime) values(#{cus_account},#{nurse_account},#{order_begintime},#{order_endtime}) ")
    @Options(useGeneratedKeys = true, keyProperty = "order_id")
    int new_order(orderinfo order);

    @Update("update orderinfo set order_begintime = #{order_begintime},order_endtime = #{order_begintime} where  cus_account = #{cus_account} and nurse_account = #{nurse_account}")
    int update_order(orderinfo order);

    //用户回访查看订单
    @Select("select * from orderinfo where cus_account = #{cus_account}")
    List<orderinfo> getorder(customer this_customer);
    //用户取消一个订单
    @Delete("delete from orderinfo where cus_account = #{cus_account} and nurse_account = #{nurse_account} and order_time = #{order_time} and order_begintime = #{order_begintime} and order_endtime = #{order_endtime}")
    int resolveorder(orderinfo order);
    //用户回访记录登记
    @Insert("insert into cusreturn(cus_account,cusreturn_id,nurse_account,cus_return_time) values(#{cus_account},#{cusreturn_id},#{nurse_account},#{cus_return_time})")
    int cus_return(cusreturn record) ;
    //用户回访评价
    @Insert("insert cusreturnrecord(cusreturn_id,cusreturn_content) values(#{cusreturn_id},#{cusreturn_content})")
    int insert_record(cusreturnrecord record);
    //用户查看评价
    @Select("select * from cusreturnrecord where cusreturn_id = #{arg0}")
    cusreturnrecord show_record(Integer id);
    //用户修改评价
    @Update("update cusreturnrecord set cusreturn_content = #{cusreturn_content} where cusreturn_id = #{cusreturn_id}")
    int update(cusreturnrecord record);
    //用户查看育婴师评价
    @Select("select * from nursereturnrecord where nursereturn_id = #{arg0}")
    nursereturnrecord read_record(Integer id);

    @Delete("delete from cusreturnrecord where cusreturn_id = #{arg0}")
    int delete_cus_record(Integer id);

    @Insert("insert into customer(cus_account,cus_password,cus_name,cus_gender,cus_phone,cus_address,cus_time_signin) values(#{cus_account},#{cus_password},#{cus_name},#{cus_gender},#{cus_phone},#{cus_address},#{cus_time_signin})")
    int insert_cus(customer newcustomer);
}