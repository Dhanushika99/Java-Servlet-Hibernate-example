import javax.servlet.ServletException;

import com.tst.javaresources.TestServlet;

public class Test {

	
	public static void main(String args[]) throws ServletException {
		
		System.out.println("this is main");
		TestServlet t=new TestServlet();
		t.init();
	}
}
