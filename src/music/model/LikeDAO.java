package music.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import music.model.dto.LikeDTO;
import music.model.util.DBUtil;

public class LikeDAO {

	// pstmt 메서드로
	public static boolean psmt(String sql, Connection con, PreparedStatement pstmt, LikeDTO like) throws SQLException {
		boolean ret = false;
		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement(sql);
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

	// create Like
	public static boolean createLike(LikeDTO like) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {

			if (psmt("createLike", con, pstmt, like)) {
				if (psmt("addBpm", con, pstmt, like) && psmt("addGender", con, pstmt, like)
						&& psmt("addGenre", con, pstmt, like) && psmt("addMelody", con, pstmt, like)) {
					if (sorting()) {
						return true;
					}
				}
			}
		} finally {
			DBUtil.close(con, pstmt);
		}
		return false;
	}

	// delete like
	public static boolean deleteLike(LikeDTO like) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {

			if (psmt("deleteLike", con, pstmt, like)) {
				if (psmt("deleteBpm", con, pstmt, like) && psmt("deleteGender", con, pstmt, like)
						&& psmt("deleteGenre", con, pstmt, like) && psmt("deleteMelody", con, pstmt, like)) {
					if (sorting()) {
						return true;
					}
				}
			}
		} finally {
			DBUtil.close(con, pstmt);
		}
		return false;
	}

	public static boolean sorting() throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		String stan1 = null;
		String stan2 = null;
		int t = 0;
		try {
			con = DBUtil.getConnection();
			for (int i = 0; i < 4; i++) {
				switch (i) {
				case 0:
					stan1 = "gender";
					stan2 = "genderruleinfo";
					break;
				case 1:
					stan1 = "gender";
					stan2 = "genderruleinfo";
					break;
				case 2:
					stan1 = "gender";
					stan2 = "genderruleinfo";
					break;
				case 3:
					stan1 = "gender";
					stan2 = "genderruleinfo";
					break;
				}
				pstmt = con.prepareStatement("sorting");
				pstmt.setString(1, stan1);
				pstmt.setString(2, stan2);
				int result = pstmt.executeUpdate();
				if (result == 1) {
					t++;
				}
				if (t == 4) {
					return true;
				}
			}
		} finally {
			DBUtil.close(con, pstmt);
		}
		return false;
	}
}