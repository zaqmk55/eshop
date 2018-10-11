package Listener;
/**
 * Created by xiaohuang on 2018/9/28.
 */

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
import javax.servlet.http.HttpSessionBindingEvent;

@WebListener()
public class MySessionListener implements HttpSessionListener,HttpSessionAttributeListener{
    public void sessionCreated(HttpSessionEvent se) {
      /* Session is created. */
        Integer online = (Integer) se.getSession().getServletContext().getAttribute("online");
        se.getSession().getServletContext().setAttribute("online",++online);
        int history = (int)se.getSession().getServletContext().getAttribute("history");
        se.getSession().getServletContext().setAttribute("history",++history);
    }

    public void sessionDestroyed(HttpSessionEvent se) {
      /* Session is destroyed. */
        Integer online = (Integer) se.getSession().getServletContext().getAttribute("online");
        se.getSession().getServletContext().setAttribute("online",--online);

    }

    @Override
    public void attributeAdded(HttpSessionBindingEvent httpSessionBindingEvent) {

    }

    @Override
    public void attributeRemoved(HttpSessionBindingEvent httpSessionBindingEvent) {

    }

    @Override
    public void attributeReplaced(HttpSessionBindingEvent httpSessionBindingEvent) {

    }
}
