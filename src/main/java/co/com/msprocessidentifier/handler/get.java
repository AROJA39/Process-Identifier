package co.com.msprocessidentifier.handler;

import java.util.List;
import java.util.Map;

import org.json.JSONObject;

import co.com.msprocessidentifier.data.extraction.InitService;
import co.com.msprocessidentifier.objects.BaseObject;
import io.javalin.http.ContentType;
import io.javalin.http.Context;
import io.javalin.http.Handler;

public class get implements Handler {
	
	public InitService initService = new InitService();

	@Override
	public void handle(Context ctx) throws Exception {
		Map<String, List<String>> params = ctx.queryParamMap();
		BaseObject baseObject = initService.transactionClassification(params);
		JSONObject jsonObject = new JSONObject(baseObject);
		ctx.contentType(ContentType.APPLICATION_JSON);
		ctx.result(jsonObject.toString());

	}

}
