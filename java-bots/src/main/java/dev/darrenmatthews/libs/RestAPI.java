package dev.darrenmatthews.libs;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import dev.darrenmatthews.exceptions.RestAPIException;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class RestAPI {
	private static final Logger LOGGER = LogManager.getLogger();

	private RestAPI() {
	}

	public static String getRequest(String url) throws RestAPIException {
		OkHttpClient client = new OkHttpClient();
		Request request = new Request.Builder().url(url).build();

		try {
			LOGGER.info("Sending GET request to {}", url);
			Response response = client.newCall(request).execute();

			if (!response.isSuccessful()) {
				String responseMessage = response.message();
				int responseCode = response.code();
				LOGGER.warn("GET request to {} returned {} because \"{}\"", url, responseCode, responseMessage);
				throw new RestAPIException("Unsuccesful Request : " + responseCode);
			}

			return response.body().string();
		} catch (IOException e) {
			LOGGER.warn("IOException {}", e.getMessage());
			throw new RestAPIException(e.getMessage());
		}
	}

}
