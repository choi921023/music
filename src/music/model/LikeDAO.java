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
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class LikeDAO {
	static ResourceBundle sql = DBUtil.getResourceBundle();
	
	 public static boolean createLike2(LikeDTO like) throws SQLException {
	      Connection con = null;
	      PreparedStatement pstmt = null;
	      try {
	         con = DBUtil.getConnection();
	         pstmt = con.prepareStatement(sql.getString("createLike2"));
	         pstmt.setString(1, like.getEmail());
	         pstmt.setString(2, like.getMusicAddress());

	         int result = pstmt.executeUpdate();

	         if (result == 1) {
	            return true;
	         }
	      } finally {
	         DBUtil.close(con, pstmt);
	      }
	      return false;
	   }
	  //select count(distinct email) from likeinfo where user_id=? and music_musadd=?;
	   public static boolean getLikeInfo(String email, String musicAddress) throws SQLException {
	      boolean like = false;
	      Connection con = null;
	      PreparedStatement pstmt = null;
	      ResultSet rset = null;
	      try {
	         con = DBUtil.getConnection();
	         pstmt = con.prepareStatement(sql.getString("getLikeInfo"));
	         pstmt.setString(1, email);
	         pstmt.setString(2, musicAddress);
	         rset = pstmt.executeQuery();
	         if(rset.getInt(1) == 1) {
	            like = true;
	         }
	      } finally {
	         DBUtil.close(con, pstmt);
	      }
	      return like;
	   }
	   
	   //json객체 생성해주는 메소드
	   public static JSONObject setJson(ArrayList<MusicDTO> musicList, String email){
	      JSONObject jsonObject = new JSONObject(); // JSONObject 생성
	      JSONArray cell = new JSONArray(); // JSONObject list 를 넣을 JSONArray
	      
	      MusicDTO data = null; // 데이터를 꺼내올 BeanVO 객체 생성
	      try {
	         for(int i=0; i<musicList.size(); i++) { // 루프를 돌려 list에 담긴 데이터를 BeanVO에 주입
	            data = (MusicDTO)musicList.get(i); // 이제 data 에는 객체들이 차례로 담겼음
	            JSONObject obj = new JSONObject(); // 다시 한번 JSONObject로 감싸기 위해 객체 선언
	            obj.put( "musicAddress" , data.getMusicAddress()); 
	            obj.put( "musicTitle" , data.getMusicTitle());
	            obj.put( "artist" , data.getArtist());
	            obj.put( "albumAddress" , data.getAlbumAddress());
	      
	            obj.put("likeInfo", LikeDAO.getLikeInfo(email, data.getMusicAddress()));
	            
	            cell.add(obj); // 아까 만들어진 cell Array객체에 VO담은 객체를 주입
	         }
	      } catch (SQLException e) {
	         e.printStackTrace();
	      }
	      jsonObject.put("DemoMusic", cell); // 마지막으로 JSON객체에 JSONArray 객체를 넣으면 끝!
	      return jsonObject;
	   }
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
	            likeList.add(new LikeDTO(mail, rset.getString(1)));
	         }
	      } finally {
	         DBUtil.close(con, pstmt, rset);
	      }
	      return likeList;
	   }
	// create Like
	public static MusicDTO createLike(LikeDTO like) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			if (pstmt("createLike", con, pstmt, like)) {
				System.out.println("dao1end");
				if (pstmt("addBpm", con, pstmt, like) && pstmt("addGender", con, pstmt, like)
						&& pstmt("addGenre", con, pstmt, like) && pstmt("addMelody", con, pstmt, like)) {
					System.out.println("dao2end");
					return exportMusic(con, pstmt, sorting(con, pstmt));
				}
			}
		} finally {
			DBUtil.close(con, pstmt);
		}
		return null;
	}

	// delete like
	public static MusicDTO deleteLike(LikeDTO like) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {

			if (pstmt("deleteLike", con, pstmt, like)) {
				if (pstmt("deleteBpm", con, pstmt, like) && pstmt("deleteGender", con, pstmt, like)
						&& pstmt("deleteGenre", con, pstmt, like) && pstmt("deleteMelody", con, pstmt, like)) {
					return exportMusic(con, pstmt, sorting(con, pstmt));
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


	public static MusicDTO exportMusic(Connection con, PreparedStatement pstmt, ArrayList list) throws SQLException {
		ResultSet rset = null;
		ArrayList<MusicDTO> musicList = null;
		try{
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement(sql.getString("exportMusic"));
			pstmt.setString(1, (String)list.get(0));
			pstmt.setString(2, (String)list.get(1));
			pstmt.setString(3, (String)list.get(2));
			pstmt.setString(4, (String)list.get(3));
			rset = pstmt.executeQuery();
			while (rset.next()) {
				musicList.add(new MusicDTO(rset.getString(1), rset.getString(2), rset.getString(3), rset.getString(4), rset.getString(5), rset.getString(6), rset.getString(7), rset.getString(8)));
			}
			if(musicList.size() != 0){
				int i = (int) Math.floor(Math.random() * (musicList.lastIndexOf(musicList) + 1));
				return musicList.get(i);
			}else{
				pstmt = con.prepareStatement(sql.getString("exportMusic2"));
				pstmt.setString(1, (String)list.get(0));
				pstmt.setString(2, (String)list.get(1));
				pstmt.setString(3, (String)list.get(2));
				pstmt.setString(4, (String)list.get(3));
				rset = pstmt.executeQuery();
				while (rset.next()) {
					musicList.add(new MusicDTO(rset.getString(1), rset.getString(2), rset.getString(3), rset.getString(4), rset.getString(5), rset.getString(6), rset.getString(7), rset.getString(8)));
				}
				if(musicList.size() != 0){
					int i = (int) Math.floor(Math.random() * (musicList.lastIndexOf(musicList) + 1));
					return musicList.get(i);
				}else{
					pstmt = con.prepareStatement(sql.getString("exportMusic3"));
					pstmt.setString(1, (String)list.get(0));
					rset = pstmt.executeQuery();
					while (rset.next()) {
						musicList.add(new MusicDTO(rset.getString(1), rset.getString(2), rset.getString(3), rset.getString(4), rset.getString(5), rset.getString(6), rset.getString(7), rset.getString(8)));
						int i = (int) Math.floor(Math.random() * (musicList.lastIndexOf(musicList) + 1));
						return musicList.get(i);
					}
				}
			}
		}finally{
			DBUtil.close(con, pstmt);			
		}
		return null;
	}
}