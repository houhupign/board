package org.houhupign.board.ginkgo.modular;

import java.util.List;

/**
 * 
 * @author houhupign
 *
 */
public interface FunctionInputItemDao {
	
	/**
	 * 
	 * @param functionInputItem
	 * @return
	 */
	public Long createFunctionInputItem(FunctionInputItem functionInputItem);
	
	public List<FunctionInputItem> queryByFunctionInputId(Long functionInputId);
}
