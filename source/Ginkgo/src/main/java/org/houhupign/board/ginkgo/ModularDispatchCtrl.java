package org.houhupign.board.ginkgo;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ModularDispatchCtrl {
	
	@RequestMapping(name="vist/{modularName}")
	public String vistModular(@PathVariable("modularName") String modularName,HttpServletRequest request,HttpServletResponse response){
		return modularName;
	}
	
	@RequestMapping(name="listAllModular")
	public String listAllModular(String modularName,HttpServletRequest request,HttpServletResponse response){
		return "modularList";
	}
}
