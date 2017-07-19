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
			throw new NotExistException("�˻��Ͻ� ��ɱ�� ������ �����ϴ�.");
		}
	}

	public static boolean addMember(MemberDTO member) throws Exception {
		boolean result = false;
		try {
			result = MemberDAO.addMember(member);
		} catch (SQLException s) {
			throw new Exception("�̹� �����ϴ� ID�Դϴ� �ٽ� �õ� �ϼ���");
		}
		return result;
	}

	public static boolean updateMember(String email, String name, String pw) throws Exception {
		notExistMember(email);
		boolean result = MemberDAO.updateMember(email, name, pw);
		if (!result) {
			throw new NotExistException("ȸ�� ���� ���� ����");
		}
		return result;
	}

	public static boolean deleteMember(String email) throws SQLException, NotExistException {
		notExistMember(email);
		boolean result = MemberDAO.deleteMember(email);
		if (!result) {
			throw new NotExistException("ȸ�� ���� ���� ����");
		}
		return result;
	}

	public static MemberDTO getMember(String email) throws SQLException, NotExistException {
		MemberDTO member = MemberDAO.getMember(email);
		if (member == null) {
			throw new NotExistException("�˻��ϴ� ȸ���� �� �����մϴ�.");
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
			throw new NotExistException("�˻��Ͻ� ������ �����ϴ�.");
		}
	}

	public static boolean addMusic(MusicDTO music) throws Exception {
		boolean result = false;
		try {
			result = MusicDAO.addMusic(music);
		} catch (SQLException s) {
			throw new Exception("�̹� �����ϴ� �����Դϴ� .");
		}
		return result;
	}

	public static boolean deleteMusic(String musicAddress) throws SQLException, NotExistException {
		notExistMember(musicAddress);
		boolean result = MusicDAO.deleteMusic(musicAddress);
		if (!result) {
			throw new NotExistException("���� ���� ���� ����");
		}
		return result;
	}

	public static MusicDTO getMusic(String musicAddress) throws SQLException, NotExistException {
		MusicDTO music = MusicDAO.getMusic(musicAddress);
		if (music == null) {
			throw new NotExistException("�˻��ϴ� ������ �� �����մϴ�.");
		}
		return music;
	}

	public static ArrayList<MusicDTO> getMusicsByTitle(String musicTitle) throws Exception {
		ArrayList<MusicDTO> musicList = MusicDAO.getMusicsByTitle(musicTitle);
		if (musicList == null) {
			throw new NotExistException("�˻��ϴ� ������ �� �����մϴ�.");
		}
		return musicList;
	}

	public static ArrayList<MusicDTO> getMusicsBySinger(String artist) throws Exception {
		ArrayList<MusicDTO> musicList = MusicDAO.getMusicsBySinger(artist);
		if (musicList == null) {
			throw new NotExistException("�˻��ϴ� ������ �� �����մϴ�.");
		}
		return musicList;
	}

	// Like - CRUD
	// Like ����
	public static ArrayList createLike(LikeDTO like) throws SQLException, NotExistException {
		ArrayList result = LikeDAO.createLike(like);
		if (result == null) {
			throw new NotExistException("Like create failed!");
		}
		return result;
	}

	// Like ����
	public static ArrayList deleteLike(LikeDTO like) throws SQLException, NotExistException {
		ArrayList result = LikeDAO.deleteLike(like);
		if (result == null) {
			throw new NotExistException("Like cancel failed!");
		}
		return result;
	}

	// History - CRUD
	// History ����
	public static boolean createHistory(HistoryDTO history) throws Exception {
		boolean result = false;
		try {
			result = HistoryDAO.createHistory(history);
		} catch (SQLException s) {
			throw new Exception("History create failed!");
		}
		return result;
	}

	// History ����
	public static boolean deleteHistory(HistoryDTO history) throws SQLException, NotExistException {
		boolean result = HistoryDAO.deleteHistory(history.getMusicAddress(), history.getStartTime());
		if (!result) {
			throw new NotExistException("��� ����� ���� ���� ����");
		}
		return result;
	}

	// �Ѹ��� History ���
	public static ArrayList<HistoryDTO> getHistory(String email) throws SQLException, NotExistException {
		ArrayList<HistoryDTO> history = HistoryDAO.getHistory(email);
		if (history == null) {
			throw new NotExistException("�ش� ID�� history�� �������� �ʽ��ϴ�.");
		}
		return history;
	}
	// Station - CRUD

	// - createStation: ���ο� station(ȸ��+��õ�뷡) ���� �߰�
	// ȸ���� ��õ�� �뷡 ������ �����, ȸ�� ���� ���̵�(email)�� �ش� ������(musicAddress)�� �ҷ��ͼ� db��
	// stationInfo���̺� �߰�
	public static boolean createStation(String email, String musicAddress) throws SQLException {
		return StationDAO.createStation(email, musicAddress);
	}

	// - deleteStation: ���� �����̼� ����
	// �ش� ȸ���� ���� �˻��Ͽ� ��õ�� �뷡 (�����̼ǿ� ���Ե� �뷡)�� ����
	public static boolean deleteStation(String email) throws SQLException {
		return StationDAO.deleteStation(email);
	}

	// - getStation: �ش� ȸ���� ������ �����̼� �뷡 ����� ��ȯ
	// �ش� ȸ�� ������ �˻��Ͽ� staionInfo���̺� �˻� ��, �ش� �� �ּҸ� �������� musicInfo ���̺�� �����Ͽ� ����
	// ��� �� ���� ��ȯ
	public static ArrayList<MusicDTO> getStation(String email) throws NotExistException, SQLException {
		 ArrayList<MusicDTO> list = StationDAO.getStation(email);
		if (list == null) {
			throw new NotExistException("���� �����̼��� �������� �ʽ��ϴ�. ��ȣ�ϴ� �뷡�� �������ּ���.");
		}
		return list;
	}
}