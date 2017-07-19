/*create table musicinfo (
   music_musadd varchar2(50) primary key,
   music_name varchar2(50) not null,
   music_singer varchar2(50) not null,
   music_genre varchar2(20) not null ,
   music_bpm number not null,
   music_gender varchar2(10) not null,
   music_melody varchar2(5) not null,
);
 */

package music.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;

import music.model.dto.MusicDTO;
import music.model.util.DBUtil;

public class MusicDAO {
	static ResourceBundle sql = DBUtil.getResourceBundle();
	//create music
	public static boolean addMusic(MusicDTO music) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement(sql.getString("addMusic"));
			pstmt.setString(1, music.getMusicAddress());
			pstmt.setString(2, music.getMusicTitle());
			pstmt.setString(3, music.getArtist());
			pstmt.setString(4, music.getGenre());
			pstmt.setString(5, music.getBpm());
			pstmt.setString(6, music.getGender());
			pstmt.setString(7, music.getMelody());

			int result = pstmt.executeUpdate();

			if (result == 1) {
				return true;
			}
		} finally {
			DBUtil.close(con, pstmt);
		}
		return false;
	}
	
	//delete music
	public static boolean deleteMusic(String musicAddress) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement(sql.getString("deleteMusic"));
			pstmt.setString(1, musicAddress);
			int result = pstmt.executeUpdate();
			if (result == 1) {
				return true;
			}
		} finally {
			DBUtil.close(con, pstmt);
		}
		return false;
	}
	
	//get music - music address�� ��Ī�Ǵ� music
	public static MusicDTO getMusic(String musicAddress) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		MusicDTO music = null;

		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement(sql.getString("getMusic"));
			pstmt.setString(1, musicAddress);
			rset = pstmt.executeQuery();
			if (rset.next()) {
				music = new MusicDTO(rset.getString(1), rset.getString(2), rset.getString(3), rset.getString(4), rset.getString(5), rset.getString(6), rset.getString(7));
			}
		} finally {
			DBUtil.close(con, pstmt, rset);
		}
		return music;
	}
	// get music - music address�� ��Ī�Ǵ� music
	public static ArrayList<MusicDTO> getMusicsByTitle(String musicTitle) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<MusicDTO> musicList = null;
		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement(sql.getString("getMusicsByTitle"));
			pstmt.setString(1, "%"+musicTitle+"%");
			rset = pstmt.executeQuery();

			musicList = new ArrayList<MusicDTO>();
			while (rset.next()) {
				musicList.add(new MusicDTO(rset.getString(1), rset.getString(2), rset.getString(3), rset.getString(4), rset.getString(5), rset.getString(6), rset.getString(7)));
			}
		} finally {
			DBUtil.close(con, pstmt, rset);
		}
		return musicList;
	}
	
	public static ArrayList<MusicDTO> getMusicsBySinger(String artist) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<MusicDTO> musicList = null;
		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement(sql.getString("getMusicsBySinger"));
			pstmt.setString(1, "%"+artist+"%");
			rset = pstmt.executeQuery();

			musicList = new ArrayList<MusicDTO>();
			while (rset.next()) {
				musicList.add(new MusicDTO(rset.getString(1), rset.getString(2), rset.getString(3), rset.getString(4), rset.getString(5), rset.getString(6), rset.getString(7)));
			}
		} finally {
			DBUtil.close(con, pstmt, rset);
		}
		return musicList;
	}
}
