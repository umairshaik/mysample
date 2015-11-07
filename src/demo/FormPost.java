package demo;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class FormPost
 */
@WebServlet("/FormPost")
public class FormPost extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final int BYTES_DOWNLOAD = 1024;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public FormPost() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		File file = new File("D:\\WorkSpace\\JavaEE\\Deployment\\hello.txt");
		if (!file.exists()) {
			file.createNewFile();
		} else {
			file.delete();
		}
		PrintWriter pw = response.getWriter();
		Enumeration<String> e = request.getParameterNames();
		while (e.hasMoreElements()) {

			String pname = (String) e.nextElement();

			// byte buf[] = pname.getBytes();
			// OutputStream f0 = new FileOutputStream(file, true);
			// for (int i = 0; i < buf.length; i ++) {
			// f0.write(buf[i]);
			// }
			// f0.close();

			pw.print(pname + " = ");
			String pvalue = request.getParameter(pname);
			pvalue = pvalue + " ";
			byte buf1[] = pvalue.getBytes();
			OutputStream f1 = new FileOutputStream(file, true);
			for (int i = 0; i < buf1.length; i++) {
				f1.write(buf1[i]);
			}
			f1.close();

			pw.println(pvalue);
		}
		pw.close();
	}
}
