package utils;

import java.text.SimpleDateFormat;
import java.util.Date;

import net.sf.json.JsonConfig;
import net.sf.json.processors.JsonValueProcessor;

public class DateJsonValueProcessor implements JsonValueProcessor {

	private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	public Object processArrayValue(Object arg0, JsonConfig arg1) {
		return this.process(arg0);
	}

	public Object processObjectValue(String arg0, Object arg1, JsonConfig arg2) {
		return this.process(arg1);
	}

	// 处理Date类型返回的Json数值
	private Object process(Object value) {
		if (value == null) {
			return "";
		}else if (value instanceof Date)
			return sdf.format((Date) value);
		else {
			return value.toString();
		}
	}
	
	public DateJsonValueProcessor() {}
	public DateJsonValueProcessor(String format) {
		sdf = new SimpleDateFormat(format);
	}
	
}
