package ua.kryha.timetrack.servlet.page;

import ua.kryha.timetrack.model.EUserAction;
import ua.kryha.timetrack.model.User;
import ua.kryha.timetrack.payload.request.AdminActionRequest;
import ua.kryha.timetrack.payload.response.AllUserPersistenceResponse;
import ua.kryha.timetrack.service.AdminPageService;
import ua.kryha.timetrack.service.PersistenceChoiсeService;
import ua.kryha.timetrack.service.UserPageService;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/admin")
public class AdminPageServlet extends HttpServlet {

    private UserPageService userPageService;
    private PersistenceChoiсeService persistenceChoiсeService;

    @Override
    public void init(ServletConfig config) throws ServletException {

        ServletContext context = config.getServletContext();

        persistenceChoiсeService = (PersistenceChoiсeService) context.getAttribute("persistenceChoiсeService");
        userPageService = (UserPageService) context.getAttribute("userPageService");
    }


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        List<AllUserPersistenceResponse> persistenceResponses = persistenceChoiсeService.getAllUserChoice();
        request.setAttribute("persistenses" , persistenceResponses);
        request.getServletContext().getRequestDispatcher("/admin.jsp").forward(request, response);

    }

    //TODO shuffle this horrible POST METHOD
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action =  request.getParameter("action");
        String nameActivity =  request.getParameter("nameActivity");
        String username = request.getParameter("username");
        Integer id = Integer.parseInt(request.getParameter("id"));
        AdminActionRequest adminActionRequest = new AdminActionRequest(id , action , nameActivity , username);
        if (request.getParameter("accept") != null){
            System.out.println(action.equals(EUserAction.ADD.toString()));
            if (action.equals(EUserAction.ADD.toString()))
                userPageService.addActivityToUser(adminActionRequest);
            else if (action.equals(EUserAction.DELETE.toString()))
                userPageService.deleteActivityToUser(adminActionRequest);
            response.sendRedirect(request.getContextPath() + "/admin");
        }else {
            persistenceChoiсeService.deletePersistenceChoice(id);
            doGet(request , response);
        }


    }
}
