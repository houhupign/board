package org.houhupign.board.ginkgo.modular;

import java.util.HashMap;
import java.util.Map;
import org.springframework.stereotype.Component;

@Component
public class AreaModular extends AbstractModular {

	@Override
	public void init() {
		this.setModularName("area");
		this.setModularNumber("md01");
	}

	@Override
	public void addFunctiones() {
		
		Map<Function, Service> functions = new HashMap<>();
		
		Function addArea = super.createFunction("mdlr001", "addArea", new String[]{"名称","级别"}, new String[]{"名称","级别"});
		
		functions.put(addArea,null);
		
		this.setFunctions(functions);
	}
}
