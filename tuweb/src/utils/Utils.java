package utils;

import java.util.List;

public class Utils {
	
	/**
	 * checkNotNull
	 * @param o
	 * @return
	 */
	public static boolean checkNN(String o){
		if(o == null)return false;
		if(o.equals("")) return false;
		return true;
	}
	
	public static boolean checkNNList(List<?> o){
		if(o == null)return false;
		if(o.size()==0) return false;
		return true;
	}
	
	public static boolean checkNNArr(Object[] o){
		if(o == null)return false;
		if(o.length==0) return false;
		return true;
	}
}
