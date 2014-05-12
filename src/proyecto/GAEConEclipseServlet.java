package proyecto;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import javax.servlet.RequestDispatcher;

@SuppressWarnings("serial")
public class GAEConEclipseServlet extends HttpServlet {
    
 protected void processRequest(HttpServletRequest request, 
         HttpServletResponse response)
         throws ServletException, IOException {
 
  response.setContentType("text/html;charset=UTF-8");
  PrintWriter out = response.getWriter();
  try {
   if(request.getParameter("action").equals("create")){
     String autor = request.getParameter("autor");
     String tutorial = request.getParameter("tutorial");
     TurorialUtil.insertar(autor, tutorial);
     request.setAttribute("autor", autor);
     //List<Sprint> tutorials = TurorialUtil.tutorialesPorAutor(autor);
     List<Tutorial> tutorials = TurorialUtil.todosLosTutoriales();
     request.setAttribute("tutorials", tutorials);
     RequestDispatcher rd =  getServletContext().getRequestDispatcher("/Principal.jsp");
    rd.forward(request, response);
   }/*else if(request.getParameter("action").equals("show")){
     List<Sprint> tutorials = TurorialUtil.todosLosTutoriales();
     request.setAttribute("showFullTutorials", tutorials);
     RequestDispatcher rd = getServletContext().getRequestDispatcher("/Principal.jsp");
     rd.forward(request, response);
   }*/
  } finally { 
    out.close();
  }
 } 

 @Override
 protected void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
     processRequest(request, response);
 } 
 
 @Override
 protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
     processRequest(request, response);
 }
 
}