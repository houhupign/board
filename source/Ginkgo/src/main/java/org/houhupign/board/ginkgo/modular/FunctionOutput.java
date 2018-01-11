package org.houhupign.board.ginkgo.modular;

import java.util.List;

public class FunctionOutput {
	private Long id;
	private Long functionId;
	private Integer resultCode;
	private String resultDesc;
	private List<FunctionOutputItem> outItems;

	public Integer getResultCode() {
		return resultCode;
	}

	public void setResultCode(Integer resultCode) {
		this.resultCode = resultCode;
	}

	public String getResultDesc() {
		return resultDesc;
	}

	public void setResultDesc(String resultDesc) {
		this.resultDesc = resultDesc;
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

	public List<FunctionOutputItem> getOutItems() {
		return outItems;
	}

	public void setOutItems(List<FunctionOutputItem> outItems) {
		this.outItems = outItems;
	}
}
