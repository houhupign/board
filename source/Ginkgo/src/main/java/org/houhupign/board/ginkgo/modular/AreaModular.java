package org.houhupign.board.ginkgo.modular;

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
		
	}
}
