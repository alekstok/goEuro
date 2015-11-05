package utilities;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;

public class ApiWithEndpointUser {

	private static String endpointAddress = "http://api.goeuro.com/api/v2/position/suggest/en/";

	/**
	 * @param cityName
	 *            name of the city, which should be used in the endpoint
	 * @return jsonContent String with json's content
	 * @throws IOException
	 */
	public String getJsonWithEndpoint(String cityName) throws IOException {

		String line;
		String jsonContent ="";
		String apiUrlWithCity = endpointAddress + cityName;

		URL url = new URL(apiUrlWithCity);
		InputStream input = url.openStream();
		InputStreamReader inputReader = new InputStreamReader(input);
		BufferedReader bufInput = new BufferedReader(inputReader);
		
		line = bufInput.readLine();
		while (line != null) {
			jsonContent += line;
			line = bufInput.readLine();
		}

		input.close();

		return jsonContent;
	}
}
