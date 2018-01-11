package org.houhupign.board.ginkgo.modular;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;

public abstract class AbstractModular implements Modular{
	
	@Autowired
	private ModularDao modularDao;
	
	@Autowired
	private FunctionDao functionDao;
	
	@Autowired
	private FunctionInputDao functionInputDao;
	
	@Autowired
	private FunctionOutputDao functionOutputDao;
	
	@Autowired
	private FunctionInputItemDao functionInputItemDao;
	
	@Autowired
	private FunctionOutputItemDao functionOutputItemDao;
	
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
	public void register() {
		
		System.out.println("============================");
		
		init();
		
        Long modularId = modularDao.createModular(this);
        
		addFunctiones();
		
		for(Function f : this.functions.keySet()){
			
			f.setModularId(modularId);
			Long functionId = functionDao.createFunction(f);
			
			FunctionInput input = f.getInput();
			input.setFunctionId(functionId);
			functionInputDao.createFunctionInput(input);
			
			List<FunctionInputItem> items = input.getInputItems();
			if(null!=items){
				for(FunctionInputItem item : items){
					if(null == item){
						continue;
					}
					item.setFunctionInputId(functionId);
					functionInputItemDao.createFunctionInputItem(item);
				}
			}
			
			FunctionOutput output = f.getOutput();
			output.setFunctionId(functionId);
			functionOutputDao.createFunctionOutput(output);
			
			List<FunctionOutputItem> outItems = output.getOutItems();
			if(null!=outItems){
				for(FunctionOutputItem outItem : outItems){
					if(null == outItem){
						continue;
					}
					outItem.setFunctionOutputId(functionId);
					functionOutputItemDao.createFunctionOutputItem(outItem);
				}
			}
		}
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
	
	protected Function createFunction(String functionNumber, String functionName,String[] functionInputItemNames,String[] functionOutputItemNames){
		
		Function addArea = new Function(functionNumber, functionName);
		
		FunctionInput addAreaInput = new FunctionInput();
		addArea.setInput(addAreaInput);
		
		List<FunctionInputItem>  items = new ArrayList<>();
		for(String inputItemName :functionInputItemNames){
			FunctionInputItem inputItem = new FunctionInputItem();
			inputItem.setName(inputItemName);
			items.add(inputItem);
		}
		addAreaInput.setInputItems(items);
		
		FunctionOutput addAreaOutput = new FunctionOutput();
		addArea.setOutput(addAreaOutput);
		
		List<FunctionOutputItem> outputItems = new ArrayList<>();
		for(String outputItemName : functionOutputItemNames){
			FunctionOutputItem outItem = new FunctionOutputItem();
			outItem.setName(outputItemName);
			outputItems.add(outItem);
		}
		addAreaOutput.setOutItems(outputItems);
		
		return addArea;
	}
}

