package com.oyq.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oyq.dao.HeroDao;

/**
 * Servlet implementation class delHeroServlet
 */
@WebServlet("/delHeroServlet")
public class delHeroServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private HeroDao heroDao = new HeroDao();     
    /**
     * @see HttpServlet#HttpServlet()
     */
    public delHeroServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String id = "";
		if(request.getParameter("id")!=null && !"".equals(request.getParameter("id"))){
			id = request.getParameter("id");
			try {
				heroDao.deleteHeroById(Integer.valueOf(id));
			
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		response.sendRedirect("listHeroServlet");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
