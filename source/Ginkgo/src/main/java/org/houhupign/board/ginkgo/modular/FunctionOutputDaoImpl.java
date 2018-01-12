package org.houhupign.board.ginkgo.modular;

import org.houhupign.board.ginkgo.util.sql.CommonDataBaseOperationTools;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.jdbc.core.ResultSetExtractor;
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

	@Override
	public FunctionOutput queryByFunctionId(Long functionId) {
		
		String sql = "select id,function_id from function_output t where t.function_id = ?";
		PreparedStatementSetter pss = ps -> {
			ps.setLong(1, functionId);
		};
		
		ResultSetExtractor<FunctionOutput> rse = rs ->{
			
			if(null == rs){
				return null;
			}
			
			FunctionOutput f = new FunctionOutput();
			if(rs.next()){
				f.setId(rs.getLong("id"));
				f.setFunctionId(rs.getLong("function_id"));
			}
			
			return f;
		};
		
		return commonDataBaseOperationTools.select(sql, pss, rse);
	}

}
