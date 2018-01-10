package org.houhupign.board.ginkgo.modular;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;

public abstract class AbstractModular implements Modular{
	
	@Autowired
    private JdbcTemplate jdbcTemplate; 
	
	//ID
	private Long id;
	
	//模块编号
	private String modularNumber;
	
	//模块名称
	private String modularName;
	
	//模块图标路径
	private String icon;
	
	//模块功能集合
	private Map<Function,Service> functions;
	
	//模块GUI类型
	private String guiType;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getModularNumber() {
		return modularNumber;
	}

	public void setModularNumber(String modularNumber) {
		this.modularNumber = modularNumber;
	}

	public String getModularName() {
		return modularName;
	}

	public void setModularName(String modularName) {
		this.modularName = modularName;
	}

	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}
	
	public Map<Function, Service> getFunctions() {
		return functions;
	}

	public void setFunctions(Map<Function, Service> functions) {
		this.functions = functions;
	}

	public String getGuiType() {
		return guiType;
	}

	public void setGuiType(String guiType) {
		this.guiType = guiType;
	}

	@Override
	@Transactional
	@PostConstruct
	public void register() {
		System.out.println("============================");
		init();
		
		//保存到数据库
		String sql = "insert into `modular` (`id`, `modular_number`, `modular_ame`, `icon`) values (?, ?, ?, ?)";
		final AbstractModular m = this;
		this.jdbcTemplate.update(sql,new PreparedStatementSetter(){
			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				ps.setLong(1, m.getId());
				ps.setString(2, m.getModularNumber());
				ps.setString(3,m.getModularName());
				ps.setString(4,m.getIcon());
			}
		});
		
		addFunctiones();
		
		
	}
	
	@Override
	public String display() {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public FunctionOutput execute(String modeular, FunctionInput inputes) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void destory() {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public abstract void init();
	
	@Override
	public abstract void addFunctiones();
	
}
