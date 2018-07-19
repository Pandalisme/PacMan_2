/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pacman_2;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import static pacman_2.Main.lblHighScore;

/**
 *
 * @author User
 */
public class DataAkses {
    
    public static void addScore(Player pl){
        String query = "insert into tbl_score values (?,?)";
        try{
            PreparedStatement st = Connector.getConnection().prepareStatement(query);
            st.setString(1, "XXX");
            st.setInt(2,pl.getPoints());
            st.execute();
        }
        catch(SQLException e){
            e.printStackTrace();
        }
    }
    
    public static void showHighscore(){
        String query = "select MAX(score) from tbl_score";
        try{
            PreparedStatement st = Connector.getConnection().prepareStatement(query);
            System.out.println(st);
            ResultSet rs = st.executeQuery();
            while(rs.next()){
                lblHighScore.setText(String.valueOf(rs.getInt(1)));
            }
        }
        catch(SQLException e){
            e.printStackTrace();
        }
    }
}
