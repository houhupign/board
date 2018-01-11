package org.houhupign.board.ginkgo.modular;

import org.houhupign.board.ginkgo.util.sql.CommonDataBaseOperationTools;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.stereotype.Component;

@Component
public class FunctionDaoImpl implements FunctionDao {
	
	@Autowired
	private CommonDataBaseOperationTools commonDataBaseOperationTools;
	
	@Override
	public Long createFunction(Function function) {
		
		String sql = "insert into `function` (`modular_id`, `function_number`, `function_name`) values (?, ?, ?)";
		PreparedStatementSetter pss = ps -> {
			ps.setLong(1, function.getModularId());
			ps.setString(2, function.getFunctionNumber());
			ps.setString(3, function.getFunctionName());
		};
		
		return commonDataBaseOperationTools.insert(sql, pss);
	}
}
