package org.example.flashSales.dao;

import org.example.flashSales.domain.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * @description: 用户数据库访问DAO
 */
@Mapper
public interface UserDao {

    /**
     * 根据用户id/手机号查询用户信息
     * @param id
     * @return
     */
    @Select("SELECT * FROM miaosha_user WHERE id = #{id}")
    public User getUserById(@Param("id") Long id);


    @Insert("INSERT INTO miaosha_user VALUES (#{id}, #{nickname}, #{password}, #{salt}, #{head}, #{registerDate}, #{lastLoginDate}, #{loginCount})")
    public void insert(User user);
}