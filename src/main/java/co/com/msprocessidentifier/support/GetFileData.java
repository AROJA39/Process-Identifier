package co.com.msprocessidentifier.support;
import java.util.concurrent.ConcurrentHashMap;

import com.google.gson.Gson;

public class GetFileData {
	
	public static String getFileAndSearchData(String data, String file) {
		try {
			StringBuilder result = (StringBuilder) new GetDataFile().getDataFile(file);
			ConcurrentHashMap<String, String> prepareCode = new Gson().fromJson(result.toString(), ConcurrentHashMap.class);
			if (prepareCode.containsKey(data)) {
				return prepareCode.get(data);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}
}
