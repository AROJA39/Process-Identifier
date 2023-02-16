package co.com.msprocessidentifier.data.extraction;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import co.com.msprocessidentifier.constants.Constants;
import co.com.msprocessidentifier.objects.BaseObject;

public class InitService {

	public static HashMap<String, String> trx = new HashMap<String, String>();

	public InitServiceCardExtraction cardExtraction = new InitServiceCardExtraction();
	public InitServicePseudobinExtraction pseudobinExtraction = new InitServicePseudobinExtraction();
	public InitServiceQRExtraction qrExtraction = new InitServiceQRExtraction();
	
	public HashMap<String, String> convertHashMap(Map<String, List<String>> ctx) {
		ctx.forEach((key,value) -> trx.put(key, value.get(0)));
		return trx;
	}

	public BaseObject transactionClassification(Map<String, List<String>> request) {
		BaseObject response = null;
		HashMap<String, String> map = convertHashMap(request);
		String field35 = map.get(Constants.FIELD_35);
		switch (field35.substring(0, 1)) {
		case "4":
		case "5":
			response = cardExtraction.validateDataCard(map);
			break;
		case "7":
		case "8":
			response = pseudobinExtraction.validateDataBin(map);
			break;
		case "0":
			response = qrExtraction.validateDataQR(map);
			break;
		}
		return response;
	}
}
