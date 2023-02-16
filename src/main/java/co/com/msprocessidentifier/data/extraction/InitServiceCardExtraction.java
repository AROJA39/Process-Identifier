package co.com.msprocessidentifier.data.extraction;

import java.util.HashMap;
import java.util.Objects;

import org.apache.commons.validator.routines.checkdigit.LuhnCheckDigit;

import co.com.msprocessidentifier.constants.Constants;
import co.com.msprocessidentifier.data.business.InitServiceFieldBusiness;
import co.com.msprocessidentifier.objects.BaseObject;
import co.com.msprocessidentifier.support.GetFileData;
import co.com.msprocessidentifier.support.ValidateDates;

/* 
 * Class in charge of logic related to present card with bin of 6 or 8
 */
public class InitServiceCardExtraction {

	public InitServiceFieldBusiness extraction = new InitServiceFieldBusiness();
	public static HashMap<String, String> responseInfoData = new HashMap<>();

	/*
	 * Method in charge card validation with lunh library
	 */
	public BaseObject bussinessRules(HashMap<String, String> responseInfo) {
		responseInfo.clear();
		String status = responseInfo.get(Constants.STATUS_VALIDATE);
		if (status.equals(Constants.CODE_SUCCESS)) {
			Boolean num = responseInfo.get(Constants.CODE_PAN).matches(Constants.REGEX);
			Boolean date = ValidateDates.dateValidation(responseInfo.get(Constants.CODE_EXPIRATION));
			if (num && date) {
				LuhnCheckDigit luhn = new LuhnCheckDigit();
				boolean val = (luhn.isValid(responseInfo.get(Constants.CODE_PAN)));
				if (val) {
					responseInfo.put("VALIDATE_CARD", Constants.VALID);
					responseInfo.put(Constants.PRESENT, "PRESENT");
				}
			}
		}
		return new BaseObject(responseInfo);
	}

	/*
	 * Method of partitioning field 35 for information management when the Visa or
	 * Master card is present.
	 */
	public BaseObject validateDataCard(HashMap<String, String> request_trx) {
		responseInfoData = new HashMap<>();
		String field35 = request_trx.get(Constants.FIELD_35);
		responseInfoData = extraction.validationFieldP3And102And126Extraction(request_trx);
		responseInfoData = extraction.validationFields103(request_trx);
		responseInfoData.put(Constants.BIN,
				(field35.length() == 37) ? field35.substring(0, 6) : field35.substring(0, 8));

		if (responseInfoData.containsKey(Constants.DESCRIPTION_ERROR)) {
			return new BaseObject(responseInfoData);
		} else if (Objects.nonNull(
				new GetFileData().getFileAndSearchData(responseInfoData.get(Constants.BIN), Constants.FILEBINES))) {
			responseInfoData.put(Constants.CARD_NUMBER,
					(field35.length() == 37) ? field35.substring(6, 16) : field35.substring(8, 18));
			responseInfoData.put(Constants.DELIMITERS,
					(field35.length() == 37) ? field35.substring(16, 17) : field35.substring(18, 19));
			responseInfoData.put(Constants.CODE_EXPIRATION,
					(field35.length() == 37) ? field35.substring(17, 21) : field35.substring(19, 23));
			responseInfoData.put(Constants.SERVICES_CODE,
					(field35.length() == 37) ? field35.substring(21, 24) : field35.substring(23, 26));
			responseInfoData.put(Constants.FILLER_1,
					(field35.length() == 37) ? field35.substring(24, 29) : field35.substring(26, 31));
			responseInfoData.put(Constants.CVV2,
					(field35.length() == 37) ? field35.substring(29, 32) : field35.substring(31, 34));
			responseInfoData.put(Constants.FILLER_2,
					(field35.length() == 37) ? field35.substring(32, 37) : field35.substring(34, 39));
			responseInfoData.put(Constants.CODE_PAN,
					(field35.length() == 37) ? field35.substring(0, 16) : field35.substring(0, 18));
			responseInfoData.put(Constants.STATUS_VALIDATE, Constants.CODE_SUCCESS);

		} else {
			responseInfoData.put(Constants.STATUS_VALIDATE, Constants.CODE_FAILED);
			responseInfoData.put(Constants.DESCRIPTION_ERROR, Constants.BIN_NOT_FOUND);
			return new BaseObject(responseInfoData);
		}
		return bussinessRules(responseInfoData);
	}
}
