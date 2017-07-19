package music.model;

import java.sql.SQLException;
import java.util.ArrayList;

import music.exception.NotExistException;
import music.model.dto.HistoryDTO;
import music.model.dto.LikeDTO;
import music.model.dto.MemberDTO;
import music.model.dto.MusicDTO;

public class MusicService {

	// member CRUD
	public static void notExistMember(String email) throws NotExistException, SQLException {
		MemberDTO member = MemberDAO.getMember(email);
		if (member == null) {
			throw new NotExistException("검색하신 재능기부 정보가 없습니다.");
		}
	}

	public static boolean addMember(MemberDTO member) throws Exception {
		boolean result = false;
		try {
			result = MemberDAO.addMember(member);
		} catch (SQLException s) {
			throw new Exception("이미 존재하는 ID입니다 다시 시도 하세요");
		}
		return result;
	}

	public static boolean updateMember(String email, String name, String pw) throws Exception {
		notExistMember(email);
		boolean result = MemberDAO.updateMember(email, name, pw);
		if (!result) {
			throw new NotExistException("회원 정보 수정 실패");
		}
		return result;
	}

	public static boolean deleteMember(String email) throws SQLException, NotExistException {
		notExistMember(email);
		boolean result = MemberDAO.deleteMember(email);
		if (!result) {
			throw new NotExistException("회원 정보 삭제 실패");
		}
		return result;
	}

	public static MemberDTO getMember(String email) throws SQLException, NotExistException {
		MemberDTO member = MemberDAO.getMember(email);
		if (member == null) {
			throw new NotExistException("검색하는 회원이 미 존재합니다.");
		}
		return member;
	}

	public static ArrayList<MemberDTO> getAllMembers() throws Exception {
		return MemberDAO.getAllMembers();
	}
	// music CRUD

	public static void notExistMusic(String musicAddress) throws NotExistException, SQLException {
		MusicDTO music = MusicDAO.getMusic(musicAddress);
		if (music == null) {
			throw new NotExistException("검색하신 음악이 없습니다.");
		}
	}

	public static boolean addMusic(MusicDTO music) throws Exception {
		boolean result = false;
		try {
			result = MusicDAO.addMusic(music);
		} catch (SQLException s) {
			throw new Exception("이미 존재하는 음악입니다 .");
		}
		return result;
	}

	public static boolean deleteMusic(String musicAddress) throws SQLException, NotExistException {
		notExistMember(musicAddress);
		boolean result = MusicDAO.deleteMusic(musicAddress);
		if (!result) {
			throw new NotExistException("음악 정보 삭제 실패");
		}
		return result;
	}

	public static MusicDTO getMusic(String musicAddress) throws SQLException, NotExistException {
		MusicDTO music = MusicDAO.getMusic(musicAddress);
		if (music == null) {
			throw new NotExistException("검색하는 음악이 미 존재합니다.");
		}
		return music;
	}

	public static ArrayList<MusicDTO> getMusicsByTitle(String musicTitle) throws Exception {
		ArrayList<MusicDTO> musicList = MusicDAO.getMusicsByTitle(musicTitle);
		if (musicList == null) {
			throw new NotExistException("검색하는 음악이 미 존재합니다.");
		}
		return musicList;
	}

	public static ArrayList<MusicDTO> getMusicsBySinger(String artist) throws Exception {
		ArrayList<MusicDTO> musicList = MusicDAO.getMusicsBySinger(artist);
		if (musicList == null) {
			throw new NotExistException("검색하는 음악이 미 존재합니다.");
		}
		return musicList;
	}

	// Like - CRUD
	// Like 생성
	public static ArrayList createLike(LikeDTO like) throws SQLException, NotExistException {
		ArrayList result = LikeDAO.createLike(like);
		if (result == null) {
			throw new NotExistException("Like create failed!");
		}
		return result;
	}

	// Like 제거
	public static ArrayList deleteLike(LikeDTO like) throws SQLException, NotExistException {
		ArrayList result = LikeDAO.deleteLike(like);
		if (result == null) {
			throw new NotExistException("Like cancel failed!");
		}
		return result;
	}

	// History - CRUD
	// History 생성
	public static boolean createHistory(HistoryDTO history) throws Exception {
		boolean result = false;
		try {
			result = HistoryDAO.createHistory(history);
		} catch (SQLException s) {
			throw new Exception("History create failed!");
		}
		return result;
	}

	// History 제거
	public static boolean deleteHistory(HistoryDTO history) throws SQLException, NotExistException {
		boolean result = HistoryDAO.deleteHistory(history.getMusicAddress(), history.getStartTime());
		if (!result) {
			throw new NotExistException("재능 기부자 정보 삭제 실패");
		}
		return result;
	}

	// 한명의 History 출력
	public static ArrayList<HistoryDTO> getHistory(String email) throws SQLException, NotExistException {
		ArrayList<HistoryDTO> history = HistoryDAO.getHistory(email);
		if (history == null) {
			throw new NotExistException("해당 ID의 history가 존재하지 않습니다.");
		}
		return history;
	}
	// Station - CRUD

	// - createStation: 새로운 station(회원+추천노래) 관계 추가
	// 회원과 추천할 노래 정보가 생기면, 회원 현재 아이디(email)와 해당 음악의(musicAddress)를 불러와서 db상
	// stationInfo테이블에 추가
	public static boolean createStation(String email, String musicAddress) throws SQLException {
		return StationDAO.createStation(email, musicAddress);
	}

	// - deleteStation: 기존 스테이션 삭제
	// 해당 회원의 정보 검색하여 추천할 노래 (스테이션에 포함된 노래)들 삭제
	public static boolean deleteStation(String email) throws SQLException {
		return StationDAO.deleteStation(email);
	}

	// - getStation: 해당 회원과 연관된 스테이션 노래 목록을 반환
	// 해당 회원 정보를 검색하여 staionInfo테이블 검색 후, 해당 곡 주소를 바탕으로 musicInfo 테이블과 조인하여 나온
	// 모든 곡 정보 반환
	public static ArrayList<MusicDTO> getStation(String email) throws NotExistException, SQLException {
		 ArrayList<MusicDTO> list = StationDAO.getStation(email);
		if (list == null) {
			throw new NotExistException("현재 스테이션이 존재하지 않습니다. 선호하는 노래를 선택해주세요.");
		}
		return list;
	}
}