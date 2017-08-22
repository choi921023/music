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
			if (command.equals("getMember")) {// ȸ�� ���� �˻�
				getMember(request, response);
			} /*
				 * else if(command.equals("getMusic")){//���� ���� �˻� - musicaddress
				 * getMusic(request, response); }else
				 * if(command.equals("getMusicsByTitle")){//���� ���� �˻� - title
				 * getMusicsByTitle(request, response); }else
				 * if(command.equals("getMusicsBySinger")){//���� ���� �˻� - singer
				 * getMusicsBySinger(request, response); }
				 */else if (command.equals("addMember")) {// ȸ�� ����
				addMember(request, response);
			} /*
				 * else if(command.equals("updateMemberReq")){//ȸ�� ���� ���� ��û?
				 * updateMemberReq(request, response); }else
				 * if(command.equals("deleteMember")){//��� ����� Ż��[����]
				 * deleteMember(request, response); }else
				 * if(command.equals("addMusic")){//�뷡 �߰� - ������?
				 * addMusic(request, response); }
				 */else if (command.equals("getMusicListSelect")) {
				getMusicListSelect(request, response);
			} else if (command.equals("createLike")) {// like �� �� �߰�
				createLike(request, response);
			} else if (command.equals("deleteLike")) {// like �� �� like ���
				deleteLike(request, response);
			} else if (command.equals("musicRecommand")) {// station ���� ��������
				musicRecommand(request, response);
			}/* else if (command.equals("musicRecommand2")) {// station ���� ��������
				musicRecommand2(request, response);
			}*/
			/*
			 * else if(command.equals("createHistory")){//���� �뷡 �̷� �߰�
			 * createHistory(request, response); }else
			 * if(command.equals("deleteHistory")){//�뷡 �̷� ����(���� �ʿ�) - ��ü
			 * history ����?? deleteHistory(request, response); }else
			 * if(command.equals("getHistory")){// �뷡 �̷� �˻� getHistory(request,
			 * response); }else if(command.equals("createStation")){// station��
			 * like�� �뷡 ��� �߰�(���� �ʿ�) - �̰��� getHistory(request, response); }else
			 * if(command.equals("deleteStation")){// station���� like�� �뷡 ����(����
			 * �ʿ�) - �̰��� getHistory(request, response); }else
			 * if(command.equals("getStation")){// station ���� ��������
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
	// �帣�� �´� �뷡 ��� ��������
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
	 * createLike() : 1. ȸ���� �����÷��̾�� �뷡 ��� �� ���ƿ� ���� 2. �뷡�� ����Ǵ� ����(�ٸ� ������ �̵�(����
	 * ��, ���� ��, history ����) ��) �ٸ� �뷡�� �Ѿ�� �������� '���ƿ�' ���� command�� ���� 3. Like���̺�
	 * ȸ�����̵�(email) + �����ּ�(musicAddress) + ���ƿ俩��(like) ����
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
		System.out.println("like���� ���� ����");
	}

	/*
	 * deleteLike() : 1. ȸ���� �����÷��̾�� �뷡 ��� �� ���ƿ� ��� 2. �뷡�� ����Ǵ� ����(�ٸ� ������ �̵�(����
	 * ��, ���� ��, history ����) ��) �ٸ� �뷡�� �Ѿ�� �������� '���ƿ� �����' ���� command�� ���� 3.
	 * Like���̺� ȸ�����̵�(email) + �����ּ�(musicAddress)�� �˻��Ͽ� ���ƿ�(like) ���� ����
	 */
	public void deleteLike(HttpServletRequest request, HttpServletResponse response) throws NotExistException {
		try {
			String email = request.getParameter("email");
			String musicAddress = request.getParameter("musicAddress");
			MusicService.deleteLike(new LikeDTO(email, musicAddress));
		} catch (Exception s) {
			s.printStackTrace();
		}
		System.out.println("like���� ���� ����");
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
