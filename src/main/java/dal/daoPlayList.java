package dal;

import be.PlayList;
import be.Song;
import javafx.collections.FXCollections;

import java.sql.*;
import java.util.List;

public class daoPlayList {
    private final static daoConnecter dc = new daoConnecter();

    public List<PlayList>getAllPalyList() {
        List<PlayList> ListOfPlayList = FXCollections.observableArrayList();
        try (Connection co = dc.getConnection()) {
            String sqlStatment = "SELECT * FROM ?"; //We don't have a table inside the server.
            Statement st = co.createStatement();
            if (st.execute(sqlStatment)) {
                ResultSet rs = st.getResultSet();
                while (rs.next()) {
                    int id = rs.getInt("id"); //name for column inside the table.
                    String playListName = rs.getString("playListName");
                    PlayList playList = new PlayList(id, playListName);
                    ListOfPlayList.add(playList);
                }
            }
        }
        catch (SQLException ex) {
            System.out.println(ex);
            return null;
        }
        return ListOfPlayList;
    }
    public Song addPlayList(int id, String playListName){
        //try (Connection co = dc.getConnection()){
            String sqlStatment = "UPDATE (?) set id = ?,  set playListName = ?;"; // We don't have a table inside the server. that's why we have question mark inside the method
            PreparedStatement ps = co.prepareStatement(sqlStatment);
            ps.setInt(1,id);
            ps.setString(3,playListName);

         //   return new Song(id, playListName);
        }
        catch (SQLException ex){
            System.out.println(ex);
            return null;
        }
    }
    public void removePlayList(Song thisSong){
         try (Connection co = dc.getConnection()){
            String sqlStatment = "DELETE FROM (?) WHERE id = ?";
            PreparedStatement ps = co.prepareStatement(sqlStatment);
            ps.setInt(1, thisSong.getId());
            ps.executeUpdate();
        }
        catch (SQLException ex){
            System.out.println(ex);
        }
    }
}