package org.houhupign.board.ginkgo.modular;

import org.houhupign.board.ginkgo.util.sql.CommonDataBaseOperationTools;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.jdbc.core.ResultSetExtractor;
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

	@Override
	public FunctionInput queryByFunctionId(Long functionId) {
		String sql = "select id,function_id from function_input t where t.function_id = ?";
		PreparedStatementSetter pss = ps -> {
			ps.setLong(1, functionId);
		};
		
		ResultSetExtractor<FunctionInput> rse = rs ->{
			
			if(null == rs){
				return null;
			}
			
			FunctionInput f = new FunctionInput();
			if(rs.next()){
				f.setId(rs.getLong("id"));
				f.setFunctionId(rs.getLong("function_id"));
			}
			
			return f;
		};
		
		return commonDataBaseOperationTools.select(sql, pss, rse);
	}

}
