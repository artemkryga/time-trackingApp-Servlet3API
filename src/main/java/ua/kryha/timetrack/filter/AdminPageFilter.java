package ua.kryha.timetrack.filter;


import ua.kryha.timetrack.model.ERole;

import javax.servlet.DispatcherType;
import javax.servlet.annotation.WebFilter;

@WebFilter(dispatcherTypes = {DispatcherType.REQUEST, DispatcherType.FORWARD},
        urlPatterns = "/admin/*")
public class AdminPageFilter extends GlobalFilter{

    public AdminPageFilter() {
        super(ERole.ROLE_ADMIN);
    }
}
