package main.jstack;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @Author: dongcx
 * @Description:
 * @Date: 2021-02-02
 **/
public class JStackMainApp {
    public static void main(String[] args) throws SQLException {
//        ServiceLoader<CustomSpi> customSpis = ServiceLoader.load(CustomSpi.class);
//        Iterator iterator =  customSpis.iterator();
//        iterator.hasNext();
//        iterator.next();
//        new Thread()
//        try {
//            Class<?> x = Class.forName("[I");
//            System.out.println(ClassLoader.getSystemClassLoader().loadClass("[I"));
//            System.out.println(x);
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        }
        Connection connection = DriverManager.getConnection("jdbc:mysql://mysql:3306/pupu_log", "root","example");
        System.out.println(connection);
//        System.out.println(connection.getClass().getClassLoader());
//        System.out.println(java.sql.Connection.class.getClassLoader());

    }
}
