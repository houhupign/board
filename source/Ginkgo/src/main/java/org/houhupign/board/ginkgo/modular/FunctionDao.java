package org.houhupign.board.ginkgo.modular;

import java.util.List;

public interface FunctionDao {
	
	/**
	 * @param function 功能表数据对象
	 * @return 主键ID
	 */
	public Long createFunction(Function function);
	
	/**
	 * 根据模块编号查询模块下的所有功能
	 * @param modularNumber 模块编号
	 * @return Function 列表
	 */
	public List<Function> queryByModularNumber(String modularNumber);
	
}
