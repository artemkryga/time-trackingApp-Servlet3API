package ua.kryha.timetrack.filter;


import ua.kryha.timetrack.model.ERole;

import javax.servlet.DispatcherType;
import javax.servlet.annotation.WebFilter;

@WebFilter(dispatcherTypes = {DispatcherType.REQUEST, DispatcherType.FORWARD},
        urlPatterns = "/user/*")
public class UserPageFilter extends GlobalFilter {

    public UserPageFilter() {
        super(ERole.ROLE_USER);
    }
}
