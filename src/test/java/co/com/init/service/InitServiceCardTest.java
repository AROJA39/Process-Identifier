package co.com.init.service;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import co.com.msprocessidentifier.constants.Constants;
import co.com.msprocessidentifier.data.extraction.InitService;
import co.com.msprocessidentifier.objects.BaseObject;

class InitServiceCardTest {
	
	InitService initService;
	
	@Test
	void TestSentCorrectRequestWith8DigitBin() throws Exception {
		BaseObject baseObject = null; 
		Map<String, List<String>> params = new HashMap<String, List<String>>();
		params.put(Constants.FIELD_35, Arrays.asList("450942000010043782=23122261302177600000"));
		Assertions.assertEquals(baseObject, initService.transactionClassification(params));
		
	}
	
	@Test
	void TestSentCorrectRequestWith6DigitBin() {
		BaseObject baseObject = null; 
		Map<String, List<String>> params = new HashMap<String, List<String>>();
		params.put(Constants.KEY_TRANSACTION, Arrays.asList("0200011000"));
		params.put(Constants.FIELD_35, Arrays.asList("4509420010043782=23122261302177600000"));
		Assertions.assertEquals(baseObject, initService.transactionClassification(params));
	}
	
	@Test
	void TestSentCorrectRequestEmpty() {
		BaseObject baseObject = null; 
		Map<String, List<String>> params = new HashMap<String, List<String>>();
		Assertions.assertEquals(baseObject, initService.transactionClassification(params));
	}
	
	@Test
	void TestSentCorrectRequestWith6DigitBinCardNotPresent() {
		BaseObject baseObject = null; 
		Map<String, List<String>> params = new HashMap<String, List<String>>();
		params.put(Constants.KEY_TRANSACTION, Arrays.asList("0200011000"));
		params.put(Constants.FIELD_35, Arrays.asList("7777911102366687=99990000000000000000"));
		Assertions.assertEquals(baseObject, initService.transactionClassification(params));
	}

}
