package org.houhupign.board.ginkgo.modular;

import java.util.ArrayList;
import java.util.List;

import org.houhupign.board.ginkgo.util.sql.CommonDataBaseOperationTools;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Component;

@Component
public class FunctionInputItemDaoImpl implements FunctionInputItemDao{

	@Autowired
	private CommonDataBaseOperationTools commonDataBaseOperationTools;
	
	@Override
	public Long createFunctionInputItem(FunctionInputItem functionInputItem) {
		
		String sql = "insert into `function_input_item` (`function_input_id`, `name`) values (?, ?)";
		
		PreparedStatementSetter pss = ps -> {
			ps.setLong(1, functionInputItem.getFunctionInputId());
			ps.setString(2, functionInputItem.getName());
		};
		
		return commonDataBaseOperationTools.insert(sql, pss);
		
	}

	@Override
	public List<FunctionInputItem> queryByFunctionInputId(Long functionInputId) {
		
		String sql = "select id,function_input_id,name from function_input_item t where t.function_input_id = ?";
		PreparedStatementSetter pss = ps -> {
			ps.setLong(1, functionInputId);
		};
		
		ResultSetExtractor<List<FunctionInputItem>> rse = rs ->{
			
			if(null == rs){
				return null;
			}
			
			List<FunctionInputItem> result = new ArrayList<>();
			while(rs.next()){
				FunctionInputItem f = new FunctionInputItem();
				f.setId(rs.getLong("id"));
				f.setFunctionInputId(rs.getLong("function_input_id"));
				f.setName(rs.getString("name"));
				result.add(f);
			}
			
			return result;
		};
		
		return commonDataBaseOperationTools.select(sql, pss, rse);
		
	}

}
