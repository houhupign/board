package org.houhupign.board.ginkgo.modular;

public interface FunctionDao {
	
	/**
	 * @param function 功能表数据对象
	 * @return 主键ID
	 */
	public Long createFunction(Function function);
	
}
