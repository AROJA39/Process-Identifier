package co.com.msprocessidentifier.support;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import co.com.msprocessidentifier.constants.Constants;



public class GetDataFile {

	public Object getDataFile(String file) throws Exception {
		StringBuilder resultado = new StringBuilder();
		URL url = new URL(Constants.ENDPOINTFILE+file);
		HttpURLConnection conexion = (HttpURLConnection) url.openConnection();
		conexion.setRequestMethod("GET");
		BufferedReader reader = new BufferedReader(new InputStreamReader(conexion.getInputStream()));
		String linea;
		while ((linea = reader.readLine()) != null) {
			resultado.append(linea);
		}
		reader.close();
		return resultado;
	}
}
