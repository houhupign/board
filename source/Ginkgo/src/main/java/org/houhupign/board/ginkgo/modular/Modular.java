package org.houhupign.board.ginkgo.modular;

public interface Modular {
	public void init();
	public void addFunctiones();
	public String display();
	public void register();
	public FunctionOutput execute(String modeular,FunctionInput inputes);
	public void destory();
}
