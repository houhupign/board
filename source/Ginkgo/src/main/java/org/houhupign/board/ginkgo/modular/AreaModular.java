package org.houhupign.board.ginkgo.modular;

import org.springframework.stereotype.Component;

@Component
public class AreaModular extends AbstractModular {

	@Override
	public void init() {
		this.setId(99L);
		this.setModularName("area");
		this.setModularNumber("md01");
	}

	@Override
	public void addFunctiones() {
		// TODO Auto-generated method stub
	}
}
