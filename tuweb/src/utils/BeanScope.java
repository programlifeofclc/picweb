package utils;

import java.util.List;

/**
 * bean类 数据存储
 * @author clc
 */
public class BeanScope {

	public List<?> listValue;

	public String returnString;
	
	public List<?> getListValue() {
		return listValue;
	}
	public void setListValue(List<?> listValue) {
		this.listValue = listValue;
	}
	public String getReturnString() {
		return returnString;
	}
	public void setReturnString(String returnString) {
		this.returnString = returnString;
	}
	
}
