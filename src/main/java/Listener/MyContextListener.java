package Listener; /**
 * Created by xiaohuang on 2018/9/28.
 */

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import java.io.*;

@WebListener()
public class MyContextListener implements ServletContextListener{
    public void contextInitialized(ServletContextEvent sce) {
        Integer online = 0;
        sce.getServletContext().setAttribute("online",online);
        File file = new File("D:\\history.txt");
        try {
            Reader reader = new FileReader(file);
            int history=reader.read();
            sce.getServletContext().setAttribute("history",history);
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
      /* This method is called when the servlet context is
         initialized(when the Web application is deployed). 
         You can initialize servlet context related data here.
      */
    }

    public void contextDestroyed(ServletContextEvent sce) {
      /* This method is invoked when the Servlet Context 
         (the Web application) is undeployed or 
         Application Server shuts down.
      */
        Object history = sce.getServletContext().getAttribute("history");
        File file=new File("D:\\history.txt");
        try {
            Writer writer = new FileWriter(file);
            writer.write(history.toString());
            writer.flush();
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
