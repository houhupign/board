package org.houhupign.board.ginkgo.modular;

public class Function {
	
	private Long id;
	private Long modularId;
	private String functionNumber;
	private String functionName;
	private FunctionInput input;
	private FunctionOutput output;
	
	public Function(String functionNumber, String functionName) {
		this.functionNumber = functionNumber;
		this.functionName = functionName;
	}

	public Function() {
		
	}
	
	public Long getModularId() {
		return modularId;
	}

	public void setModularId(Long modularId) {
		this.modularId = modularId;
	}

	public String getFunctionName() {
		return functionName;
	}

	public void setFunctionName(String functionName) {
		this.functionName = functionName;
	}

	public FunctionInput getInput() {
		return input;
	}

	public void setInput(FunctionInput input) {
		this.input = input;
	}

	public FunctionOutput getOutput() {
		return output;
	}

	public void setOutput(FunctionOutput output) {
		this.output = output;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFunctionNumber() {
		return functionNumber;
	}

	public void setFunctionNumber(String functionNumber) {
		this.functionNumber = functionNumber;
	}
}
