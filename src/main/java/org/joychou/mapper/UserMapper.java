package org.joychou.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.joychou.dao.User;

import java.util.List;

@Mapper
public interface UserMapper {

    /**
     * If using simple sql, we can use annotation. Such as @Select @Update.
     * If using ${username}, application will send a error.
     */
    @Select("select * from users where username = #{username}")
    List<User> findByUserName(@Param("username") String username);

    @Select("select * from users where username = '${username}'")
    List<User> findByUserNameVul(@Param("username") String username);

    List<User> findByUserNameVul2(String username);

    /*
    like的注入问题 # 会自带单引号'
     */
    @Select("select * from users where username LIKE %#{username}%")
    List<User> findByUserNameVulLike(String username);

    @Select("select * from users where username LIKE '%${username}%'")
    List<User> findByUserNameVulLike2(String username);

    @Select("select * from users where username LIKE CONCAT('%',#{username},'%')")
    List<User> findByUserNameSecLike(String username);


    /*
    in的注入问题
    */
    @Select("select * from users where username in (#{username})")
    List<User> findByUserNameVulIn(String username);

    @Select("select * from users where username in (${username})")
    List<User> findByUserNameVulIn2(String username);

    //@Select("select * from users where username in <foreach collection=\"username\" item=\"username\" open=\"(\"separator=\",\" close=\")\">#{username} </foreach>")
    List<User> findByUserNameSecIn(String username);


    List<User> findById(Integer id);

    List<User> OrderByUsername();

    List<User> OrderByVuln(String order);

    List<User> OrderByVuln2(String order);

    List<User> OrderBySec(String order);

    List<User> OrderBySec2(String order);

}
