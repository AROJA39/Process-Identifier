package co.com.msprocessidentifier.objects;

import java.util.HashMap;

import co.com.msprocessidentifier.constants.Constants;
import lombok.Data;

@Data
public class BaseObject
{
	private String timeStart;
	private String timeEnd;
	private String inicialDate;
	private String completionDate;
	private int transactionsProcessed = 0;
	private int successfulTransactions = 0;
	private int failedTransaction = 0; 
	private HashMap<String, String> lastRequestProcessed = null;
	
	
	public BaseObject(HashMap<String, String> input){
		lastRequestProcessed = new HashMap<>();
		MonitorTime monitorTime = new MonitorTime();
		timeStart = Long.toString(monitorTime.getTimeStart());
		inicialDate = monitorTime.getInitialDate();
		lastRequestProcessed.putAll(input);
		monitorTime.timeElapsed();
		timeEnd = Long.toString(monitorTime.getTimeEnd());
		completionDate = monitorTime.getCompletionDate();
		transactionsProcessed += 1;
		successfulTransactions = input.containsValue(Constants.CODE_SUCCESS) ? ++successfulTransactions : successfulTransactions;
		failedTransaction = input.containsValue(Constants.CODE_FAILED) ? ++failedTransaction : failedTransaction;
	}
	
	
	

	

	
}
