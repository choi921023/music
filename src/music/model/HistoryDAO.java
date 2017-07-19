package music.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;

import music.model.dto.HistoryDTO;
import music.model.util.DBUtil;

public class HistoryDAO {
	static ResourceBundle sql = DBUtil.getResourceBundle();

	// create history
	public static boolean createHistory(HistoryDTO history) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		int result = 0;
		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement("createHistory_sysdate");
			pstmt.setString(1, history.getEmail());
			pstmt.setString(2, history.getMusicAddress());
			result = pstmt.executeUpdate();

			if (result == 1) {
				return true;
			}
		} finally {
			DBUtil.close(con, pstmt);
		}
		return false;
	}

	// delete history
	public static boolean deleteHistory(String musicAddress, String startTime) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement("deleteHistory");
			pstmt.setString(1, musicAddress);
			pstmt.setString(2, startTime);
			int result = pstmt.executeUpdate();
			if (result == 1) {
				return true;
			}
		} finally {
			DBUtil.close(con, pstmt);
		}
		return false;
	}

	// get history
	public static ArrayList<HistoryDTO> getHistory(String email) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<HistoryDTO> list = null;
		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement("selectHistory");
			pstmt.setString(1, email);
			rset = pstmt.executeQuery();

			list = new ArrayList<HistoryDTO>();
			while (rset.next()) {
				list.add(new HistoryDTO(rset.getString(1), rset.getString(2), rset.getString(3)));
			}
		} finally {
			DBUtil.close(con, pstmt, rset);
		}
		return list;
	}
}
