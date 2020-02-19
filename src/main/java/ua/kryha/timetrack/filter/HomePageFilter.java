package ua.kryha.timetrack.filter;


import ua.kryha.timetrack.model.ERole;

import javax.servlet.DispatcherType;
import javax.servlet.annotation.WebFilter;

@WebFilter(dispatcherTypes = {DispatcherType.REQUEST,
                              DispatcherType.FORWARD},
           urlPatterns = "/home/*")
public class HomePageFilter extends GlobalFilter{

    public HomePageFilter() {
        super(ERole.ROLE_USER);
    }

}
