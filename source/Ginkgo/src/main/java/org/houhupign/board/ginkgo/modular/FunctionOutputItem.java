package org.houhupign.board.ginkgo.modular;

public class FunctionOutputItem {

	private Long id;
	private Long functionOutputId;
	private String name;
	private Value<?> value;

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

	public Value<?> getValue() {
		return value;
	}

	public void setValue(Value<?> value) {
		this.value = value;
	}

}
