/*create table userinfo (
	user_id varchar2(30) primary key,
	user_name varchar2(10) not null,
	user_pw varchar2(20) not null
); 
 */

package music.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;
import music.model.dto.MemberDTO;
import music.model.util.DBUtil;

public class MemberDAO {
	
	static ResourceBundle sql = DBUtil.getResourceBundle();
	
	//create member
	public static boolean addMember(MemberDTO member) throws SQLException {
		System.out.println("MemberDAO");
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement(sql.getString("addMember"));
			pstmt.setString(1, member.getEmail());
			pstmt.setString(2, member.getName());
			pstmt.setString(3, member.getPw());

			int result = pstmt.executeUpdate();

			if (result == 1) {
				return true;
			}
		} finally {
			DBUtil.close(con, pstmt);
		}
		System.out.println("endMemberDAO");
		return false;
	}
	//update member
	public static boolean updateMember(String email, String name, String pw) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = DBUtil.getConnection();

			pstmt = con.prepareStatement(sql.getString("updateMember"));
			pstmt.setString(1, name);
			pstmt.setString(2, pw);
			pstmt.setString(3, email);

			int result = pstmt.executeUpdate();
			if (result == 1) {
				return true;
			}
		} finally {
			DBUtil.close(con, pstmt);
		}
		return false;
	}
	//delete member
	public static boolean deleteMember(String email) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement(sql.getString("deleteMember"));
			pstmt.setString(1, email);
			int result = pstmt.executeUpdate();
			if (result == 1) {
				return true;
			}
		} finally {
			DBUtil.close(con, pstmt);
		}
		return false;
	}

	//get member
	public static MemberDTO getMember(String email) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		MemberDTO member = null;

		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement(sql.getString("getMember"));
			pstmt.setString(1, email);
			rset = pstmt.executeQuery();
			if (rset.next()) {
				member = new MemberDTO(rset.getString(1), rset.getString(2), rset.getString(3));
			}
		} finally {
			DBUtil.close(con, pstmt, rset);
		}
		return member;
	}
	
	// getAll member
	public static ArrayList<MemberDTO> getAllMembers() throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<MemberDTO> memberList = null;
		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement(sql.getString("getAllMembers"));
			rset = pstmt.executeQuery();

			memberList = new ArrayList<MemberDTO>();
			while (rset.next()) {
				memberList.add(new MemberDTO(rset.getString(1), rset.getString(2), rset.getString(3)));
			}
		} finally {
			DBUtil.close(con, pstmt, rset);
		}
		return memberList;
	}
	

}
