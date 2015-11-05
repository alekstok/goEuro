package goEuro;

import utilities.ApiWithEndpointUser;
import utilities.CsvCreator;

public class GoEuroTest {

	private static String fileName = "GoEuroTest.csv";
	
	/**
	 * @param args
	 *            parameters given in the command line
	 * @throws Exception
	 *             when number of arguments is different than 1
	 */
	public static void main(String[] args) throws Exception {

		if (args.length != 1) {
			throw new Exception("There is no argument in the command line!");
		}

		String cityName = args[0];

		new CsvCreator().createCsvFileFromJson(new ApiWithEndpointUser()
				.getJsonWithEndpoint(cityName), fileName);

	}

}
