/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.classes;

import java.security.SecureRandom;
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

    public User(String userName, String email, String password, String country) {
        this.userName = userName;
        this.email = email;
        this.password = password;
        this.country = country;
    }

    public User(String email, String password) {
        this.email = email;
        this.password = password;
    }
    
    

    public User(String userID) {
        this.userID = userID;
    }
    
    

    public User() {
    }
    
    
    // Generating random token 
    public static String generateRandomToken(int byteLength) {
        SecureRandom random = new SecureRandom();
        byte[] bytes = new byte[byteLength];
        random.nextBytes(bytes);
        StringBuilder sb = new StringBuilder(byteLength * 2);
        for (byte b : bytes) {
            sb.append(String.format("%02x", b));
        }
        return sb.toString();
    }
    
    // Updating user token
    public void updateUserToken(String token) {
        try {
            PreparedStatement stmt = this.conn.prepareStatement("UPDATE user SET token = ? WHERE user_ID = ?");
            stmt.setString(1, token);
            stmt.setString(2, this.userID);
            stmt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    // Adding valuse of the class to the database
    public boolean saveValues() {
        try {
            PreparedStatement stmt = this.conn.prepareStatement("INSERT INTO user (user_ID, user_name, email, password_hash, country) VALUES(?, ?, ?, ?, ?)");
            stmt.setString(1, this.generateID("US", "user", "user_ID"));
            stmt.setString(2, this.userName);
            stmt.setString(3, this.email);
            stmt.setString(4, this.password);
            stmt.setString(5, this.country);
            
            return stmt.executeUpdate() > 0;
       
        } catch (SQLException ex) {
            Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return false;
    }
    
    public String generateID(String prefix, String tableName, String columnName) {
        try {
            PreparedStatement stmt = this.conn.prepareStatement("SELECT " + columnName + " FROM " + tableName + " ORDER BY "+ columnName + " DESC LIMIT 1");
            ResultSet rs = stmt.executeQuery();
            if(rs.next()) {
                String lastID = rs.getString(columnName);
                int numID = Integer.valueOf(lastID.substring(2));
                numID++;
                
                String newStringID = String.valueOf(numID);
                for(int i = 0; i < 16 - newStringID.length(); i++) {
                    prefix += "0";
                }
                prefix  += newStringID;
            } else {
                prefix += "0000000000000001";
            }
        } catch (SQLException ex) {
            System.out.println("Here is the error...." + ex);
            Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return prefix;
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
    
    // Cookie authorization
    public boolean cookieAuthorization(String token) {
        try {
            PreparedStatement stmt = this.conn.prepareStatement("SELECT * FROM user WHERE token = ?");
            stmt.setString(1, token);
            ResultSet rs = stmt.executeQuery();
            
            if(rs.next()) {
                this.userName = rs.getString("user_name");
                this.email = rs.getString("email");
                this.userID = rs.getString("user_ID");
                this.country = rs.getString("country");
                this.userID = rs.getString("user_ID");
                
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return false;
    
    }
    
    
    public boolean userAuthentication() {
        try {
            PreparedStatement stmt = this.conn.prepareStatement("SELECT * FROM user WHERE email = ? LIMIT 1");
            stmt.setString(1, this.email);
            
            ResultSet rs = stmt.executeQuery();
            if(rs.next()) {
                // User email is present in the database
                if(rs.getString("password_hash").equals(MD5.getMd5(this.password))) {
                    // Setting up values 
                    this.userName = rs.getString("user_name");
                    this.email = rs.getString("email");
                    this.userID = rs.getString("user_ID");
                    this.country = rs.getString("country");
                    this.userID = rs.getString("user_ID");
                    
                    return true;
                }
            } 
        } catch (SQLException ex) {
            Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return false;
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
