package com.example.demo.mapper;

import com.example.demo.model.*;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface NurseMapper {
//    //查看所有育婴师
//    @Select("select * from nurse")
//    List<String> findall() ;
    //育婴师登陆
    @Select("select * from nurse where nurse_account = #{arg0} and nurse_password = #{arg1}")
    nurse login_find(String account,String password);
    //查看育婴师具体信息
    @Select("select * from nurse where nurse_picture = #{arg0}")
    nurse shownursedetail(String nurse_picture);
    //育婴师更新信息，暂存在newnurseinfo表中，待管理员同意更新
    @Insert("insert into newnurseinfo(new_account,new_password,new_name,new_gender,new_pic,new_email,new_qq,new_phone,new_level,new_price,new_time_entry,new_intro) values(#{new_account},#{new_password},#{new_name},#{new_gender},#{new_pic},#{new_email},#{new_qq},#{new_phone},#{new_level},#{new_price},#{new_time_entry},#{new_intro})")
    int updatenurse(newnurseinfo new_nurse);
    //育婴师建立新用户
    @Insert("insert into nurse(nurse_account,nurse_password,nurse_name) values(#{nurse_account},#{nurse_password},#{nurse_name})")
    int newnurse(nurse new_nurse);
    //育婴师确认订单
    @Update("update orderinfo set order_time = #{order.order_time} where cus_account = #{order.cus_account} and nurse_account = #{order.nurse_account}")
    int setorder(orderinfo order);
    //育婴师拒绝订单
    @Delete("delete from orderinfo where cus_account = #{order.cus_account} and nurse_account = #{order.nurse_account}")
    int endorder(orderinfo order);
    //育婴师回访查看订单
    @Select("select * from orderinfo where nurse_account = #{this_nurse.nurse_account}")
    List<orderinfo> nurse_return(nurse this_nurse);
    //育婴师回访记录
    @Insert("insert into nursereturn(cus_account,nurse_account,nursereturn_id,nurse_return_timr) values(#{record.cus_account},#{record.nurse_account},#{record.nursereturn_id},#{record.nurse_return_timr})")
    int insert_record(nursereturn record);
    //育婴师回访评价
    @Insert("insert into nursereturnrecord(nursereturn_id,nursereturn_content) values(#{nursereturn_id},#{nursereturn_content})")
    int nurse_content(nursereturnrecord content);
    //育婴师查看用户评价
    @Select("slect * from cusreturnrecord where cusreturn_id = #{id}")
    cusreturnrecord showcontent(Integer id);
    //育婴师查看评价
    @Select("select * from nursereturnrecord where cusreturn_id = #{id}")
    List<nursereturnrecord> show_nurse_record(Integer id);
    //育婴师修改评价
    @Update("update nursereturnrecord set nursereturn_content = #{nursereturn_content} where nursereturn_id = #{nursereturn_id}")
    int update_record(nursereturnrecord content);
    //育婴师删除评价
    @Delete("delete from nursereturnrecord where nursereturn_id = #{arg0}")
    int delete_record(Integer id);

    //
    @Select("select * from nurse where nurse_name = #{arg0}")
    nurse get_name_nurse(String name);

    //
    @Select("select * from nurse where nurse_account = #{arg0}")
    nurse get_username_nurse(String username);
}
