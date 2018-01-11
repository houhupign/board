package org.houhupign.board.ginkgo.modular;

import org.houhupign.board.ginkgo.util.sql.CommonDataBaseOperationTools;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.stereotype.Component;

@Component
public class ModularDaoImpl implements ModularDao {
	
	@Autowired
	private CommonDataBaseOperationTools commonDataBaseOperationTools;
	
	@Override
	public Long createModular(AbstractModular modular) {
		
		String sql = "insert into `modular` (`modular_number`, `modular_ame`, `icon`) values (?, ?, ?)";
		
		PreparedStatementSetter pss = ps -> {
			ps.setString(1, modular.getModularNumber());
			ps.setString(2, modular.getModularName());
			ps.setString(3, modular.getIcon());
		};
		
		return commonDataBaseOperationTools.insert(sql, pss);
	}

}
