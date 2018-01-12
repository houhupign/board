package org.houhupign.board.ginkgo.modular;

/**
 * 
 * @author houhupign
 *
 */
public interface FunctionInputDao {
	
	/**
	 * 
	 * @param functionInput
	 * @return 主键ID
	 */
	public Long createFunctionInput(FunctionInput functionInput);
	
	/**
	 * 根据functionId查询功能输入
	 * @param functionId
	 * @return
	 */
	public FunctionInput queryByFunctionId(Long functionId);
}
