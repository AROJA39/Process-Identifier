package co.com.msprocessidentifier.constants;

public class Constants {
	
	public static final String KEY_PARAMETER = "JSON";
	public static final String FILECODE = "CODIGOPROCESO";
	public static final String ENDPOINTFILE = "http://10.94.81.243:8085/get?JSON=";
	public static final String FILEBINES = "BINES";
	public static final String FILEINFOAPOYO = "INFOAPOYO";
	public static final String CLASIFICACION = "CLASIFICATION";
	public static final char ONE_CHAR = '1';
	public static final char ZERO_CHAR = '0';
	public static final String ONE = "1";
	public static final String ZERO = "0";
	public static final int BIN_START = 0;
	public static final int BIN_START_1 = 1;
	public static final int SERVER_PORT = 7777; //Se utiliza este puerto para recibir las validaciones del campo 103 de mensajerias Base 24 e ISO8583
	public static final String FIELD_35 = "FIELD_035";
	public static final String FIELD_P3 = "FIELD_003";
	public static final String FIELD_102 = "FIELD_102";
	public static final String FIELD_103 = "FIELD_103";
	public static final String FIELD_126 = "FIELD_126";
	public static final String KEY_TRANSACTION = "KEY_TRANSACTION";
	public static final String APPLY_RULES_OK = "1111111111";
	public static final String EMPTY_STRING = "";
	public static final String ENTER = "\n";
	public static final String NOT_FOUND_35 = "Field 35 not found";
	public static final String STATUS_VALIDATE = "STATUS_VALIDATE_DATA";
	public static final String CODE_SUCCESS = "SUCCESS";
	public static final String CODE_FAILED = "FAILED";
	public static final String CODE_PAN = "PAN";
	public static final String CODE_EXPIRATION = "EXPIRATION_DATE";
	public static final String VALID = "VALID CARD";
	public static final String INVALID = "INVALID CARD";
	public static final String BIN = "BIN";
	public static final String CARD = "CARD_NUMBER";
	public static final String DELIMITERS = "DELIMITER";
	public static final String SERVICES_CODE = "SERVICES_CODE";
	public static final String FILLER_1 = "FILLER_1";
	public static final String FILLER_2 = "FILLER_2";
	public static final String CVV2 = "CVV2";
	public static final String CARD_NUMBER = "CARD_NUMBER";
	public static final String ACCOUNT_NUMBER = "ACCOUNT_NUMBER";
	public static final String CLIENT_IDENTIFICATION = "CLIENT_IDENTIFICATION";
	public static final String PRESENT = "PRESENT";
	public static final String CODE_PROCESS = "CODE_PROCESS";
	public static final String NAME_PROCESS = "NAME_PROCESS";
	public static final String DEBIT_ACCOUNT = "DEBIT_ACCOUNT";
	public static final String ACCOUNT_TO_CREDIT = "ACCOUNT_TO_CREDIT";
	public static final String OPERATION_TYPE = "OPERATION_TYPE";
	public static final String MOVEMENT_TYPE = "MOVEMENT_TYPE";
	public static final String TRANSACTION_TYPE = "TRANSACTION_TYPE";
	public static final String BIN_NOT_FOUND = "Bin not found";
	public static final String CODE_NOT_FOUND = "Process code not found";
	public static final String DELIMITER_NOT_FOUND = "Field 35 without delimiter";
	public static final String BAD_REQUEST = "No parameter has been sent";
	public static final String NOT_FOUND_P3 = "Field P3 not found";
	public static final String NOT_FOUND_102 = "Field 102 not found";
	public static final String NOT_FOUND_103 = "Field 103 not found";
	public static final String NOT_FOUND_126 = "Field 126 not found";
	public static final String REQUIRED_FIELDS = "Incomplete required fields, the required fields are: FIELD_35, FIELD_P3, FIELD_102, FIELD_103, FIELD_126";
	public static final String OPERATION_NOT_VALID = "Type of operation not valid";
	public static final String MOVOMENT_NOT_VALID = "Type of movement not valid";
	
	public static final String DESCRIPTION_ERROR = "DESCRIPTION_ERROR";
	public static final String FIELD_35_LENGTH = "Field does not meet the expected length";
	
	
	public static final String ZERO_STRING_X10 = "0000000000";
	public static final String ZERO_STRING_X16 = "0000000000000000";
	
	public static final String REGEX = "[0-9]+";
}
