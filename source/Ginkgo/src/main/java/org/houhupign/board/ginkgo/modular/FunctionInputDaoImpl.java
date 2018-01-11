package org.houhupign.board.ginkgo.modular;

import org.houhupign.board.ginkgo.util.sql.CommonDataBaseOperationTools;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.stereotype.Component;

@Component
public class FunctionInputDaoImpl implements FunctionInputDao {

	@Autowired
	private CommonDataBaseOperationTools commonDataBaseOperationTools;
	
	@Override
	public Long createFunctionInput(FunctionInput functionInput) {
		
		String sql = "insert into `function_input` (`function_id`) values (?)";
		
		PreparedStatementSetter pss = ps -> {
			ps.setLong(1, functionInput.getFunctionId());
		};
		
		return commonDataBaseOperationTools.insert(sql, pss);
		
	}

}
