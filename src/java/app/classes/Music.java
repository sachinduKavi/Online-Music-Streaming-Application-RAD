/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.classes;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Sachindu Kavishka
 */
public class Music {
    static Connection conn = DbConnection.getConnection();
    
    private String musicID;
    private String musicName;
    private String artistName;
    private float rating;
    private String sourceURL;
    private String coverURL;
    private String language;
    private boolean favPlaylist;

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

    public Music(String musicID, String musicName, String artistName, float rating, String coverURL, String language) {
        this.musicID = musicID;
        this.musicName = musicName;
        this.artistName = artistName;
        this.rating = rating;
        this.coverURL = coverURL;
        this.language = language;
    }
    
    

    public Music() {
    }

    public Music(String musicID) {
        this.musicID = musicID;
    }
    
    public boolean favCheck(String userID) {
        try {
            PreparedStatement stmt = conn.prepareStatement("SELECT * FROM play_list WHERE music_ID = ? AND user_ID = ?");
            stmt.setString(1, this.musicID);
            stmt.setString(2, userID);
            
            ResultSet rs = stmt.executeQuery();
            if(rs.next()) {
                return true;
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(Music.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return false;
    }
    
    
    public void fetchValuesFromDatabase() {
        try {
            PreparedStatement stmt = conn.prepareStatement("SELECT * FROM music WHERE music_ID = ?");
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
    
    
    // Fetch all favourite music 
    public static List<Music> fetchFavouriteMusic(String userID) {
        List<Music> musicList = new ArrayList<>();
        
        try {
            PreparedStatement stmt = conn.prepareStatement("SELECT music.music_ID, name, artist_name, rating, cover_link, music_language FROM MUSIC JOIN play_list ON music.music_ID = play_list.music_ID WHERE user_ID = ?");
            stmt.setString(1, userID);
            ResultSet rs = stmt.executeQuery();
            
            while(rs.next()) {
                musicList.add(new Music(
                  rs.getString("music_ID"),
                  rs.getString("name"),
                  rs.getString("artist_name"),
                  rs.getFloat("rating"),
                  rs.getString("cover_link"),
                  rs.getString("music_language")
                ));
            }
        } catch (SQLException ex) {
            Logger.getLogger(Music.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return musicList;
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
            PreparedStatement stmt = conn.prepareStatement("SELECT music_ID FROM music ORDER BY music_ID DESC LIMIT 1");
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
                PreparedStatement stmt = conn.prepareStatement("INSERT INTO music(music_ID, name, artist_name, rating, source, cover_link, music_language) VALUES (?, ?, ?, ?, ?, ? ,?)");
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
    
    public String getPreviousRecord() {
        int idNum = Integer.valueOf(this.musicID.substring(2));
        try {
            PreparedStatement stmt = conn.prepareStatement("SELECT music_ID FROM music WHERE CAST(substr(music_ID, 3) AS INT) < ? ORDER BY music_ID DESC LIMIT 1");
            stmt.setInt(1, idNum);
            ResultSet rs = stmt.executeQuery();
            
            if(rs.next()) {
                System.out.println("Music ID" + rs.getString("music_ID"));
                return rs.getString("music_ID");
            } else {
                System.out.println("Empty");
            }
        } catch (SQLException ex) {
            Logger.getLogger(Music.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        PreparedStatement stmt2;
        try {
            stmt2 = conn.prepareStatement("SELECT music_ID FROM music ORDER BY music_ID DESC LIMIT 1");
            ResultSet rs2 = stmt2.executeQuery();
            if(rs2.next())
                return rs2.getString("music_ID");
        } catch (SQLException ex) {
            Logger.getLogger(Music.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return "MU0000000000000001";
        
    }
    
    
    public String getNextRecord() {
        int idNum = Integer.valueOf(this.musicID.substring(2));
        System.out.println("MY TEsting " + idNum);
        try {
            PreparedStatement stmt = conn.prepareStatement("SELECT music_ID FROM music WHERE CAST(substr(music_ID, 3) AS INT) > ? ORDER BY music_ID ASC LIMIT 1");
            stmt.setInt(1, idNum);
            ResultSet rs = stmt.executeQuery();
            
            if(rs.next()) {
                System.out.println("Music ID" + rs.getString("music_ID"));
                return rs.getString("music_ID");
            } else {
                System.out.println("Empty");
            }
        } catch (SQLException ex) {
            Logger.getLogger(Music.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        return "MU0000000000000001";
    }
    
    // Gettters & setters

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
