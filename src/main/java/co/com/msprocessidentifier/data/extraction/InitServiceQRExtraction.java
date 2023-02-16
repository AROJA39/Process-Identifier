package co.com.msprocessidentifier.data.extraction;

import java.util.HashMap;
import java.util.Objects;

import co.com.msprocessidentifier.constants.Constants;
import co.com.msprocessidentifier.data.business.InitServiceFieldBusiness;
import co.com.msprocessidentifier.objects.BaseObject;
import co.com.msprocessidentifier.support.GetFileData;

public class InitServiceQRExtraction {
	
	public InitServiceFieldBusiness extraction = new InitServiceFieldBusiness();
	public static HashMap<String, String> responseInfoData = new HashMap<>();

	/*
	 * Method of partitioning field 35 for information management when the card is
	 * not present.
	 */
	public BaseObject validateDataQR(HashMap<String, String> request) {
		responseInfoData.clear();
		String field35 = request.get(Constants.FIELD_35);
		responseInfoData = extraction.validationFieldP3And102And126Extraction(request);
		responseInfoData = extraction.validationFields103(request);
		responseInfoData.put(Constants.BIN, field35.substring(0, 6));
		if(responseInfoData.containsKey(Constants.DESCRIPTION_ERROR)) {
			return new BaseObject(responseInfoData);
		}else if (Objects.nonNull(new GetFileData().getFileAndSearchData(responseInfoData.get(Constants.BIN), Constants.FILEBINES))) {
			responseInfoData.put(Constants.ACCOUNT_NUMBER, field35.substring(6, 24));
			responseInfoData.put(Constants.DELIMITERS, field35.substring(24, 25));
			responseInfoData.put(Constants.CODE_EXPIRATION, field35.substring(25, 29));
			responseInfoData.put(Constants.FILLER_1, field35.substring(29, 37));
			responseInfoData.put(Constants.STATUS_VALIDATE, Constants.CODE_SUCCESS);
			responseInfoData.put(Constants.PRESENT, "NOT PRESENT");
		} else {
			responseInfoData.put(Constants.STATUS_VALIDATE, Constants.CODE_FAILED);
			responseInfoData.put(Constants.DESCRIPTION_ERROR, Constants.BIN_NOT_FOUND);
			return new BaseObject(responseInfoData);
		}
		return new BaseObject(responseInfoData);
	}
}
