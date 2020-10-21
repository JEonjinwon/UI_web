package kr.or.ddit.member.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//import org.apache.commons.beanutils.BeanUtils;

import kr.or.ddit.member.service.MemberService;
import kr.or.ddit.member.vo.MemberVo;

@WebServlet("/MemberServlet")
public class MemberServlet extends HttpServlet {
   private static final long serialVersionUID = 7428836381231581524L;
   
   //GET방식 호출 시
   protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
   }
   
   //POST방식 호출 시
   protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      request.setCharacterEncoding("UTF-8");
      retrieveMemberList(request, response);
   }
   
   private void retrieveMemberList(HttpServletRequest request, HttpServletResponse response) {
      try {
         //request에서 받아와서 세팅해 줄 것임
         MemberVo memberVo = new MemberVo();
         memberVo.setId(request.getParameter("id"));
         memberVo.setName(request.getParameter("name"));
         
         //서비스 호출해서 '목록 조회'를 수행
         MemberService service = new MemberService();
         List<MemberVo> resultList = service.retrieveMemberList(memberVo);
         
         //조회결과를 request에 담아서 전송
         request.setAttribute("memberVoList", resultList);
         //조회결과를 보낼 URL을 지정
         RequestDispatcher  disp = request.getRequestDispatcher("/html/member/member_list.jsp");
         disp.forward(request, response);
         
      } catch (ServletException | IOException e) {
         e.printStackTrace();
      } catch (Exception e1) {
         e1.printStackTrace();
      }
   }
   
}