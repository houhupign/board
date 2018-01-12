package org.houhupign.board.ginkgo.modular;

import org.houhupign.board.ginkgo.util.sql.CommonDataBaseOperationTools;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Component;

@Component
public class ModularDaoImpl implements ModularDao {
	
	@Autowired
	private CommonDataBaseOperationTools commonDataBaseOperationTools;
	
	@Override
	public Long createModular(AbstractModular modular) {
		
		String sql = "insert into `modular` (`modular_number`, `modular_ame`, `icon`, `templatName`) values (?, ?, ?,?)";
		
		PreparedStatementSetter pss = ps -> {
			ps.setString(1, modular.getModularNumber());
			ps.setString(2, modular.getModularName());
			ps.setString(3, modular.getIcon());
			ps.setString(4, modular.getTemplateName());
		};
		
		return commonDataBaseOperationTools.insert(sql, pss);
	}

	@Override
	public String queryModularTemplate(String modularNumber) {
		
		String sql = "select id,modular_number,modular_ame,icon,templatName from modular t where t.modular_number = ?";
		PreparedStatementSetter pss = ps -> {
			ps.setString(1, modularNumber);
		};
		
		ResultSetExtractor<String> rse = rs ->{
			
			if(null == rs){
				return null;
			}
			
			String templateName = null;
			if(rs.next()){
				templateName = rs.getString("templatName");
			}
			return templateName;
		};
		return commonDataBaseOperationTools.select(sql, pss, rse);
		
	}
	
	@Override
	public String queryModularTemplate(Long id) {
		
		String sql = "select id,modular_number,modular_ame,icon,templatName from modular t where t.id = ?";
		PreparedStatementSetter pss = ps -> {
			ps.setLong(1, id);
		};
		
		ResultSetExtractor<String> rse = rs ->{
			
			if(null == rs){
				return null;
			}
			
			String templateName = null;
			if(rs.next()){
				templateName = rs.getString("templatName");
			}
			return templateName;
		};
		return commonDataBaseOperationTools.select(sql, pss, rse);
		
	}
	
}
