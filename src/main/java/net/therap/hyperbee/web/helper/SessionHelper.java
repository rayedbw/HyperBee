package net.therap.hyperbee.web.helper;

import net.therap.hyperbee.domain.User;
import net.therap.hyperbee.service.UserService;
import net.therap.hyperbee.web.security.AuthUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpSession;
import java.util.Map;

/**
 * @author rayed
 * @author bashir
 * @since 11/24/16 12:12 PM
 */
@Component
public class SessionHelper {

    @Autowired
    private UserService userService;

    public void persistInSession(User user) {
        AuthUser authUser = new AuthUser();
        authUser.setId(user.getId());
        authUser.setUsername(user.getUsername());
        authUser.setRoleList(user.getRoleList());

        ServletRequestAttributes servletRequestAttributes = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
        HttpSession session = servletRequestAttributes.getRequest().getSession();
        session.setAttribute("authUser", authUser);
    }

    public void persistInSession(Map<String, Integer> map) {
        ServletRequestAttributes servletRequestAttributes = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
        HttpSession session = servletRequestAttributes.getRequest().getSession();
        session.setAttribute("statsMap", map);
    }

    public void persistInSession(String key, int count) {
        HttpSession session = getHttpSession();
        Map<String, Integer> statsMap = (Map<String, Integer>) session.getAttribute("statsMap");

        statsMap.put(key, count);
        session.setAttribute("statsMap", statsMap);
    }

    public AuthUser getAuthUserFromSession() {
        ServletRequestAttributes servletRequestAttributes = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();

        HttpSession session = servletRequestAttributes.getRequest().getSession();

        return (AuthUser) session.getAttribute("authUser");
    }

    public void invalidateSession() {
        ServletRequestAttributes servletRequestAttributes = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();

        HttpSession session = servletRequestAttributes.getRequest().getSession();
        session.invalidate();
    }


    public int getUserIdFromSession() {
        ServletRequestAttributes servletRequestAttributes = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();

        HttpSession session = servletRequestAttributes.getRequest().getSession();
        AuthUser authUser = (AuthUser) session.getAttribute("authUser");

        return authUser.getId();
    }

    public HttpSession getHttpSession() {
        ServletRequestAttributes servletRequestAttributes = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
        HttpSession session = servletRequestAttributes.getRequest().getSession();
        return session;
    }
}
