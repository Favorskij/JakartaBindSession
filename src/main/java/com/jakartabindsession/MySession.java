package com.jakartabindsession;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

//Тут мы получаем Session
@Path("/GetSession")
public class MySession {

	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String testMethodCookies(@Context HttpServletRequest request, @Context HttpServletResponse response) {

		// Получаем сессию
	    HttpSession session = request.getSession();


		// Возвращает объект, связанный с указанным именем в этом сеансе если он есть.
		Object o = session.getAttribute("MyNameAttributeName");
		// String s = (String)session.getAttribute("MyNameAttributeName1");

		if (o == null) {
			session.setAttribute("MyNameAttributeName", "Attribute Set");
		}else {
			session.setAttribute("MyNameAttributeName", "Attribute Yes");
		}

		return o + "";
	}

}
