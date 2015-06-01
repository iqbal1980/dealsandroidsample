package it.flashr;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.security.MessageDigest;
import java.util.Random;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

import android.util.Log;

public class FlashrUtils {
	
	private static final String AB = "01234ABCDEFGHIJKL";
	private static Random rnd = new Random();

	public static class RandomPasswordGenerator {
		public static String generateRandomPassword(int length){
			   StringBuilder sb = new StringBuilder( length );
			   for( int i = 0; i < length; i++ ) 
			      sb.append( AB.charAt( rnd.nextInt(AB.length()) ) );
			   return sb.toString();

		}
	}
	 
	 public static String getSHA256(String input) {
			 try{
			    MessageDigest digest = MessageDigest.getInstance("SHA-256");
			    byte[] hash = digest.digest(input.getBytes("UTF-8"));
			    StringBuffer hexString = new StringBuffer();
			    for (int i=0;i<hash.length;i++) {
			       String hex=Integer.toHexString(0xff & hash[i]);
			       if(hex.length()==1) hexString.append('0');
			       hexString.append(hex);
			    }
			    return hexString.toString();
			 }catch(Exception ex){
			    throw new RuntimeException(ex);
			 }
	 }	 
	 
	 
	 public static String retrieveJSON(String uri) {
			StringBuilder builder = new StringBuilder();
			HttpClient client = new DefaultHttpClient();
			HttpGet httpGet = new HttpGet(uri);
			try {
				HttpResponse response = client.execute(httpGet);
				StatusLine statusLine = response.getStatusLine();
				int statusCode = statusLine.getStatusCode();
				if (statusCode == 200) {
					HttpEntity entity = response.getEntity();
					InputStream content = entity.getContent();
					BufferedReader reader = new BufferedReader(new InputStreamReader(content));
					String line;
					while ((line = reader.readLine()) != null) {
						builder.append(line);
					}
				} else {
					Log.i("test", "Failed to download file");
				}
			} catch (ClientProtocolException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
			return builder.toString();
		}
	 
	 
	 public static String retrieveHardCodedDealsJSON() {
		 String returnJSON = "[{         \"image_url\": \"http://flashr.it/deal_img/2525643.png\",         \"expiration\": \"2012-06-25 22:22:22\",         \"deal_id\": 40,         \"title\": \"Deal 1\",         \"deal_code\": 2525643,         \"description\": \"Description of deal 1\",         \"deal_type\": \"initial\"     }, {         \"image_url\": \"http://flashr.it/deal_img/2525643.png\",         \"expiration\": \"2012-06-25 22:22:22\",         \"deal_id\": 41,         \"title\": \"Deal 2\",         \"deal_code\": 2525643,         \"description\": \"Description of deal 2\",         \"deal_type\": \"initial\"     }, {         \"image_url\": \"http://flashr.it/deal_img/2525643.png\",         \"expiration\": \"2012-06-25 22:22:22\",         \"deal_id\": 42,         \"title\": \"Deal 3\",         \"deal_code\": 2525643,         \"description\": \"Description of deal 3\",         \"deal_type\": \"initial\"     }, {         \"image_url\": \"http://flashr.it/deal_img/2525643.png\",         \"expiration\": \"2012-06-25 22:22:22\",         \"deal_id\": 43,         \"title\": \"Deal 4\",         \"deal_code\": 2525643,         \"description\": \"Description of deal 4\",         \"deal_type\": \"initial\"     }]  "; 
		return returnJSON;
		 
	 }
}
	

