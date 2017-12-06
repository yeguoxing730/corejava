package com.redis.lock;

import java.sql.*;

/**
 * Created with IntelliJ IDEA.
 * User: uc203808
 * Date: 12/6/17
 * Time: 1:22 PM
 * To change this template use File | Settings | File Templates.
 */
public class DBUtil {
   public static Connection conn;
    public static Statement stmt;
    public static void destroy(){
        try {
            stmt.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
    }
    public static void init(){
        String url = "jdbc:mysql://localhost:3306/lyz?"
                + "user=root&password=Welcome1&useUnicode=true&characterEncoding=UTF8";
        try {
            Class.forName("com.mysql.jdbc.Driver");// 动态加载mysql驱动
            conn = DriverManager.getConnection(url);
            stmt = conn.createStatement();
        }  catch (Exception e){
            e.printStackTrace();
        }
    }
    public static void main(String[] args){
        try {
            init();
             insert(35l,"hh",55,22);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                stmt.close();
                conn.close();
            } catch (Exception e) {
                e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
            }

        }
    }

    public static  void insert(Long id,String name,int sex,int age) throws Exception{
        try {
            // 之所以要使用下面这条语句，是因为要使用MySQL的驱动，所以我们要把它驱动起来，
            // 可以通过Class.forName把它加载进去，也可以通过初始化来驱动起来，下面三种形式都可以

            // or:
            // com.mysql.jdbc.Driver driver = new com.mysql.jdbc.Driver();
            // or：
            // new com.mysql.jdbc.Driver();

            System.out.println("成功加载MySQL驱动程序");
            // 一个Connection代表一个数据库连接

            // Statement里面带有很多方法，比如executeUpdate可以实现插入，更新和删除等
           String sql = "insert into user(id,name,sex,age) values("+id+",'"+name+"',"+sex+","+age+")";
           System.out.println(sql);
            int result = stmt.executeUpdate(sql);// executeUpdate语句会返回一个受影响的行数，如果返回-1就没有成功
            if (result != -1) {
                System.out.println("插入数据成功");
            }
        } catch (SQLException e) {
            System.out.println("MySQL操作错误");
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {

        }
    }
}
