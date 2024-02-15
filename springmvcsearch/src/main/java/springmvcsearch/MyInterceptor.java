package springmvcsearch;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class MyInterceptor implements HandlerInterceptor{

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		// TODO Auto-generated method stub
		System.out.println("prehandle method");
		String q = request.getParameter("searchQuery");
		System.out.println(q);
		if(q.startsWith("d")) {
			System.out.println("Query should not start with d:/");
			response.setContentType("text/html");
			response.getWriter().println("Should not start with d");
			return false;
		}
//		return HandlerInterceptor.super.preHandle(request, response, handler);
		return true;
	}
	
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("postHandle method");
		
		HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		// TODO Auto-generated method stub
		System.out.println("afterCompletion method");
		HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
	}
	
}
