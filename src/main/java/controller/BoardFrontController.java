package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Action;
import action.BoardContentAction;
import action.BoardListAction;
import action.BoardUpdateFormAction;
import action.BoardUpdateProAction;
import action.BoardWriteFormAction;
import action.BoardWriteProAction;
import vo.ActionForward;

/**
 * Servlet implementation class BoardFrontController
 */
@WebServlet("*.bo")
public class BoardFrontController extends HttpServlet {
   private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BoardFrontController() {
        super();
        // TODO Auto-generated constructor stub
    }

   /**
    * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
    */
   protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      //1. 요청파악
      String requestURI = request.getRequestURI();
      //요청 URL : http://localhost:8088/MemberProject/login.me
      //requestURI : /MemberProject/login.me
      
      String contextPath = request.getContextPath();
      //애플리케이션 경로
      //contextPath : /MemberProject
      
      String command = requestURI.substring(contextPath.length());
      System.out.println("command = " + command);
      
      //2. 각 요청별로 요청처리
      //다형성을 사용해서
      Action action = null;
      ActionForward forward = null;
      
      //중요하다(이거 이해하고 구현할 수 있으면 다 가능)
      if(command.equals("/boardWriteForm.bo")) {
         action = new BoardWriteFormAction();
         
         try {
            forward = action.execute(request, response);
         } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
         }
      }
      
      else if(command.equals("/boardWritePro.bo")) {
         action = new BoardWriteProAction();
         
         try {
            forward = action.execute(request, response);
         } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
         }
      }
      
      else if(command.equals("/boardList.bo")) {
    	  action = new BoardListAction();
    	  
    	  try {
    		  forward = action.execute(request, response);
    	  } catch (Exception e) {
    		  // TODO Auto-generated catch block
    		  e.printStackTrace();
    	  }
      }
      
      else if(command.equals("/boardContent.bo")) {
    	  action = new BoardContentAction();
    	  
    	  try {
    		  forward = action.execute(request, response);
    	  } catch (Exception e) {
    		  // TODO Auto-generated catch block
    		  e.printStackTrace();
    	  }
      }
      
      else if(command.equals("/boardUpdateForm.bo")) {
    	  action = new BoardUpdateFormAction();
    	  
    	  try {
    		  forward = action.execute(request, response);
    	  } catch (Exception e) {
    		  // TODO Auto-generated catch block
    		  e.printStackTrace();
    	  }
      }
      
      else if(command.equals("/boardUpdatePro.bo")) {
    	  action = new BoardUpdateProAction();
    	  
    	  try {
    		  forward = action.execute(request, response);
    	  } catch (Exception e) {
    		  // TODO Auto-generated catch block
    		  e.printStackTrace();
    	  }
      }
      
      
      
      
      
      
      //3.forward 객체의 정보를 사용해서 포워딩
      if(forward != null) {
         //excute 요청처리가 제대로 됐으면 ....
         if(forward.isRedirect()) {
            response.sendRedirect(forward.getUrl());
         }
         else {
            RequestDispatcher dispatcher = 
                  request.getRequestDispatcher(forward.getUrl());
            dispatcher.forward(request, response);
         }
         
      }
      
   }

   /**
    * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
    */
   protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      // TODO Auto-generated method stub
      request.setCharacterEncoding("UTF-8");
      doGet(request, response);
   }

}