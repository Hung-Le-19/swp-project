/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import dao.CategoryDao;
import dao.DimensionDAO;
import dao.PricePackageDAO;
import dao.SubjectDAO;
import entity.Category;
import entity.Dimension;
import entity.PricePackage;
import entity.Subject;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import utils.Constant;

/**
 *
 * @author lhquan1
 */
public class SubjectOverViewlServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            int subjectId = Integer.parseInt(request.getParameter("subjectId"));
            CategoryDao cateDao = new CategoryDao();
            List<Category> cateList = cateDao.getByType(Constant.Category.SUBJECT);
            Subject subject = new SubjectDAO().getById(subjectId);

            request.setAttribute("subject", subject);
            request.setAttribute("cateList", cateList);
            request.getRequestDispatcher("subjectDetail.jsp").forward(request, response);
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Map<String, String[]> param = request.getParameterMap();

        for (String key : param.keySet()) {
            System.out.println(key + " = " + param.get(key)[0]);
        }
        int subjectId = Integer.parseInt(request.getParameter("subjectId"));

        Subject oldSubject = new SubjectDAO().getById(subjectId);
        String name = request.getParameter("name");
        String category = request.getParameter("category");
        String description = request.getParameter("description");
        String status = request.getParameter("status");
        String featured = request.getParameter("featured");
        oldSubject.setName(name);
        oldSubject.setCategory(category);
        oldSubject.setDescription(description);
        oldSubject.setStatus(status);
        oldSubject.setFeatured(featured  == null ? false : true);
        boolean check = new SubjectDAO().update(oldSubject);
        response.sendRedirect("subjects");

    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
