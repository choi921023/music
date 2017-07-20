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
			if(command.equals("getMember")){//ȸ�� ���� �˻�
				getMember(request, response);
			}else if(command.equals("getMusic")){//���� ���� �˻� - musicaddress
				getMusic(request, response);
			}else if(command.equals("getMusicsByTitle")){//���� ���� �˻� - title
				getMusicsByTitle(request, response);
			}else if(command.equals("getMusicsBySinger")){//���� ���� �˻� - singer
				getMusicsBySinger(request, response);
			}else if(command.equals("addMember")){// ȸ�� ����
				addMember(request, response);
			}else if(command.equals("updateMemberReq")){//ȸ�� ���� ���� ��û?
				updateMemberReq(request, response);
			}else if(command.equals("deleteMember")){//��� ����� Ż��[����]
				deleteMember(request, response);
			}else if(command.equals("addMusic")){//�뷡 �߰� - ������?
				addMusic(request, response);
			}else if(command.equals("createLike")){//like �� �� �߰�
				createLike(request, response);
			}else if(command.equals("deleteLike")){//like �� �� like ���
				deleteLike(request, response);
			}else if(command.equals("createHistory")){//���� �뷡 �̷� �߰�
				createHistory(request, response);
			}else if(command.equals("deleteHistory")){//�뷡 �̷� ����(���� �ʿ�) - ��ü history ����??
				deleteHistory(request, response);
			}else if(command.equals("getHistory")){// �뷡 �̷� �˻�
				getHistory(request, response);
			}else if(command.equals("createStation")){// station�� like�� �뷡 ��� �߰�(���� �ʿ�) - �̰���
				getHistory(request, response);
			}else if(command.equals("deleteStation")){// station���� like�� �뷡 ����(���� �ʿ�)  - �̰���
				getHistory(request, response);
			}else if(command.equals("getStation")){// station ���� ��������
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
				request.setAttribute("Msg", "�̹� ���� ���̵� �����մϴ�.");
			}
		}catch(Exception s){
			request.setAttribute("errorMsg", s.getMessage());
		}
		request.getRequestDispatcher(url).forward(request, response);
	}
}
