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
public class Music {
    Connection conn = DbConnection.getConnection();
    
    private String musicID;
    private String musicName;
    private String artistName;
    private float rating;
    private String sourceURL;
    private String coverURL;
    private String language;

    public Music(String musicID, String musicName, String artistName, float rating, String sourceURL, String coverURL, String language) {
        this.musicID = musicID;
        this.musicName = musicName;
        this.artistName = artistName;
        this.rating = rating;
        this.sourceURL = sourceURL;
        this.coverURL = coverURL;
        this.language = language;
    }

    public Music(String musicName, String artistName, float rating, String sourceURL, String coverURL, String language) {
        this.musicName = musicName;
        this.artistName = artistName;
        this.rating = rating;
        this.sourceURL = sourceURL;
        this.coverURL = coverURL;
        this.language = language;
    }

    public Music() {
    }

    public Music(String musicID) {
        this.musicID = musicID;
    }
    
    
    public void fetchValuesFromDatabase() {
        try {
            PreparedStatement stmt = this.conn.prepareStatement("SELECT * FROM music WHERE music_ID = ?");
            stmt.setString(1, this.musicID);
            ResultSet rs = stmt.executeQuery();
            
            if(rs.next()) {
                this.musicName = rs.getString("name");
                this.artistName = rs.getString("artist_name");
                this.rating = rs.getFloat("rating");
                this.sourceURL = rs.getString("source");
                this.coverURL = rs.getString("cover_link");
                this.language = rs.getString("music_language");
            }
        } catch (SQLException ex) {
            Logger.getLogger(Music.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    
    
    
    
    
    public String generateID(int num, String prefix) {
        String newID = prefix, numStr = String.valueOf(++num);
        for(int i = 0; i < 16 - numStr.length(); i++) {
            newID += "0";
        }
        newID += numStr;
        return newID;
    }
    
   
    public String generateMusicID() {
        try {
            PreparedStatement stmt = this.conn.prepareStatement("SELECT music_ID FROM music ORDER BY music_ID DESC LIMIT 1");
            ResultSet rs = stmt.executeQuery();
            
            if(rs.next()) {     
                this.musicID = this.generateID( Integer.valueOf(rs.getString("music_ID").substring(2)), "MU");
            } else {
                // 1st ID in the table
                this.musicID = this.generateID(0, "MU");
            }
            
            return this.musicID;
            
        } catch (SQLException ex) {
            Logger.getLogger(Music.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return null;
    }
    
    
    public boolean insertNewMusic() {
        if(this.musicID != null) {
            try {
                PreparedStatement stmt = this.conn.prepareStatement("INSERT INTO music(music_ID, name, artist_name, rating, source, cover_link, music_language) VALUES (?, ?, ?, ?, ?, ? ,?)");
                stmt.setString(1, this.musicID);
                stmt.setString(2, this.musicName);
                stmt.setString(3, this.artistName);
                stmt.setString(4, String.valueOf(this.rating));
                stmt.setString(5, this.sourceURL);
                stmt.setString(6, this.coverURL);
                stmt.setString(7, this.language);
                
                return stmt.executeUpdate() > 0;
            } catch (SQLException ex) {
                Logger.getLogger(Music.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        return false;
    }

    public Connection getConn() {
        return conn;
    }

    public void setConn(Connection conn) {
        this.conn = conn;
    }

    public String getMusicID() {
        return musicID;
    }

    public void setMusicID(String musicID) {
        this.musicID = musicID;
    }

    public String getMusicName() {
        return musicName;
    }

    public void setMusicName(String musicName) {
        this.musicName = musicName;
    }

    public String getArtistName() {
        return artistName;
    }

    public void setArtistName(String artistName) {
        this.artistName = artistName;
    }

    public float getRating() {
        return rating;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }

    public String getSourceURL() {
        return sourceURL;
    }

    public void setSourceURL(String sourceURL) {
        this.sourceURL = sourceURL;
    }

    public String getCoverURL() {
        return coverURL;
    }

    public void setCoverURL(String coverURL) {
        this.coverURL = coverURL;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }
    
    
    
    
}
