package org.houhupign.board.ginkgo.modular;

import java.util.ArrayList;
import java.util.List;

import org.houhupign.board.ginkgo.util.sql.CommonDataBaseOperationTools;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.jdbc.core.ResultSetExtractor;
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

	@Override
	public List<Function> queryByModularNumber(String modularNumber) {
		
		String sql = "select id,modular_id,function_number,function_name from `function` t where t.function_number = ?";
		PreparedStatementSetter pss = ps -> {
			ps.setString(1, modularNumber);
		};
		
		ResultSetExtractor<List<Function>> rse = rs ->{
			
			if(null == rs){
				return null;
			}
			
			List<Function> result = new ArrayList<>();
			while(rs.next()){
				Function f = new Function();
				f.setFunctionName(rs.getString("function_name"));
				f.setFunctionNumber(rs.getString("function_number"));
				f.setId(rs.getLong("id"));
				f.setModularId(rs.getLong("modular_id"));
				result.add(f);
			}
			
			return result;
		};
		return commonDataBaseOperationTools.select(sql, pss, rse);
		
	}
}
