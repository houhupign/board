package org.houhupign.board.ginkgo;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TestCtrl {
	
	@RequestMapping(value="test")
	public String test(HttpServletRequest request,HttpServletResponse response){
		request.setAttribute("test", "test123123123");
		return "test";
	}
}
