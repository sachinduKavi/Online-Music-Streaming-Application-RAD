/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.classes;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Sachindu Kavishka
 */
public class User {
    private String userID;
    private String userName;
    private String email;
    private String password;
    private String country;
    private Connection conn = DbConnection.getConnection();

    public User(String userID, String userName, String email, String password, String country) {
        this.userID = userID;
        this.userName = userName;
        this.email = email;
        this.password = password;
        this.country = country;
    }

    public User(String userID) {
        this.userID = userID;
    }
    
    

    public User() {
    }
    
    
    
    public void fetchUserDetails() {
        PreparedStatement stmt;
        try {
            stmt = this.conn.prepareStatement("SELECT * FROM user WHERE user_ID = ? LIMIT 1");
            stmt.setString(1, this.userID);
            
            ResultSet rs = stmt.executeQuery();
            
            if(rs.next()) {
                this.userName = rs.getString("user_name");
                this.email = rs.getString("email");
                this.country = rs.getString("country");
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }
    
    

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
    
    
    
}
