package Test;

import java.io.IOException;
import java.net.URLDecoder;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import sun.misc.BASE64Decoder;

/**
 * Servlet implementation class ServletTest
 */
public class ServletTest extends HttpServlet
{
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletTest()
    {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see Servlet#init(ServletConfig)
     */
    public void init(ServletConfig config) throws ServletException
    {
        // TODO Auto-generated method stub
        System.out.println("我是ServleTest的init初始化方法");
    }

    /**
     * @see Servlet#destroy()
     */
    public void destroy()
    {
        // TODO Auto-generated method stub
        System.out.println("我是destroy方法");
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        // TODO Auto-generated method stub
        //	request.setCharacterEncoding("utf-8");
        String paramter = request.getParameter("p");
        BASE64Decoder decoder = new BASE64Decoder();
        byte[] name = decoder.decodeBuffer(paramter);
        String Paramter = new String(name,"utf-8");
        HttpSession session = request.getSession();
        session.setAttribute("name", Paramter);
        request.getRequestDispatcher("/Name.jsp").forward(request, response);

    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        // TODO Auto-generated method stub
        doGet(request, response);
    }

}
