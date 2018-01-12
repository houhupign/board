package org.houhupign.board.ginkgo.modular;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("modularDispatch")
public class ModularDispatchCtrl {
	
	@Autowired
	private ModularDao modularDao;
	
	@RequestMapping("vist/{modularNumber}")
	public String vistModular(@PathVariable("modularNumber") String modularName,HttpServletRequest request,HttpServletResponse response){
		
		return modularDao.queryModularTemplate(modularName);
	}
	
	@RequestMapping("listAllModular")
	public String listAllModular(HttpServletRequest request,HttpServletResponse response){
		return "modularList";
	}
	
	@ResponseBody
	@RequestMapping(value="execute/{modularNumber}/{functionName}",method = RequestMethod.POST, produces = "application/json")
	public FunctionOutput executeModularFunction(@PathVariable("modularNumber") String modularName,@PathVariable("functionName") String functionName,FunctionInput inputs,HttpServletRequest request,HttpServletResponse response){
		return null;
	}
}
