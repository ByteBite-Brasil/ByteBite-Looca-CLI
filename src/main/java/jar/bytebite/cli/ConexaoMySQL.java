/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jar.bytebite.cli;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.jdbc.core.JdbcTemplate;


/**
 *
 * @author 55119
 */
public class ConexaoMySQL {
     private JdbcTemplate connectionMySQL;

    public ConexaoMySQL() {

        
        BasicDataSource dataSourceMysql = new BasicDataSource();

        dataSourceMysql.setDriverClassName("com.mysql.cj.jdbc.Driver");

        dataSourceMysql.setUrl("jdbc:mysql://172.17.0.2/ByteBite?allowPublicKeyRetrieval=true&autoReconnect=true&useSSL=false");    

        dataSourceMysql.setUsername("root");

        dataSourceMysql.setPassword("urubu100");

        this.connectionMySQL = new JdbcTemplate(dataSourceMysql);
    }

    public JdbcTemplate getConnectionMySQL() {
        return connectionMySQL;
    }
}
