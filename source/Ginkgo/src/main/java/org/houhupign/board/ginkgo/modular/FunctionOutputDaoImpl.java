package org.houhupign.board.ginkgo.modular;

import org.houhupign.board.ginkgo.util.sql.CommonDataBaseOperationTools;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.stereotype.Component;

@Component
public class FunctionOutputDaoImpl implements FunctionOutputDao {

	@Autowired
	private CommonDataBaseOperationTools commonDataBaseOperationTools;
	
	@Override
	public Long createFunctionOutput(FunctionOutput functionOutPut) {
		
		String sql = "insert into `function_output` (`function_id`) values (?)";
		
		PreparedStatementSetter pss = ps -> {
			ps.setLong(1, functionOutPut.getFunctionId());
		};
		
		return commonDataBaseOperationTools.insert(sql, pss);
	}

}
