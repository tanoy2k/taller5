package ar.com.twitter.controllers;


import javax.servlet.http.HttpServletResponse;

/**
 * The Class AbstractJsonController.
 */
public abstract class AbstractJsonController {
	
	/**
	 * Sets the headers.
	 *
	 * @param response the new headers
	 */
	protected final void setHeaders(final HttpServletResponse response) {
		response.addHeader("Access-Control-Allow-Origin", "*");
		response.addHeader("Access-Control-Allow-Methods", "GET,POST");
		response.addHeader("Access-Control-Max-Age", "360");
		response.addHeader("Access-Control-Allow-Headers", "x-requested-with");
	}
}
