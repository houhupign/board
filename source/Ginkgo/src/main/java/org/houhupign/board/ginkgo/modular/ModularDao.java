package org.houhupign.board.ginkgo.modular;

/**
 * 
 * @author houhuping
 *
 */
public interface ModularDao { 
	
	/**
	 * 
	 * @param modular
	 * @return
	 */
	public Long createModular(AbstractModular modular);
	
	/**
	 * 
	 * @param id
	 * @return
	 */
	public String queryModularTemplate(Long id);
	
	
	/**
	 * 
	 * @param modularNumber
	 * @return
	 */
	public String queryModularTemplate(String modularNumber);
}
