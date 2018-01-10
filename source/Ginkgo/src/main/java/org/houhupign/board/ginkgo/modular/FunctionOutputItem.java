package org.houhupign.board.ginkgo.modular;

public class FunctionOutputItem<T> {

	private Long id;
	private Long functionOutputId;
	private String name;
	private T value;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getFunctionOutputId() {
		return functionOutputId;
	}

	public void setFunctionOutputId(Long functionOutputId) {
		this.functionOutputId = functionOutputId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public T getValue() {
		return value;
	}

	public void setValue(T value) {
		this.value = value;
	}

}
