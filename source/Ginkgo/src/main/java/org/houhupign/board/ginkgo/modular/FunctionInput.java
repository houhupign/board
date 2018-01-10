package org.houhupign.board.ginkgo.modular;

import java.util.List;

public class FunctionInput {
	private Long id;
	private Long functionId;
	private List<FunctionInputItem<?>> inputItems;
	public List<FunctionInputItem<?>> getInputItems() {
		return inputItems;
	}
	public void setInputItems(List<FunctionInputItem<?>> inputItems) {
		this.inputItems = inputItems;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getFunctionId() {
		return functionId;
	}
	public void setFunctionId(Long functionId) {
		this.functionId = functionId;
	}
}
