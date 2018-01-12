package org.houhupign.board.ginkgo.modular;

import java.util.ArrayList;
import java.util.List;

import org.houhupign.board.ginkgo.util.sql.CommonDataBaseOperationTools;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Component;

@Component
public class FunctionOutputItemDaoImpl implements FunctionOutputItemDao {
	
	@Autowired
	private CommonDataBaseOperationTools commonDataBaseOperationTools;
	
	@Override
	public Long createFunctionOutputItem(FunctionOutputItem functionOutputItem) {
		
		String sql = "insert into `function_output_item` (`function_output_id`, `name`) values (?, ?)";
		
		PreparedStatementSetter pss = ps -> {
			ps.setLong(1, functionOutputItem.getFunctionOutputId());
			ps.setString(2, functionOutputItem.getName());
		};
		
		return commonDataBaseOperationTools.insert(sql, pss);
	}

	@Override
	public List<FunctionOutputItem> queryByFunctionOutputId(Long functionOutputId) {
		
		String sql = "select id,function_out_id,name from function_input_item t where t.function_out_id = ?";
		PreparedStatementSetter pss = ps -> {
			ps.setLong(1, functionOutputId);
		};
		
		ResultSetExtractor<List<FunctionOutputItem>> rse = rs ->{
			
			if(null == rs){
				return null;
			}
			
			List<FunctionOutputItem> result = new ArrayList<>();
			while(rs.next()){
				FunctionOutputItem f = new FunctionOutputItem();
				f.setId(rs.getLong("id"));
				f.setFunctionOutputId(rs.getLong("function_out_id"));
				f.setName(rs.getString("name"));
				result.add(f);
			}
			
			return result;
		};
		
		return commonDataBaseOperationTools.select(sql, pss, rse);
	}

}
