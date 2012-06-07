package ro.softwin.prjmng.filter;

import java.io.IOException;
import java.io.Writer;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

/**
 * The authentication filter
 * @author adobrovolschi
 * @created 07/06/2012
 */
public class RecrutementAuthProcessingFilter extends
		UsernamePasswordAuthenticationFilter {
	/*
	 * (non-Javadoc)
	 * @see org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter#successfulAuthentication(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse, javax.servlet.FilterChain, org.springframework.security.core.Authentication)
	 */
	@Override
	protected void successfulAuthentication(HttpServletRequest request,
			HttpServletResponse response, FilterChain chain, Authentication authResult)
			throws IOException, ServletException {
		SavedRequestAwareAuthenticationSuccessHandler srh = new SavedRequestAwareAuthenticationSuccessHandler();
		this.setAuthenticationSuccessHandler(srh);
		srh.setRedirectStrategy(new RedirectStrategy() {
			@Override
			public void sendRedirect(HttpServletRequest httpServletRequest,
					HttpServletResponse httpServletResponse, String s)
					throws IOException {
				// do nothing, no redirect
			}
		});
		super.successfulAuthentication(request, response, chain, authResult);
		HttpServletResponseWrapper responseWrapper = new HttpServletResponseWrapper(
				response);
		Writer out = responseWrapper.getWriter();
		out.write("{success:true}");
		out.close();
	}

	/*
	 * (non-Javadoc)
	 * @see org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter#unsuccessfulAuthentication(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse, org.springframework.security.core.AuthenticationException)
	 */
	@Override
	protected void unsuccessfulAuthentication(HttpServletRequest request,
			HttpServletResponse response, AuthenticationException failed)
			throws IOException, ServletException {
		super.unsuccessfulAuthentication(request, response, failed);
		HttpServletResponseWrapper responseWrapper = new HttpServletResponseWrapper(
				response);
		Writer out = responseWrapper.getWriter();
		out.write("{success:false}");
		out.close();
	}
}
