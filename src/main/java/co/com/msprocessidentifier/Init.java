package co.com.msprocessidentifier;

import io.javalin.Javalin;
import co.com.msprocessidentifier.constants.Constants;
import co.com.msprocessidentifier.handler.get;

/**
 * Master class for field management 35
 */
public class Init {

	public static void main(String[] args) {
		Javalin app = Javalin.create().start(Constants.SERVER_PORT);
		app.get("/get", new get());
	}
}