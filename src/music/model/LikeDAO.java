package music.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;

import music.model.dto.LikeDTO;
import music.model.dto.MusicDTO;
import music.model.util.DBUtil;

public class LikeDAO {
	static ResourceBundle sql = DBUtil.getResourceBundle();

	//get Like
	public static ArrayList<LikeDTO> getLike(String mail) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<LikeDTO> likeList = null;
		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement(sql.getString("getLike"));
			pstmt.setString(1, mail);
			rset = pstmt.executeQuery();
			likeList = new ArrayList<LikeDTO>();
			while (rset.next()) {
				likeList.add(new LikeDTO(rset.getString(1), rset.getString(2)));
			}
		} finally {
			DBUtil.close(con, pstmt);
		}
		return likeList;
	}
	// create Like
	public static ArrayList createLike(LikeDTO like) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			if (pstmt("createLike", con, pstmt, like)) {
				if (pstmt("addBpm", con, pstmt, like) && pstmt("addGender", con, pstmt, like)
						&& pstmt("addGenre", con, pstmt, like) && pstmt("addMelody", con, pstmt, like)) {
					return sorting(con, pstmt);
				}
			}
		} finally {
			DBUtil.close(con, pstmt);
		}
		return null;
	}

	// delete like
	public static ArrayList deleteLike(LikeDTO like) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {

			if (pstmt("deleteLike", con, pstmt, like)) {
				if (pstmt("deleteBpm", con, pstmt, like) && pstmt("deleteGender", con, pstmt, like)
						&& pstmt("deleteGenre", con, pstmt, like) && pstmt("deleteMelody", con, pstmt, like)) {
					return sorting(con, pstmt);
				}
			}
		} finally {
			DBUtil.close(con, pstmt);
		}
		return null;
	}

	// pstmt 메서드로
	public static boolean pstmt(String query, Connection con, PreparedStatement pstmt, LikeDTO like)
			throws SQLException {
		boolean ret = false;
		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement(sql.getString(query));
			pstmt.setString(1, like.getEmail());
			pstmt.setString(2, like.getMusicAddress());
			int result = pstmt.executeUpdate();
			if (result == 1) {
				ret = true;
			}
		} finally {
			return ret;
		}
	}

	// sorting 메서드로
	public static ArrayList sorting(Connection con, PreparedStatement pstmt) throws SQLException {
		boolean ret = false;
		String stan1 = null;
		String stan2 = null;
		ResultSet rset = null;
		ArrayList list = null;
		int t = 0;
		try {
			con = DBUtil.getConnection();
			for (int i = 0; i < 4; i++) {
				switch (i) {
				case 0:
					stan1 = "genre";
					stan2 = "genreruleinfo";
					break;
				case 1:
					stan1 = "gender";
					stan2 = "genderruleinfo";
					break;
				case 2:
					stan1 = "melody";
					stan2 = "melodyruleinfo";
					break;
				case 3:
					stan1 = "bpm";
					stan2 = "bpmruleinfo";
					break;
				}
				pstmt = con.prepareStatement(sql.getString("sorting"));
				pstmt.setString(1, stan1);
				pstmt.setString(2, stan2);
				rset = pstmt.executeQuery();
				if (rset.next()) {
					t++;
					list.add(rset.getString(0));
				}

				if (t == 4) {
					return list;
				}
			}
		} finally {
			return null;
		}
	}
}