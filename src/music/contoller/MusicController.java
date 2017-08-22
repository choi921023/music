package music.contoller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import music.demo.DemoMusicDTO;
import music.exception.NotExistException;
import music.model.LikeDAO;
import music.model.MusicService;
import music.model.dto.LikeDTO;
import music.model.dto.MemberDTO;
import music.model.dto.MusicDTO;

@WebServlet("/mc")
public class MusicController extends HttpServlet {

	public MusicController() {
		super();
	}

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("euc-kr");
		String command = request.getParameter("command");

		try {
			if (command.equals("getMember")) {// 회원 정보 검색
				getMember(request, response);
			} /*
				 * else if(command.equals("getMusic")){//음악 정보 검색 - musicaddress
				 * getMusic(request, response); }else
				 * if(command.equals("getMusicsByTitle")){//음악 정보 검색 - title
				 * getMusicsByTitle(request, response); }else
				 * if(command.equals("getMusicsBySinger")){//음악 정보 검색 - singer
				 * getMusicsBySinger(request, response); }
				 */else if (command.equals("addMember")) {// 회원 가입
				addMember(request, response);
			} /*
				 * else if(command.equals("updateMemberReq")){//회원 정보 수정 요청?
				 * updateMemberReq(request, response); }else
				 * if(command.equals("deleteMember")){//재능 기부자 탈퇴[삭제]
				 * deleteMember(request, response); }else
				 * if(command.equals("addMusic")){//노래 추가 - 관리자?
				 * addMusic(request, response); }
				 */else if (command.equals("getMusicListSelect")) {
				getMusicListSelect(request, response);
			} else if (command.equals("createLike")) {// like 한 곡 추가
				createLike(request, response);
			} else if (command.equals("deleteLike")) {// like 한 곡 like 취소
				deleteLike(request, response);
			} else if (command.equals("musicRecommand")) {// station 정보 가져오기
				musicRecommand(request, response);
			}/* else if (command.equals("musicRecommand2")) {// station 정보 가져오기
				musicRecommand2(request, response);
			}*/
			/*
			 * else if(command.equals("createHistory")){//들은 노래 이력 추가
			 * createHistory(request, response); }else
			 * if(command.equals("deleteHistory")){//노래 이력 삭제(협의 필요) - 전체
			 * history 삭제?? deleteHistory(request, response); }else
			 * if(command.equals("getHistory")){// 노래 이력 검색 getHistory(request,
			 * response); }else if(command.equals("createStation")){// station에
			 * like한 노래 목록 추가(협의 필요) - 미결정 getHistory(request, response); }else
			 * if(command.equals("deleteStation")){// station에서 like한 노래 삭제(협의
			 * 필요) - 미결정 getHistory(request, response); }else
			 * if(command.equals("getStation")){// station 정보 가져오기
			 * getHistory(request, response);
			 * 
			 */} catch (Exception s) {
			request.setAttribute("errorMsg", s.getMessage());
			request.getRequestDispatcher("showError.jsp").forward(request, response);
			s.printStackTrace();
		}
	}

	protected void addMember(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String url = "register.jsp";
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		String pw = request.getParameter("password");
		MemberDTO member = new MemberDTO(id, name, pw);
		System.out.println(member);
		try {
			boolean result = MusicService.addMember(member);
			System.out.println("yes");
			if (result) {
				HttpSession session = request.getSession();
				session.setAttribute("id", id);
				session.setAttribute("name", name);
				session.setAttribute("pw", pw);
				url = "checkbox.jsp";
			} else {
				request.setAttribute("errorMsg", "already");
			}
		} catch (Exception s) {
			request.setAttribute("errorMsg", s.getMessage());
		}
		request.getRequestDispatcher(url).forward(request, response);
	}

	public void getMember(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String url = "login.jsp";
		MemberDTO member = null;
		HttpSession session = request.getSession();
		ArrayList<LikeDTO> likeList = null;
		ArrayList<MusicDTO> musicList = null;
		try {
			member = MusicService.getMember(request.getParameter("email"));
			if (member == null) {
				request.setAttribute("auth", "loginfail");
			} else {
				if (member.getPw().equals(request.getParameter("password"))) {
					session.setAttribute("member", member);
					String email = member.getEmail();
					likeList = new ArrayList<LikeDTO>();
					likeList = MusicService.getLike(email);

					if (likeList.size() == 0) {
						url = "checkbox.jsp";
					} else {
						musicList = new ArrayList<MusicDTO>();
						musicList = MusicService.getRandomMusicList();
						MusicDTO music1 = musicList.get(0);
						MusicDTO music2 = musicList.get(0);
						request.setAttribute("music1", new DemoMusicDTO(music1.getMusicAddress(),
								music1.getMusicTitle(), music1.getArtist(), music1.getAlbumAddress()));
						request.setAttribute("music2", new DemoMusicDTO(music2.getMusicAddress(),
								music2.getMusicTitle(), music2.getArtist(), music2.getAlbumAddress()));
						url = "playerDemo.jsp";
					}
				} else {
					request.setAttribute("auth", "loginfail");
				}
			}

		} catch (Exception s) {
			request.setAttribute("errorMsg", s.getMessage());
		}
		request.getRequestDispatcher(url).forward(request, response);
	}

	public void musicRecommand(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ArrayList<MusicDTO> musicList = null;
		try {
			musicList = new ArrayList<MusicDTO>();
			HttpSession session = request.getSession();
			String[] genreList = request.getParameterValues("genreList");
			musicList = MusicService.getMusicListSelect(genreList);
			MusicDTO music1 = MusicService.createLike(new LikeDTO(
					((MemberDTO) session.getAttribute("member")).getEmail(), musicList.get(0).getMusicAddress()));
			request.setAttribute("music1", new DemoMusicDTO(music1.getMusicAddress(), music1.getMusicTitle(),
					music1.getArtist(), music1.getAlbumAddress()));
			MusicDTO music2 = MusicService.createLike(new LikeDTO(
					((MemberDTO) session.getAttribute("member")).getEmail(), musicList.get(1).getMusicAddress()));
			request.setAttribute("music", new DemoMusicDTO(music2.getMusicAddress(), music2.getMusicTitle(),
					music2.getArtist(), music2.getAlbumAddress()));
			request.getRequestDispatcher("playerDemo.jsp").forward(request, response);
			System.out.println(music1.getMusicTitle());
			System.out.println(music2.getMusicTitle());
		} catch (Exception s) {
			s.printStackTrace();
		}
	}

/*	public void musicRecommand2(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ArrayList<MusicDTO> musicList = null;
		try {
			musicList = new ArrayList<MusicDTO>();
			HttpSession session = request.getSession();
			String[] genreList = request.getParameterValues("genreList");
			musicList = MusicService.getMusicListSelect(genreList);
			MusicDTO music1 = musicList.get(0);
			MusicDTO music2 = musicList.get(1);
			String email = ((MemberDTO) session.getAttribute("member")).getEmail();
			MusicService.createLike2(new LikeDTO(email, music1.getMusicAddress()));
			MusicService.createLike2(new LikeDTO(email, music2.getMusicAddress()));
			request.setAttribute("music1", new DemoMusicDTO(music1.getMusicAddress(), music1.getMusicTitle(),
					music1.getArtist(), music1.getAlbumAddress()));
			request.setAttribute("music2", new DemoMusicDTO(music2.getMusicAddress(), music2.getMusicTitle(),
					music2.getArtist(), music2.getAlbumAddress()));
			System.out.println("Dispatcher");
			request.getRequestDispatcher("playerDemo.jsp").forward(request, response);
		} catch (Exception s) {
			s.printStackTrace();
		}
	}
*/
	// 장르에 맞는 노래 목록 가져오기
	public void getMusicListSelect(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ArrayList<MusicDTO> musicList = null;
		try {
			String[] genreList = request.getParameterValues("genreList");
			musicList = MusicService.getMusicListSelect(genreList);
			request.setAttribute("musicList", musicList);
			request.getRequestDispatcher("selectSongs.jsp").forward(request, response);
		} catch (Exception s) {
			s.printStackTrace();
		}
	}

	/*
	 * createLike() : 1. 회원이 음악플레이어에서 노래 재생 중 좋아요 누름 2. 노래가 종료되는 순간(다른 곡으로 이동(이전
	 * 곡, 다음 곡, history 선택) 시) 다른 노래로 넘어가는 로직에서 '좋아요' 정보 command로 전송 3. Like테이블에
	 * 회원아이디(email) + 음악주소(musicAddress) + 좋아요여부(like) 생성
	 */
	public void createLike(HttpServletRequest request, HttpServletResponse response) throws NotExistException {
		try {
			String email = request.getParameter("email");
			String musicAddress = request.getParameter("musicAddress");
			MusicService.createLike(new LikeDTO(email, musicAddress));
			System.out.println("controller");
		} catch (Exception s) {
			s.printStackTrace();
		}
		System.out.println("like정보 생성 성공");
	}

	/*
	 * deleteLike() : 1. 회원이 음악플레이어에서 노래 재생 중 좋아요 취소 2. 노래가 종료되는 순간(다른 곡으로 이동(이전
	 * 곡, 다음 곡, history 선택) 시) 다른 노래로 넘어가는 로직에서 '좋아요 취소함' 정보 command로 전송 3.
	 * Like테이블에 회원아이디(email) + 음악주소(musicAddress)로 검색하여 좋아요(like) 정보 삭제
	 */
	public void deleteLike(HttpServletRequest request, HttpServletResponse response) throws NotExistException {
		try {
			String email = request.getParameter("email");
			String musicAddress = request.getParameter("musicAddress");
			MusicService.deleteLike(new LikeDTO(email, musicAddress));
		} catch (Exception s) {
			s.printStackTrace();
		}
		System.out.println("like정보 삭제 성공");
	}

	public void getRandomMusicList(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ArrayList<MusicDTO> musicList = null;
		try {
			musicList = new ArrayList<MusicDTO>();
			musicList = MusicService.getRandomMusicList();
			request.setAttribute("musicList", musicList);
			request.getRequestDispatcher("playerDemo.jsp").forward(request, response);
		} catch (Exception s) {
			s.printStackTrace();
		}
	}

}
