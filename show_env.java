import java.util.Map;
import javax.xml.bind.DatatypeConverter;
import org.json.JSONObject;

class ShowEnv {
	public static void main(String[] args) {
		Map<String, String> environ = System.getenv();
		JSONObject json = new JSONObject();
		for (Map.Entry<String, String> entry : environ.entrySet()) {
			String key = entry.getKey();
			String value = entry.getValue();
			System.out.println(key + '=' + value);
			json.put(key, value);
		}
		
		String json_string = json.toString();
		try {
			byte[] json_bytes = json_string.getBytes("UTF-8");
			String base64 = DatatypeConverter.printBase64Binary(json_bytes);
			System.out.println(base64);
		} catch (java.io.UnsupportedEncodingException exc) {
			exc.printStackTrace();
		}
	}
}
