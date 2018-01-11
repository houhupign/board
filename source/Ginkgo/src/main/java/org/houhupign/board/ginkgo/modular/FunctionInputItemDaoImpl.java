package org.houhupign.board.ginkgo.modular;

import org.houhupign.board.ginkgo.util.sql.CommonDataBaseOperationTools;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.stereotype.Component;

@Component
public class FunctionInputItemDaoImpl implements FunctionInputItemDao{

	@Autowired
	private CommonDataBaseOperationTools commonDataBaseOperationTools;
	
	@Override
	public <T> Long createFunctionInputItem(FunctionInputItem functionInputItem) {
		
		String sql = "insert into `function_input_item` (`function_input_id`, `name`) values (?, ?)";
		
		PreparedStatementSetter pss = ps -> {
			ps.setLong(1, functionInputItem.getFunctionInputId());
			ps.setString(2, functionInputItem.getName());
		};
		
		return commonDataBaseOperationTools.insert(sql, pss);
		
	}

}
