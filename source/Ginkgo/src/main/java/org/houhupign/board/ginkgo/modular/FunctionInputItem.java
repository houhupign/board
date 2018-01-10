package org.houhupign.board.ginkgo.modular;

public class FunctionInputItem<T> {

	private Long id;
	private Long functionInputId;
	private String name;
	private T defaultValue;

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

	public T getDefaultValue() {
		return defaultValue;
	}

	public void setDefaultValue(T defaultValue) {
		this.defaultValue = defaultValue;
	}

}
