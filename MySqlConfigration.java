/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package flight.managment.system;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;
import java.awt.List;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author monirozzaman.rony
 */
public class MySqlConfigration {

    private static Connection con;

    public MySqlConfigration() {
        createTable();
    }

    public static Connection connect() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = (Connection) DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/fms", "root", "");
            return con;
        } catch (Exception e) {
            System.err.println(e);
        }
        return null;
    }

    public static void disconnect() {
        try {
            con.close();
        } catch (SQLException ex) {
            System.err.println(ex);
        }
    }

    private void createTable() {
        ArrayList<String> queryList = new ArrayList<String>();
        queryList.add("CREATE TABLE IF NOT EXISTS `user` ( userId VARCHAR (20),fName VARCHAR(20),lName VARCHAR(20),address VARCHAR(200),zip VARCHAR(20),userName VARCHAR(20),state VARCHAR(20),email VARCHAR(20),password VARCHAR(20),ssn VARCHAR(20),bfName VARCHAR(20));");
        queryList.add("CREATE TABLE IF NOT EXISTS `flight` ( flightId VARCHAR (20),flightTitle VARCHAR(20),`flightFrom` VARCHAR(20),`flightTo` VARCHAR(20),`price` VARCHAR(20),`flightDate` VARCHAR(20),`flightTime` VARCHAR(20),description VARCHAR(200),seat VARCHAR(200));");
        queryList.add("CREATE TABLE IF NOT EXISTS `flight_user` (userId VARCHAR (20),flightId VARCHAR(20));");
        try {
            for (String query : queryList) {
                Statement statement = (Statement) connect().createStatement();
                statement.execute(query);
                statement.close();
                disconnect();
            }
        } catch (Exception ex) {
            System.err.println(ex);
        }
    }
}
