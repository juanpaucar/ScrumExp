package com.scrumexp.servlets;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.appengine.api.datastore.Key;
import com.scrumexp.objects.Project;
import com.scrumexp.objectsStore.ProjectStore;

import login.Usuario;
import login.UsuarioUtils;

@SuppressWarnings("serial")
public class ProjectManagerServlet extends HttpServlet {
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		/*HttpSession session = new 
		resp.se*/
		
	}

}
