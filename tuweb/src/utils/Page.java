package utils;

import java.util.Date;
import java.util.List;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;
import net.sf.json.processors.JsonValueProcessor;

public class Page {
	private int pageNumber = 1;//当前页数
	private int pageSize = 10;//每页条数
	private int counts = 0;//总条数
	private List<?> rows;
	public Page(){};
	
	public Page(int pageNumber,int pageSize,int counts){
		this.pageNumber = pageNumber==0?1:pageNumber;
		this.pageSize = pageSize==0?10:pageSize;
		this.counts = counts;
	}
	
	public int getStartRow(){
		return (pageNumber-1)*pageSize;
	}
	
	public int getPageNumber() {
		return pageNumber;
	}
	public void setPageNumber(int pageNumber) {
		this.pageNumber = pageNumber;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public int getCounts() {
		return counts;
	}
	public void setCounts(int counts) {
		this.counts = counts;
	}
	
	public List<?> getRows() {
		return rows;
	}
	public void setRows(List<?> rows) {
		this.rows = rows;
	}
	
	
	
	public EasyUIPage getUIPage(){
		return new EasyUIPage(pageNumber,pageSize,counts,rows);
	}
	
	/**
     * 转换json格式的方法
     * @param objecMap Map对象
     * @return
     */
    public String getMapJsonString(Object objectMap){
    	JsonValueProcessor jsonProcessor = new DateJsonValueProcessor();
		JsonConfig jsonConfig = new JsonConfig(); 
		jsonConfig.registerJsonValueProcessor(Date.class, jsonProcessor);
		JSONObject json = JSONObject.fromObject(objectMap,jsonConfig);
        return json.toString();
    }
    
    /**
     * 转换json格式的方法
     * @param objectList list对象
     * @return
     */
    public String getJsonString(Object objectList){
    	JsonValueProcessor jsonProcessor = new DateJsonValueProcessor();
		JsonConfig jsonConfig = new JsonConfig(); 
		jsonConfig.registerJsonValueProcessor(Date.class, jsonProcessor);
		JSONArray json = JSONArray.fromObject(objectList,jsonConfig);
        return json.toString();
    }
    
    /**
     * 转换json格式的方法
     * @param objectList list对象
     * @param format  时间样式 例如:yyyy-MM-dd
     * @return
     */
    public String getJsonString(Object objectList,String format){
    	JsonValueProcessor jsonProcessor = new DateJsonValueProcessor(format);
		JsonConfig jsonConfig = new JsonConfig(); 
		jsonConfig.registerJsonValueProcessor(Date.class, jsonProcessor);
		JSONArray json = JSONArray.fromObject(objectList,jsonConfig);
        return json.toString();
    }
    
    /**
     * 当使用easy-ui的分页方法时候使用
     * @param objectList
     * @return
     */
    public String getPageJsonString(Object objectList){
    	String json = this.getJsonString(objectList);
		return json;
    }
    
    /**
     * 当使用easy-ui的分页方法时候使用
     * @param objectList list数据
     * @param format 例如:yyyy-MM-dd
     * @return
     */
    public String getPageJsonString(Object objectList,String format){
    	String json = this.getJsonString(objectList,format);
		return json;
    }
    
}
