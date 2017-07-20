package music.contoller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import music.model.MusicService;
import music.model.dto.MemberDTO;

@WebServlet("/mc")
public class MusicController extends HttpServlet {

	public MusicController() {
    	super();
    }

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("euc-kr");
		String command = request.getParameter("command");
		
		try{
			if(command.equals("getMember")){//회원 정보 검색
				getMember(request, response);
			}else if(command.equals("getMusic")){//음악 정보 검색 - musicaddress
				getMusic(request, response);
			}else if(command.equals("getMusicsByTitle")){//음악 정보 검색 - title
				getMusicsByTitle(request, response);
			}else if(command.equals("getMusicsBySinger")){//음악 정보 검색 - singer
				getMusicsBySinger(request, response);
			}else if(command.equals("addMember")){// 회원 가입
				addMember(request, response);
			}else if(command.equals("updateMemberReq")){//회원 정보 수정 요청?
				updateMemberReq(request, response);
			}else if(command.equals("deleteMember")){//재능 기부자 탈퇴[삭제]
				deleteMember(request, response);
			}else if(command.equals("addMusic")){//노래 추가 - 관리자?
				addMusic(request, response);
			}else if(command.equals("createLike")){//like 한 곡 추가
				createLike(request, response);
			}else if(command.equals("deleteLike")){//like 한 곡 like 취소
				deleteLike(request, response);
			}else if(command.equals("createHistory")){//들은 노래 이력 추가
				createHistory(request, response);
			}else if(command.equals("deleteHistory")){//노래 이력 삭제(협의 필요) - 전체 history 삭제??
				deleteHistory(request, response);
			}else if(command.equals("getHistory")){// 노래 이력 검색
				getHistory(request, response);
			}else if(command.equals("createStation")){// station에 like한 노래 목록 추가(협의 필요) - 미결정
				getHistory(request, response);
			}else if(command.equals("deleteStation")){// station에서 like한 노래 삭제(협의 필요)  - 미결정
				getHistory(request, response);
			}else if(command.equals("getStation")){// station 정보 가져오기
				getHistory(request, response);
			}
		}catch(Exception s){
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
		String pw = request.getParameter("pw");
		MemberDTO member = new MemberDTO(id, name, pw);
		try{
			boolean result = MusicService.addMember(member);
			if(result){
				HttpSession session = request.getSession();
				session.setAttribute("id", id);
				session.setAttribute("name", name);
				session.setAttribute("pw", pw);
				response.sendRedirect("member");
				url = "checkbox.jsp";
			}else{
				request.setAttribute("Msg", "이미 같은 아이디가 존재합니다.");
			}
		}catch(Exception s){
			request.setAttribute("errorMsg", s.getMessage());
		}
		request.getRequestDispatcher(url).forward(request, response);
	}
}
