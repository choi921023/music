

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;

import music.model.dto.MusicDTO;
import music.model.util.DBUtil;

public class StationDAO {
	static ResourceBundle sql = DBUtil.getResourceBundle();

	//createStation
	// INSERT INTO stationinfo values(email(?), musicAddress(?)) 
	public static boolean createStation(String email, String musicAddress) throws SQLException{
		Connection con = null;
		PreparedStatement pstmt = null;
		try{
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement("createStation");
			pstmt.setString(1, email);
			pstmt.setString(2, musicAddress);
	
			int result = pstmt.executeUpdate();
		
			if(result == 1){
				return true;
			}
		}finally{
			DBUtil.close(con, pstmt);
		}
		return false;
	}
	
	//deleteStation
	// DELETE FROM STATIONINFO WHERE user_id = email(?)
	public static boolean deleteStation(String email) throws SQLException{
		Connection con = null;
		PreparedStatement pstmt = null;
		try{
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement(sql.getString("deleteStation"));
			pstmt.setString(1, email);
			
			int result = pstmt.executeUpdate();
			if(result == 1){
				return true;
			}
		}finally{
			DBUtil.close(con, pstmt);
		}
		return false;
	}
	
	// getStation
	// SELECT (music_name, music_musadd, music_singer, music_genre, music_bpm, music_gender, music_melody) FROM musicinfo  where music_musadd IN (SELECT music_musadd FROM stationinfo WHERE user_id = (?))
	public static ArrayList<MusicDTO> getStation(String email) throws SQLException{
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<MusicDTO> list = null;
		try{
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement(sql.getString("getStation"));
			pstmt.setString(1, email);
			rset = pstmt.executeQuery();
			
			list = new ArrayList<MusicDTO>();
			while(rset.next()){
				list.add( new MusicDTO(rset.getString(1), rset.getString(2), rset.getString(3), rset.getString(4), rset.getString(5), rset.getString(6), rset.getString(7), rset.getString(8)) );
			}

		}finally{
			DBUtil.close(con, pstmt, rset);
		}
		return list;
	}
}
