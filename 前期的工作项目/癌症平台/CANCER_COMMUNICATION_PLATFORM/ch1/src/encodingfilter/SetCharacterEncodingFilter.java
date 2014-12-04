package encodingfilter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

/**
 * Servlet Filter implementation class SetCharacterEncodingFilter
 */
@WebFilter("/SetCharacterEncodingFilter")
public class SetCharacterEncodingFilter implements Filter {

    /**
     * Default constructor. 
     */
	class Request extends HttpServletRequestWrapper
    {
        public Request(HttpServletRequest request) {
            super(request);
        }

        public String toChi(String input) {
            try {
                byte[] bytes = input.getBytes("ISO8859-1");
                return new String(bytes, "utf-8");
            } catch (Exception ex) {
            }
            return null;
        }

        private HttpServletRequest getHttpServletRequest()
        {
            return (HttpServletRequest) super.getRequest();
        }

        public String getParameter(String name)
        {
            return
            toChi(getHttpServletRequest().getParameter(name));
        }
        public String[] getParameterValues(String name)
        {
            String values[] =getHttpServletRequest().getParameterValues(name);
            if (values != null) {
                for (int i = 0; i < values.length; i++) {
                    values[i] = toChi(values[i]);
                }
            }
            return values;
        }
    }
    public SetCharacterEncodingFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		// place your code here

		// pass the request along the filter chain
        HttpServletRequest httpreq = (HttpServletRequest) request;

        if (httpreq.getMethod().equals("post")) {

            request.setCharacterEncoding("utf-8");

        } else {
            request = new Request(httpreq);
        }

        chain.doFilter(request, response);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
