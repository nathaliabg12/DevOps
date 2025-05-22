package com.example.controller;

import com.example.dao.StudentDAO;
import com.example.model.Student;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "StudentServlet", urlPatterns = {"/students"})
public class StudentServlet extends HttpServlet {
    private StudentDAO studentDAO;

    @Override
    public void init() throws ServletException {
        super.init();
        studentDAO = new StudentDAO();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        
        if (action == null) {
            action = "list";
        }

        try {
            switch (action) {
                case "new":
                    showNewForm(request, response);
                    break;
                case "insert":
                    insertStudent(request, response);
                    break;
                case "delete":
                    deleteStudent(request, response);
                    break;
                case "edit":
                    showEditForm(request, response);
                    break;
                case "update":
                    updateStudent(request, response);
                    break;
                case "view":
                    viewStudent(request, response);
                    break;
                default:
                    listStudents(request, response);
                    break;
            }
        } catch (Exception e) {
            throw new ServletException(e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    private void listStudents(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Student> students = studentDAO.findAll();
        request.setAttribute("students", students);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/list.jsp");
        dispatcher.forward(request, response);
    }

    private void showNewForm(HttpServletRequest request, HttpServletResponse response) 
        throws ServletException, IOException {
        Student student = new Student();
        student.setSid(""); // ID vazio
        request.setAttribute("student", student);
        request.getRequestDispatcher("/WEB-INF/views/form.jsp").forward(request, response);
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String sid = request.getParameter("sid");
        Student student = studentDAO.findById(sid);
        request.setAttribute("student", student);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/form.jsp");
        dispatcher.forward(request, response);
    }

    private void viewStudent(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String sid = request.getParameter("sid");
        Student student = studentDAO.findById(sid);
        request.setAttribute("student", student);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/view.jsp");
        dispatcher.forward(request, response);
    }

    private void insertStudent(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Student student = new Student();
        student.setSid(request.getParameter("sid"));
        student.setUsername(request.getParameter("username"));
        student.setEmail(request.getParameter("email"));
        student.setYear(Integer.parseInt(request.getParameter("year")));
        student.setDepartment(request.getParameter("department"));
        
        studentDAO.insert(student);
        response.sendRedirect("students");
    }

    private void updateStudent(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Student student = new Student();
        student.setSid(request.getParameter("sid"));
        student.setUsername(request.getParameter("username"));
        student.setEmail(request.getParameter("email"));
        student.setYear(Integer.parseInt(request.getParameter("year")));
        student.setDepartment(request.getParameter("department"));
        
        studentDAO.update(student);
        response.sendRedirect("students");
    }

    private void deleteStudent(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String sid = request.getParameter("sid");
        studentDAO.delete(sid);
        response.sendRedirect("students");
    }
}