package AdminServlet;

import daoImp.ProductDaoImp;
import entity.Product;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.IOUtils;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.lang.reflect.InvocationTargetException;
import java.util.*;

/**
 * Created by 瀚 on 2018/10/6.
 */
@WebServlet("/admin/upload")
public class UploadServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Check that we have a file upload request
        boolean isMultipart = ServletFileUpload.isMultipartContent(request);
        if(isMultipart){
            // Create a factory for disk-based file items
            DiskFileItemFactory factory = new DiskFileItemFactory();
            // Configure a repository (to ensure a secure temp location is used)
            ServletContext servletContext = this.getServletConfig().getServletContext();
            File repository = (File) servletContext.getAttribute("javax.servlet.context.tempdir");
            factory.setRepository(repository);
            // Create a new file upload handler
            ServletFileUpload upload = new ServletFileUpload(factory);
            // Parse the request
            List<FileItem> items=new ArrayList<>();
            try {
                items = upload.parseRequest(request);
            } catch (FileUploadException e) {
                e.printStackTrace();
            }
            //创建存储表单数据的map
            Map<String,String> inputMap=new HashMap<>();
            // Process the uploaded items
            Iterator<FileItem> iter = items.iterator();
            while (iter.hasNext()) {
                FileItem item = iter.next();
                if (item.isFormField()) {
                    //如果是普通文本域
                    String fieldName=item.getFieldName();
                    String value=item.getString("gbk");
                    inputMap.put(fieldName,value);
                } else {
                    //文件上传的域
                    //创建好的文件最终放到的目录
                    String fileName=item.getName();
                    String filePath=this.getServletContext().getRealPath("/products/"+fileName);
                    OutputStream outputStream=new FileOutputStream(filePath);
                    IOUtils.copy(item.getInputStream(),outputStream);
                    item.delete();
                    inputMap.put(item.getFieldName(),"products/"+fileName);
                }
            }
            //文件上传成功后把所有product相关数据库持久化到数据库
            Product product=new Product();
            product.setPid(UUID.randomUUID().toString());
            product.setPdate(new java.util.Date());
            try {
                BeanUtils.populate(product,inputMap);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }
            new ProductDaoImp().add(product);
            request.getRequestDispatcher("/admin/product?method=queryAll&currentpage=1").forward(request,response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

}
