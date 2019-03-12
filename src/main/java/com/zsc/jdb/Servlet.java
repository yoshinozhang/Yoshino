package com.zsc.jdb;

// 导入必需的 java 库
import javafx.beans.property.Property;
import jdk.internal.util.xml.impl.Input;
import org.apache.commons.io.IOUtils;


import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import javax.jnlp.IntegrationService;
import javax.servlet.*;
import javax.servlet.http.*;

// 扩展 HttpServlet 类
public class Servlet extends HttpServlet {
    private  static  final long serialVersionUID = 1L;
    public Servlet (){
        super();
    }
    protected  void doGet(HttpServletRequest req ,HttpServletResponse res)throws ServletException ,IOException{
        InputStream is = null;
        jdbcService jdbc = new jdbcService();

        if(req.getParameter("name")!= null){
            Student student = new Student();
            student.setName(req.getParameter("name"));
            student.setAge(Integer.parseInt(req.getParameter("age")));
            student.setId(req.getParameter("id"));
            student.setSex(req.getParameter("sex"));
            jdbc.insert(student);
        }
        try {
            //设置相应内容类型
            res.setContentType("text/html;charset=UTF-8");
            PrintWriter out =res.getWriter();
            String title ="使用表单读取数据类型";
            //处理中文
            is = Servlet.class.getResourceAsStream("/hello.html");
            IOUtils.copy(is, out, StandardCharsets.UTF_8);
            //String name =new String(req.getParameter("name").getBytes("ISO8859-1"),"UTF-8");
            String docType =
                    "<!doctype html public \"-//w3c//dtd html 4.0 " +
                            "transitional//en\">\n";
            /*out.println(docType +
                    "<html>\n" +
                    "<head><meta charset=\"utf-8\"><title>" + title + "</title></head>\n" +
                    "<body bgcolor=\"#f0f0f0\">\n" +
                    "<h1 align=\"center\">" + title + "</h1>\n" +
                    "<table width=\"100%\" border=\"1\" align=\"center\">\n" +
                    "<tr bgcolor=\"#949494\">\n" +
                    "<th>参数名称</th><th>参数值</th>\n"+
                    "</tr>\n");*/

            Enumeration paramNames = req.getParameterNames();

            while(paramNames.hasMoreElements()) {
                String paramName = (String)paramNames.nextElement();
                /*out.print("<tr><td>" + paramName + "</td>\n");*/
                String[] paramValues =
                        req.getParameterValues(paramName);
                // 读取单个值的数据
                if (paramValues.length == 1) {
                    String paramValue = paramValues[0];
                   // if (paramValue.length() == 0)
                        /*out.println("<td><i>没有值</i></td>");*/
                    //else
                        /*out.println("<td>" + paramValue + "</td>");*/
                } else {
                    // 读取多个值的数据
                   /* out.println("<td><ul>");*/
                    for(int i=0; i < paramValues.length; i++) {
                        /*out.println("<li>" + paramValues[i]);*/
                    }
                    /*out.println("</ul></td>");*/

                }
                /*out.print("</tr>");*/
            }
            /*out.println("\n</table>\n</body></html>");*/
            String [] values = req.getParameterValues("name");
            Map map = new HashMap();
            map.put("as","sdad");
            map.put("zsc","asdasda");
            Student stu = new Student();
            stu.setName("cj");
            map.put("cj",stu);
            out.println(map);



        }finally {
            if(is!=null) {
                is.close();
            }
        }


    }

    public  void Data(){


    }
    public void doPost(HttpServletRequest req ,HttpServletResponse res)throws ServletException ,IOException{
        doGet(req,res);
    }
    public void destroy()
    {

    }
}
