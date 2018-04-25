package vn.edu.hcmuaf.NongLamAnnounceService.code;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class ReadURL {
	public ReadURL() {

	}

	public String readData(String url) {
		String data = "";
		try {
			// String url =
			// "http://localhost:8080/NongLamAnnounceService/webresources/user/login/14130126/12345678";
			URL obj = new URL(url);
			HttpURLConnection con;
			con = (HttpURLConnection) obj.openConnection();
			BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
			String inputLine;
			StringBuffer reponse = new StringBuffer();
			while ((inputLine = in.readLine()) != null) {
				reponse.append(inputLine);
			}
			in.close();
			data = reponse.toString();

		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return data;
	}

	public static void main(String[] args) {
		ReadURL readURL = new ReadURL();
		readURL.readData("http://localhost:8080/NongLamAnnounceService/webresources/announce/all");
	}
}
