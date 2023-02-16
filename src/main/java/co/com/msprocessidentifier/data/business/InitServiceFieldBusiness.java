package co.com.msprocessidentifier.data.business;


import java.util.HashMap;
import java.util.Objects;

import co.com.msprocessidentifier.constants.Constants;
import co.com.msprocessidentifier.support.GetFileData;

public class InitServiceFieldBusiness {
	
	public HashMap<String, String> responseMap = new HashMap<>();

	public HashMap<String, String> validationFieldP3And102And126Extraction(HashMap<String, String> info_tx){
		responseMap.put(Constants.CODE_PROCESS, info_tx.get(Constants.FIELD_P3));
		String processCode = GetFileData.getFileAndSearchData(info_tx.get(Constants.FIELD_P3), Constants.FILECODE);
		String field126 = info_tx.get(Constants.FIELD_126);
		if (Objects.isNull(processCode)) {
			responseMap.clear();
			responseMap.put(Constants.STATUS_VALIDATE, Constants.CODE_FAILED);
			responseMap.put(Constants.DESCRIPTION_ERROR, Constants.CODE_NOT_FOUND);
			return responseMap;
		}
		responseMap.put(Constants.DEBIT_ACCOUNT, info_tx.get(Constants.FIELD_102));
		responseMap.put(Constants.OPERATION_TYPE, field126.contains(info_tx.get(Constants.FIELD_P3)) ? "MONETARIA" : "CONSULTA");
		return responseMap;
	}
	
	public HashMap<String, String> validationFields103(HashMap<String, String> info_tx){
		responseMap.put(Constants.MOVEMENT_TYPE, GetFileData.getFileAndSearchData(info_tx.get(Constants.FIELD_103).substring(2, 3), Constants.FILEINFOAPOYO));
		if (responseMap.get(Constants.MOVEMENT_TYPE).equals(Constants.MOVOMENT_NOT_VALID)) {
			responseMap.clear();
			responseMap.put(Constants.STATUS_VALIDATE, Constants.CODE_FAILED);
			responseMap.put(Constants.DESCRIPTION_ERROR, Constants.MOVOMENT_NOT_VALID);
			return responseMap;
		}
		responseMap.put(Constants.ACCOUNT_TO_CREDIT, info_tx.get(Constants.FIELD_103).substring(7, 23));
		return responseMap;
	}
	
	public HashMap<String, String> getClassification(String bin){
		String clasification = GetFileData.getFileAndSearchData(bin, Constants.FILEBINES);
		if (Objects.nonNull(clasification)) {
			responseMap.put(Constants.CLASIFICACION, clasification);
		}
		return responseMap;
	}
}
