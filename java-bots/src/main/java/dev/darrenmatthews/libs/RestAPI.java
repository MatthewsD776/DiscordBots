package dev.darrenmatthews.libs;

import java.io.IOException;

import dev.darrenmatthews.discord.exceptions.RestAPIException;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class RestAPI {

	public static String getRequest(String url) throws RestAPIException {
		OkHttpClient client = new OkHttpClient();
		Request request = new Request.Builder().url(url).build();

		try {
			Response response = client.newCall(request).execute();
			
			if (!response.isSuccessful()) {
				throw new RestAPIException("Unsuccesful Request");
			}

			return response.body().string();
		} catch (IOException e) {
			throw new RestAPIException(e.getMessage());
		}
	}

}
