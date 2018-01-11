package org.houhupign.board.ginkgo.modular;

public class FunctionInputItem {

	private Long id;
	private Long functionInputId;
	private String name;
	private Value<?> initialValue;

	public Long getFunctionInputId() {
		return functionInputId;
	}

	public void setFunctionInputId(Long functionInputId) {
		this.functionInputId = functionInputId;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Value<?> getInitialValue() {
		return initialValue;
	}

	public void setInitialValue(Value<?> initialValue) {
		this.initialValue = initialValue;
	}
	
}
