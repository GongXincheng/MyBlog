package gxc.web.filter;

import gxc.utils.HibernateUtil;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import org.hibernate.Session;

public class TransactionFilter implements Filter{

	@Override
	public void destroy() {
		
	}
	
	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		
		//获取当前线程的session
		Session session = HibernateUtil.getCurrentSession();
		session.beginTransaction();
		
		try{
			chain.doFilter(request, response);
			if(session!=null && session.isOpen()){
				session.getTransaction().commit();
			}
		}catch(Exception e){
			e.printStackTrace();
			if(session!=null && session.isOpen()){
				session.getTransaction().rollback();
			}
		}
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		
	}

}
