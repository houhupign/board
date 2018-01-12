package org.houhupign.board.ginkgo.modular;

/**
 * 
 * @author houhupign
 *
 */
public interface FunctionOutputDao {
	
	/**
	 * 
	 * @param functionOutPut
	 * @return 主键ID
	 */
	public Long createFunctionOutput(FunctionOutput functionOutPut);
	
	
	/**
	 * 
	 * @param functionId
	 * @return
	 */
	public FunctionOutput queryByFunctionId(Long functionId);
}
