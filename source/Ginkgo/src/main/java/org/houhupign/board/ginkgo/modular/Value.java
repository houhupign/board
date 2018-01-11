package org.houhupign.board.ginkgo.modular;

public class Value<T> {
	
	private T data;
	private String displayType;
	
	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public String getDisplayType() {
		return displayType;
	}

	public void setDisplayType(String displayType) {
		this.displayType = displayType;
	}
	
}
