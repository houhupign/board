package org.houhupign.board.ginkgo.modular;

import org.houhupign.board.ginkgo.modular.view.ModularView;

public interface Modular {
	public void init();
	public void addFunctiones();
	public ModularView display();
	public void register();
	public FunctionOutput execute(String modeular,FunctionInput inputes);
	public void destory();
}
