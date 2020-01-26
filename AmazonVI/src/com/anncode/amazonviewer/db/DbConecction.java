package com.anncode.amazonviewer.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import static com.anncode.amazonviewer.db.DataBase.*;

public interface DbConecction {

    default Connection connectToDB(){
        Connection connection = null;

        try{
           // Class.forName("com.mysql.jdbc.Driver");
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(URL+DB,USER,PASSWORD);
            if(connection!=null){
            System.out.println("Conexión realizada");
            }
        }catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            return connection;
        }
     }

}
