package utilities;

import java.io.FileWriter;
import java.io.IOException;

import org.json.JSONArray;
import org.json.JSONObject;

public class CsvCreator {

	private static String id = "_id";
	private static String name = "name";
	private static String type = "type";
	private static String geoPosition = "geo_position";
	private static String latitude = "latitude";
	private static String longitude = "longitude";

	/**
	 * @param jsonContent
	 *            String with json's content
	 * @param fileName
	 *            , name of the file to which content should be saved
	 * @throws IOException
	 */
	public void createCsvFileFromJson(String jsonContent, String fileName)
			throws IOException {

		FileWriter writer = new FileWriter(fileName);
		JSONArray jsonArray = new JSONArray(jsonContent);

		writer.append(id + ";");
		writer.append(name + ";");
		writer.append(type + ";");
		writer.append(latitude + ";");
		writer.append(longitude + ";");
		writer.append("\n");
		
		if (jsonArray.length() == 0){
			System.out.println("No results found for the desired city");
		}

		for (int i = 0; i < jsonArray.length(); i++) {
			writer.append(jsonArray.getJSONObject(i).get(id).toString() + ";");
			writer.append(jsonArray.getJSONObject(i).get(name).toString() + ";");
			writer.append(jsonArray.getJSONObject(i).get(type).toString() + ";");

			JSONObject innerObject = new JSONObject(jsonArray.getJSONObject(i)
					.get(geoPosition).toString());

			writer.append(innerObject.get(latitude) + ";");
			writer.append(innerObject.get(longitude) + ";");

			writer.append("\n");
		}

		writer.flush();
		writer.close();
	}

}
