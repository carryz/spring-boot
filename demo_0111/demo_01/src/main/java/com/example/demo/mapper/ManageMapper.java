package com.example.demo.mapper;

import com.example.demo.model.*;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Date;
import java.util.List;

public interface ManageMapper {
    //管理员登陆
    @Select("Select * from manager where manager_account = #{arg0} and manager_password = #{arg1}")
    manager findmanage(String account,String password);
    //查看全部订单
    @Select("select * from orderinfo")
    Collection<orderinfo> showorder();
    //查看单一用户的订单
    @Select("select * from orderinfo where cus_account = #{arg0} and order_endtime > #{arg1}")
    List<orderinfo> cusorder(String user,Date date);
    //查看单一育婴师的订单
    @Select("select * from orderinfo where nurse_account = #{arg0} and order_endtime > #{arg1}")
    List<orderinfo> nurseorder(String user,Date date);
    //

    @Select("select * from orderinfo where cus_account = #{arg0} and order_endtime < #{arg1}")
    List<orderinfo> cusorder_finish(String user,Date date);

    @Select("select * from orderinfo where nurse_account = #{arg0} and order_endtime <= #{arg1}")
    List<orderinfo> nurseorder_finish(String user,Date date);

    @Select("select * from orderinfo where order_id = #{arg0}")
    orderinfo get_order(Integer id);

    @Insert("insert into orderinfo(cus_account,nurse_account,order_time,order_begintime,order_endtime) values(#{cus_account},#{nurse_account},#{order_time},#{order_begintime},#{order_endtime})")
    @Options(useGeneratedKeys = true, keyProperty = "order_id")
    int insert_order(orderinfo order);

    @Update("update orderinfo set cus_account = #{cus_account},nurse_account = #{nurse_account},order_time = #{order_time},order_begintime = #{order_begintime},order_endtime=#{order_endtime} where order_id = #{order_id}")
    int update_order(orderinfo order);

    @Delete("delete from orderinfo where order_id = #{order_id}")
    int delete_order(Integer order_id);

    //根据订单时间查看订单
    @Select("select * from orderinfo where order_time = #{date}")
    List<orderinfo> idorder(Date date);
    //查看用户信息
    @Select("select * from customer")
    Collection<customer> cus_info();
    //查看育婴师信息
    @Select("select * from nurse")
    Collection<nurse> nurse_info();
    //
    @Select("select * from cusreturn where cusreturn_id = #{arg0}")
    cusreturn show_a_cusreturn(Integer id);
    //根据用户名字查询信息
    @Select("select * from customer where cus_name = #{arg0}")
    List<customer> cus_name_info(String name);
    //根据用户账号查询
    @Select("select * from customer where cus_account = #{arg0}")
    customer cus_account_info(String name);
    //
    @Delete("delete from customer where cus_account = #{arg0}")
    int delete_cus(String account);
    //根据用户性别查询
    @Select("select * from customer where cus_gender = #{gender}")
    List<customer> cus_gender_info(String gender);
    //根据用户电话号码查询
    @Select("select * from customer where cus_phone = #{phone}")
    List<customer> cus_phone_info(String phone);
    //根据用户地址查询
    @Select("select * from customer where cus_address = #{address}")
    List<customer> cus_address_info(String address);
    //根据育婴师名字查询信息
    @Select("select * from nurse where nurse_name = #{name}")
    List<nurse> nurse_name_info(String name);
    //根据育婴师账号查询
    @Select("select * from nurse where nurse_account = #{arg0} ")
    nurse nurse_account_info(String account);
    //根据育婴师性别查询
    @Select("select * from nurse where nurse_gender = #{gender}")
    List<nurse> nurse_gender_info(String gender);
    //根据育婴师图片查询
    @Select("select * from nurse where nurse_picture = #{picture}")
    List<nurse> nurse_picture_info(String picture);
    //根据育婴师邮件地址查询
    @Select("select * from nurse where nurse_email = #{email}")
    List<nurse> nurse_email_info(String email);
    //根据育婴师QQ查询
    @Select("select * from nurse where nurse_qq = #{qq}")
    List<nurse> nurse_qq_info(String qq);
    //根据育婴师电话号码查询
    @Select("select * from nurse where nurse_phone = #{phone}")
    List<nurse> nurse_phone_info(String phone);
    //根据育婴师级别查询
    @Select("select * from nurse where nurse_level = #{level}")
    List<nurse> nurse_level_info(int level);
    //根据育婴师工作状态查询
    @Select("select * from nurse where nurse_state = #{state}")
    List<nurse> nurse_state_info(String state);
    //根据育婴师的价格查询
    @Select("select * from nurse where nurse_price = #{price}")
    List<nurse> nurse_price_info(float price);

    @Select("select * from nursereturn where nursereturn_id = #{arg0}")
    nursereturn show_a_nursereturn(Integer id);
    //确定育婴师修改、提交信息
    @Update("update  nurse set nurse_password = #{new_password},nurse_name = #{new_name},nurse_gender = #{new_gender},nurse_picture = #{new_pic},nurse_email = #{new_email},nurse_qq = #{new_qq},nurse_phone = #{new_phone},nurse_level = #{new_level},nurse_price = #{new_price},nurse_time_entry = #{new_time_entry},nurse_intro = #{new_intro},nurse_state = '在职' where nurse_account = #{new_account}")
    void updatenursse(newnurseinfo new_nurse);

    //驳回育婴师修改
    @Delete("delete from newnurseinfo where new_account = #{new_account}")
    void noupdatenurse(String new_nurse);
    //创建新育婴师账号
    @Insert("insert into nurse(nurse_account,nurse_password,nurse_name,nurse_gender,nurse_picture,nurse_email,nurse_qq,nurse_phone,nurse_level,nurse_price,nurse_time_entry,nurse_intro,nurse_state) values(#{nurse_account},#{nurse_password},#{nurse_name},#{nurse_gender},#{nurse_picture},#{nurse_email},#{nurse_qq},#{nurse_phone},#{nurse_level},#{nurse_price},#{nurse_time_entry},#{nurse_intro},#{nurse_state})")
    void newnurse(nurse new_nurse);

    @Update("update  nurse set nurse_password = #{nurse_password},nurse_name = #{nurse_name},nurse_gender = #{nurse_gender},nurse_picture = #{nurse_picture},nurse_email = #{nurse_email},nurse_qq = #{nurse_qq},nurse_phone = #{nurse_phone},nurse_level = #{nurse_level},nurse_price = #{nurse_price},nurse_time_entry = #{nurse_time_entry},nurse_intro = #{nurse_intro},nurse_state = #{nurse_state} where nurse_account = #{nurse_account}")
    void update_nurse(nurse new_nurse);

    @Delete("delete from nurse where nurse_account = #{arg0}")
    void delete_nurse(String account);

    //查看用户回访记录
    @Select("select * from cusreturn")
    List<cusreturn> show_cusreturn();

    //查看育婴师回访记录
    @Select("select * from nursereturn")
    List<nursereturn> show_nursereturn();

    //查看所有修改申请
    @Select("select * from newnurseinfo")
    Collection<newnurseinfo> show_update();

    @Select("select * from newnurseinfo where new_account = #{arg0}")
    newnurseinfo get_new_nurse(String account);

    //查看所有用户回访评价
    @Select("select * from cusreturnrecord")
    List<cusreturnrecord> show_cusrecord();

    //查看所有育婴师回访评价
    @Select("select * from nursereturnrecord")
    List<nursereturnrecord> show_nurserecord();
    //
    @Select("select * from manager where manager_name = #{arg0}")
    manager find_name_manager(String name);
    //
    @Select("select * from manager where manager_account = #{arg0}")
    manager find_username_manager(String username);
    //查找所有管理
    @Select("select * from manager where manager_name = #{arg0} and manager_account = #{arg1}")
    manager find_all_name_manager(String name,String username);
    //插入管理账号
    @Update("update  manager set manager_password = #{manager_password},manager_name = #{manager_name},manager_gender = #{manager_gender},manager_phone = #{manager_phone},manager_email = #{manager_email} where  manager_account = #{manager_account} ")
    int insert_manager(manager man);
    //查看特定评价
    @Select("select * from nursereturnrecord where nursereturn_id = #{arg0}")
    nursereturnrecord get_anurse_record(Integer id);
}
