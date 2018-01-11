package org.houhupign.board.ginkgo.util.sql;

import java.sql.PreparedStatement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Component;

import com.mysql.jdbc.Statement;

/**
 * 通用数据库操作集合
 * @author houhupign
 *
 */
@Component
public class CommonDataBaseOperationTools {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	/**
	 * @param sql语句字符串
	 * @param PreparedStatementSetter
	 * @return 主键
	 */
	public Long insert(String sql,PreparedStatementSetter psSetter){
		
		KeyHolder keyHolder = new GeneratedKeyHolder();
		
		PreparedStatementCreator psc = con -> {
			PreparedStatement ps = con.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
			psSetter.setValues(ps);
			return ps;
		};
		
		jdbcTemplate.update(psc,keyHolder);
		
		return keyHolder.getKey().longValue();
	}
}
