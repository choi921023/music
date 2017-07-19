package music.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import music.model.dto.LikeDTO;
import music.model.util.DBUtil;

public class LikeDAO2 {

	// create Like
	public static boolean createLike(LikeDTO like) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		PreparedStatement pstmt1 = null;
		PreparedStatement pstmt2 = null;
		PreparedStatement pstmt3 = null;
		PreparedStatement pstmt4 = null;
		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement("createLike");
			pstmt.setString(1, like.getEmail());
			pstmt.setString(2, like.getMusicAddress());

			int result = pstmt.executeUpdate();

			if (result == 1) {
				pstmt1 = con.prepareStatement("addBpm");
				pstmt1.setString(1, like.getEmail());
				pstmt1.setString(2, like.getMusicAddress());
				int result1 = pstmt1.executeUpdate();
				if (result1 == 1) {
					pstmt2 = con.prepareStatement("addGender");
					pstmt2.setString(1, like.getEmail());
					pstmt2.setString(2, like.getMusicAddress());
					int result2 = pstmt2.executeUpdate();
					if (result2 == 1) {
						pstmt3 = con.prepareStatement("addGenre");
						pstmt3.setString(1, like.getEmail());
						pstmt3.setString(2, like.getMusicAddress());
						int result3 = pstmt3.executeUpdate();
						if (result3 == 1) {
							pstmt4 = con.prepareStatement("addMelody");
							pstmt4.setString(1, like.getEmail());
							pstmt4.setString(2, like.getMusicAddress());
							int result4 = pstmt4.executeUpdate();
							if (result4 == 1) {
								if (sorting()) {
									return true;
								}
							}
						}
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
		PreparedStatement pstmt1 = null;
		PreparedStatement pstmt2 = null;
		PreparedStatement pstmt3 = null;
		PreparedStatement pstmt4 = null;
		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement("deleteLike");
			pstmt.setString(2, like.getEmail());
			pstmt.setString(2, like.getMusicAddress());
			int result = pstmt.executeUpdate();
			if (result == 1) {
				pstmt1 = con.prepareStatement("deleteBpm");
				pstmt1.setString(1, like.getEmail());
				pstmt1.setString(2, like.getMusicAddress());
				int result1 = pstmt1.executeUpdate();
				if (result1 == 1) {
					pstmt2 = con.prepareStatement("deleteGender");
					pstmt2.setString(1, like.getEmail());
					pstmt2.setString(2, like.getMusicAddress());
					int result2 = pstmt2.executeUpdate();
					if (result2 == 1) {
						pstmt3 = con.prepareStatement("deleteGenre");
						pstmt3.setString(1, like.getEmail());
						pstmt3.setString(2, like.getMusicAddress());
						int result3 = pstmt3.executeUpdate();
						if (result3 == 1) {
							pstmt4 = con.prepareStatement("deleteMelody");
							pstmt4.setString(1, like.getEmail());
							pstmt4.setString(2, like.getMusicAddress());
							int result4 = pstmt4.executeUpdate();
							if (result4 == 1) {
								if (sorting()) {
									return true;
								}
							}
						}
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