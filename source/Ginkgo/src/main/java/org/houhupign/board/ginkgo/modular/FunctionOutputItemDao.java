package org.houhupign.board.ginkgo.modular;

import java.util.List;

/**
 * 
 * @author houhupign
 *
 */
public interface FunctionOutputItemDao {
	
	/**
	 * 
	 * @param functionOutputItem
	 * @return
	 */
	public Long createFunctionOutputItem(FunctionOutputItem functionOutputItem);
	
	/**
	 * 
	 * @param functionOutputId
	 * @return
	 */
	public List<FunctionOutputItem> queryByFunctionOutputId(Long functionOutputId);
}
