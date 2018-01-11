package org.houhupign.board.ginkgo.modular;

import org.houhupign.board.ginkgo.util.sql.CommonDataBaseOperationTools;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.stereotype.Component;

@Component
public class FunctionOutputItemDaoImpl implements FunctionOutputItemDao {
	
	@Autowired
	private CommonDataBaseOperationTools commonDataBaseOperationTools;
	
	@Override
	public <T> Long createFunctionOutputItem(FunctionOutputItem functionOutputItem) {
		
		String sql = "insert into `function_output_item` (`function_output_id`, `name`) values (?, ?)";
		
		PreparedStatementSetter pss = ps -> {
			ps.setLong(1, functionOutputItem.getFunctionOutputId());
			ps.setString(2, functionOutputItem.getName());
		};
		
		return commonDataBaseOperationTools.insert(sql, pss);
	}

}
