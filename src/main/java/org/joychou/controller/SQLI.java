package org.joychou.controller;


import org.joychou.mapper.UserMapper;
import org.joychou.dao.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.sql.*;
import java.util.List;


/**
 * @author  JoyChou (joychou@joychou.org)
 * @date    2018.08.22
 * @desc    SQL Injection
 */

@SuppressWarnings("Duplicates")
@RestController
@RequestMapping("/sqli")
public class SQLI {

    private static String driver = "com.mysql.jdbc.Driver";
    @Value("${spring.datasource.url}")
    private String url;
    @Value("${spring.datasource.username}")
    private String user;
    @Value("${spring.datasource.password}")
    private String password;

    @Autowired
    private UserMapper userMapper;


    /**
     * Vul Code.
     * http://localhost:8080/sqli/jdbc/vul?username=joychou
     *
     * @param username username
     */
    /*有回显的字符型*/
    @RequestMapping("/jdbc/str_echo")
    public String jdbc_sqli_str_echo(@RequestParam("username") String username){
        String result = "";
        try {
            Class.forName(driver);
            Connection con = DriverManager.getConnection(url, user, password);

            if(!con.isClosed())
                System.out.println("Connecting to Database successfully.");

            // sqli vuln code 漏洞代码
             Statement statement = con.createStatement();
             String sql = "select * from users where username = '" + username + "'" ;
             System.out.println(sql);
             ResultSet rs = statement.executeQuery(sql);


            System.out.println("-----------------");

            while(rs.next()){
                String res_name = rs.getString("username");
                String res_pwd = rs.getString("password");
                result +=  res_name + ": " + res_pwd + "\n";
                System.out.println(res_name + ": " + res_pwd);

            }
            rs.close();
            con.close();


        }catch (ClassNotFoundException e) {
            System.out.println("Sorry,can`t find the Driver!");
            e.printStackTrace();
        }catch (SQLException e) {
            e.printStackTrace();
        }catch (Exception e) {
            e.printStackTrace();

        }finally{
            System.out.println("-----------------");
            System.out.println("Connect database done.");
        }
        return result;
    }


    /*有回显的字符型+ limit注入*/
    // 若设置为：@RequestParam("limit") int limit 则不存在limit注入
    @RequestMapping("/jdbc/str_limit_echo")
    public String jdbc_sqli_str_limit_echo(@RequestParam("username") String username, @RequestParam("limit") String limit){
        String result = "";
        try {
            Class.forName(driver);
            Connection con = DriverManager.getConnection(url, user, password);

            if(!con.isClosed())
                System.out.println("Connecting to Database successfully.");

            // sqli vuln code 漏洞代码
            Statement statement = con.createStatement();
            String sql = "select * from users where username = '" + username + "'"  + " LIMIT " + limit ;
            System.out.println(sql);
            ResultSet rs = statement.executeQuery(sql);


            System.out.println("-----------------");

            while(rs.next()){
                String res_name = rs.getString("username");
                String res_pwd = rs.getString("password");
                result +=  res_name + ": " + res_pwd + "\n";
                System.out.println(res_name + ": " + res_pwd);

            }
            rs.close();
            con.close();


        }catch (ClassNotFoundException e) {
            System.out.println("Sorry,can`t find the Driver!");
            e.printStackTrace();
        }catch (SQLException e) {
            e.printStackTrace();
        }catch (Exception e) {
            e.printStackTrace();

        }finally{
            System.out.println("-----------------");
            System.out.println("Connect database done.");
        }
        return result;
    }

    /*基于报错的 字符型+ limit注入*/
    // 若设置为：@RequestParam("limit") int limit 则不存在limit注入
    @RequestMapping("/jdbc/limit_error")
    public String jdbc_sqli_limit_error(@RequestParam("username") String username, @RequestParam("limit") String limit) throws SQLException {
        String result = "";
        try {
            Class.forName(driver);
            Connection con = DriverManager.getConnection(url, user, password);

            if(!con.isClosed())
                System.out.println("Connecting to Database successfully.");

            // sqli vuln code 漏洞代码
            Statement statement = con.createStatement();
            String sql = "select * from users where username = '" + username + "'" + " LIMIT " + limit ;
            System.out.println(sql);
            ResultSet rs = statement.executeQuery(sql);

            while(rs.next()){
                String res_name = rs.getString("username");
                String res_pwd = rs.getString("password");
                result +=  res_name + ": " + res_pwd + "\n";
                System.out.println(res_name + ": " + res_pwd);

            }

            System.out.println("-----------------");

            rs.close();
            con.close();


        }catch (ClassNotFoundException e) {
            System.out.println("Sorry,can`t find the Driver!");
            e.printStackTrace();
        }catch (SQLException e) {
            throw e;
        }catch (Exception e) {
            e.printStackTrace();

        }finally{
            System.out.println("-----------------");
            System.out.println("Connect database done.");
        }
        return result;
    }


    @RequestMapping("/jdbc/limit_blind")
    public String jdbc_sqli_limit_blind(@RequestParam("username") String username, @RequestParam("limit") String limit) throws SQLException {
        String result = "";
        try {
            Class.forName(driver);
            Connection con = DriverManager.getConnection(url, user, password);

            if(!con.isClosed())
                System.out.println("Connecting to Database successfully.");

            // sqli vuln code 漏洞代码
            Statement statement = con.createStatement();
            String sql = "select * from users where username = '" + username + "'" + " LIMIT " + limit ;
            System.out.println(sql);
            ResultSet rs = statement.executeQuery(sql);


            System.out.println("-----------------");
            while(rs.next()){
                String res_name = rs.getString("username");
                String res_pwd = rs.getString("password");
                result +=  res_name + ": " + res_pwd + "\n";
                System.out.println(res_name + ": " + res_pwd);

            }

            rs.close();
            con.close();


        }catch (ClassNotFoundException e) {
            System.out.println("Sorry,can`t find the Driver!");
            e.printStackTrace();
        }catch (SQLException e) {
            e.printStackTrace();
//            throw e;
        }catch (Exception e) {
            e.printStackTrace();

        }finally{
            System.out.println("-----------------");
            System.out.println("Connect database done.");
        }
        return result;
    }


    /* insert型的 报错注入*/
    @RequestMapping("/jdbc/insert_error")
    public String jdbc_sqli_insert_error(@RequestParam("username") String username,
                                 @RequestParam("password") String pass) throws SQLException {
        String result = "";
        try {
            Class.forName(driver);
            Connection con = DriverManager.getConnection(url, user, password);

            if(!con.isClosed())
                System.out.println("Connecting to Database successfully.");

            // sqli vuln code 漏洞代码
            Statement statement = con.createStatement();
            String sql = "insert into users(username, password) values('" + username + "','" +  pass + "')" ;
            System.out.println(sql);

            int rs = statement.executeUpdate(sql);


            System.out.println("-----------------");
            result = "OK";
            con.close();


        }catch (ClassNotFoundException e) {
            System.out.println("Sorry,can`t find the Driver!");
            e.printStackTrace();
        }catch (SQLException e) {
            throw e;
        }catch (Exception e) {
            e.printStackTrace();

        }finally{
            System.out.println("-----------------");
            System.out.println("Connect database done.");
        }
        return result;
    }

    /* insert型的 无报错*/
    @RequestMapping("/jdbc/insert_blind")
    public String jdbc_sqli_insert_blind(@RequestParam("username") String username,
                                         @RequestParam("password") String pass) throws SQLException {
        String result = "";
        try {
            Class.forName(driver);
            Connection con = DriverManager.getConnection(url, user, password);

            if(!con.isClosed())
                System.out.println("Connecting to Database successfully.");

            // sqli vuln code 漏洞代码
            Statement statement = con.createStatement();
            String sql = "insert into users(username, password) values('" + username + "','" +  pass + "')" ;
            System.out.println(sql);

            int rs = statement.executeUpdate(sql);


            System.out.println("-----------------");
            result = "OK";
            con.close();


        }catch (ClassNotFoundException e) {
            System.out.println("Sorry,can`t find the Driver!");
            e.printStackTrace();
        }catch (SQLException e) {
            e.printStackTrace();
//            throw e;
        }catch (Exception e) {
            e.printStackTrace();

        }finally{
            System.out.println("-----------------");
            System.out.println("Connect database done.");
        }
        return result;
    }

    // 数字型，带回显
    @RequestMapping("/jdbc/int_error")
    public String jdbc_sqli_int_error(@RequestParam("id") String id) throws SQLException, ClassNotFoundException {

        PreparedStatement ps = null;
        ResultSet rs = null;
        Class.forName(driver);
        Connection conn = DriverManager.getConnection(url, user, password);

        String result = "";
        String sql = "select username from users where id = " + id;
        System.out.println(sql);
        ps = conn.prepareStatement(sql);

        //ps.setInt(1,id);

        try{
            rs = ps.executeQuery();

            while(rs.next()){
                String res_name = rs.getString("username");
                System.out.println(res_name);
                result +=  res_name + "\n";
            }

            conn.close();
        }
        // 回显的一种方式
        catch(SQLSyntaxErrorException e) {
            return e.toString();
        }

        return result;
    }


    // 数字型
    @RequestMapping("/jdbc/int")
    public String jdbc_sqli_int(@RequestParam("id") String id) throws SQLException, ClassNotFoundException {

        PreparedStatement ps = null;
        ResultSet rs = null;
        Class.forName(driver);
        Connection conn = DriverManager.getConnection(url, user, password);

        String result = "";
        String sql = "select username from users where id = " + id;
        System.out.println(sql);
        ps = conn.prepareStatement(sql);

        //ps.setInt(1,id);

        try{
            rs = ps.executeQuery();

            while(rs.next()){
                String res_name = rs.getString("username");
                System.out.println(res_name);
                result +=  res_name + "\n";
            }

            conn.close();
        }

        catch(SQLSyntaxErrorException e) {
            e.printStackTrace();
        }

        return result;
    }

    // like型，基于报错
    @RequestMapping("/jdbc/like_error")
    public String jdbc_sqli_like_error(@RequestParam("search") String search) throws SQLException, ClassNotFoundException {

        PreparedStatement ps = null;
        ResultSet rs = null;
        Class.forName(driver);
        Connection conn = DriverManager.getConnection(url, user, password);

        String result = "";
        String sql = "SELECT username FROM users WHERE username LIKE '%" + search + "%'";
        System.out.println(sql);
        ps = conn.prepareStatement(sql);

        //ps.setInt(1,id);

        try{
            rs = ps.executeQuery();

            while(rs.next()){
                String res_name = rs.getString("username");
                result +=  res_name + "\n";
            }

            conn.close();
        }
        catch(SQLSyntaxErrorException e) {
            return e.toString();
        }

        return result;
    }

    // like型，无报错
    @RequestMapping("/jdbc/like")
    public String jdbc_sqli_like(@RequestParam("search") String search) throws SQLException, ClassNotFoundException {

        PreparedStatement ps = null;
        ResultSet rs = null;
        Class.forName(driver);
        Connection conn = DriverManager.getConnection(url, user, password);

        String result = "";
        String sql = "SELECT username FROM users WHERE username LIKE '%" + search + "%'";
        System.out.println(sql);
        ps = conn.prepareStatement(sql);

        //ps.setInt(1,id);

        try{
            rs = ps.executeQuery();

            while(rs.next()){
                String res_name = rs.getString("username");
                result +=  res_name + "\n";
            }

            conn.close();
        }
        catch(SQLSyntaxErrorException e) {
            e.printStackTrace();
        }

        return result;
    }


    /*有回显的order by注入*/
    @RequestMapping("/jdbc/order1")
    public String jdbc_sqli_order1(@RequestParam("username") String username,
                                 @RequestParam("sort") String sort){
        String result = "";
        try {
            Class.forName(driver);
            Connection con = DriverManager.getConnection(url, user, password);

            if(!con.isClosed())
                System.out.println("Connecting to Database successfully.");

            // sqli vuln code 漏洞代码
            Statement statement = con.createStatement();
            String sql = "select * from users where username = '" + username + "'" + " order by " + sort;
            System.out.println(sql);
            ResultSet rs = statement.executeQuery(sql);


            System.out.println("-----------------");

            while(rs.next()){
                String res_name = rs.getString("username");
                String res_pwd = rs.getString("password");
                result +=  res_name + ": " + res_pwd + "\n";
                System.out.println(res_name + ": " + res_pwd);

            }
            rs.close();
            con.close();


        }catch (ClassNotFoundException e) {
            System.out.println("Sorry,can`t find the Driver!");
            e.printStackTrace();
        }catch (SQLException e) {
            e.printStackTrace();
        }catch (Exception e) {
            e.printStackTrace();

        }finally{
            System.out.println("-----------------");
            System.out.println("Connect database done.");
        }
        return result;
    }


    /* order by 报错注入*/
    @RequestMapping("/jdbc/order2")
    public String jdbc_sqli_order2(@RequestParam("username") String username,
                                 @RequestParam("sort") String sort) throws SQLException {
        String result = "";
        try {
            Class.forName(driver);
            Connection con = DriverManager.getConnection(url, user, password);

            if(!con.isClosed())
                System.out.println("Connecting to Database successfully.");

            // sqli vuln code 漏洞代码
            Statement statement = con.createStatement();
            String sql = "select * from users where username = '" + username + "'" + " order by " + sort;
            System.out.println(sql);
            ResultSet rs = statement.executeQuery(sql);


            System.out.println("-----------------");

            rs.close();
            con.close();


        }catch (ClassNotFoundException e) {
            System.out.println("Sorry,can`t find the Driver!");
            e.printStackTrace();
        }catch (SQLException e) {
            throw e;
        }catch (Exception e) {
            e.printStackTrace();

        }finally{
            System.out.println("-----------------");
            System.out.println("Connect database done.");
        }
        return result;
    }

    /**
     * Security Code.
     * http://localhost:8080/sqli/jdbc/sec?username=joychou
     *
     * @param username username
     */
    @RequestMapping("/jdbc/sec")
    public String jdbc_sqli_sec(@RequestParam("username") String username){

        String result = "";
        try {
            Class.forName(driver);
            Connection con = DriverManager.getConnection(url, user, password);

            if(!con.isClosed())
                System.out.println("Connecting to Database successfully.");


            // fix code
            String sql = "select * from users where username = ?";
            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1, username);
            System.out.println(st.toString());  // sql after prepare statement
            ResultSet rs = st.executeQuery();

            System.out.println("-----------------");

            while(rs.next()){
                String res_name = rs.getString("username");
                String res_pwd = rs.getString("password");
                result +=  res_name + ": " + res_pwd + "\n";
                System.out.println(res_name + ": " + res_pwd);

            }
            rs.close();
            con.close();


        }catch (ClassNotFoundException e) {
            System.out.println("Sorry,can`t find the Driver!");
            e.printStackTrace();
        }catch (SQLException e) {
            e.printStackTrace();
        }catch (Exception e) {
            e.printStackTrace();

        }finally{
            System.out.println("-----------------");
            System.out.println("Connect database done.");
        }
        return result;
    }


    @RequestMapping("/jdbc/sec1")
    public String jdbc_sqli_sec1(@RequestParam("userId") int userId){

        String result = "";
        try {
            Class.forName(driver);
            Connection con = DriverManager.getConnection(url, user, password);

            if(!con.isClosed())
                System.out.println("Connecting to Database successfully.");


            // fix code
            String sql = "select * from users where username = ?";
            PreparedStatement st = con.prepareStatement(sql);
            st.setInt(1, userId);
            System.out.println(st.toString());  // sql after prepare statement
            ResultSet rs = st.executeQuery();

            System.out.println("-----------------");

            while(rs.next()){
                String res_name = rs.getString("userId");
                String res_pwd = rs.getString("password");
                result +=  res_name + ": " + res_pwd + "\n";
                System.out.println(res_name + ": " + res_pwd);

            }
            rs.close();
            con.close();


        }catch (ClassNotFoundException e) {
            System.out.println("Sorry,can`t find the Driver!");
            e.printStackTrace();
        }catch (SQLException e) {
            e.printStackTrace();
        }catch (Exception e) {
            e.printStackTrace();

        }finally{
            System.out.println("-----------------");
            System.out.println("Connect database done.");
        }
        return result;
    }


    /**
     * vul code
     * http://localhost:8080/sqli/mybatis/vul01?username=joychou' or '1'='1
     *
     * @param username username
     */
    @RequestMapping("/mybatis/vul01")
    public List<User> mybatis_vul1(@RequestParam("username") String username) {
        return userMapper.findByUserNameVul(username);
    }

    /**
     * vul code
     * http://localhost:8080/sqli/mybatis/vul02?username=joychou' or '1'='1' %23
     *
     * @param username username
     */
    @RequestMapping("/mybatis/vul02")
    public List<User> mybatis_vul2(@RequestParam("username") String username) {
        return userMapper.findByUserNameVul2(username);
    }


    /**
     * vul code
     *
     *
     * @param username username
     */
    @GetMapping("/mybatis/vuln_like")
    public List<User> mybatis_vuln_like(@RequestParam("username") String username) {
        return userMapper.findByUserNameVulLike(username);
    }


    @GetMapping("/mybatis/vuln_like2")
    public List<User> mybatis_vuln_like2(@RequestParam("username") String username) {
        return userMapper.findByUserNameVulLike2(username);
    }

    @GetMapping("/mybatis/sec_like")
    public List<User> mybatis_sec_like(@RequestParam("username") String username) {
        return userMapper.findByUserNameSecLike(username);
    }


    /*
    order by注入
     */
    @GetMapping("/mybatis/vuln_order")
    public List<User> mybatis_vuln_order(@RequestParam("order") String order) {
        return (List<User>) userMapper.OrderByVuln(order);
    }


    @GetMapping("/mybatis/vuln_order2")
    public List<User> mybatis_vuln_order2(@RequestParam("order") String order) {
        return (List<User>) userMapper.OrderByVuln2(order);
    }

    @GetMapping("/mybatis/sec_order")
    public List<User> mybatis_sec_order(@RequestParam("order") String order) {
        return (List<User>) userMapper.OrderBySec(order);
    }


    @GetMapping("/mybatis/sec_order2")
    public List<User> mybatis_sec_order2(@RequestParam("order") String order) {
        return (List<User>) userMapper.OrderBySec2(order);
    }

    /**
     * security code
     * http://localhost:8080/sqli/mybatis/sec01?username=joychou
     *
     * @param username username
     */
    @GetMapping("/mybatis/sec01")
    public List<User> mybatis_sec1(@RequestParam("username") String username) {
        return userMapper.findByUserName(username);
    }

    /**
     * security code
     * http://localhost:8080/sqli/mybatis/sec02?id=1
     *
     * @param id id
     */
    @GetMapping("/mybatis/sec02")
    public List<User> mybatis_sec2(@RequestParam("id") Integer id) {
        return userMapper.findById(id);
    }


    /**
     * security code
     * http://localhost:8080/sqli/mybatis/sec03
     **/
    @GetMapping("/mybatis/sec03")
    public List<User> mybatis_sec3() {
        return userMapper.OrderByUsername();
    }


}
