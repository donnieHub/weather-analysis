package org.mychko.weatheranalysis;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;

public class WeatherAnalysisApplication {

	private final static String LAT = "?lat=59.94117";
	private final static String LON = "&lon=30.324928";
	private final static String URI = "https://api.weather.yandex.ru/v2/informers";

	public static void main(String[] args) throws IOException, InterruptedException {
		WeatherAnalysisApplication app = new WeatherAnalysisApplication();
		HttpClient client = app.createClient();
		HttpRequest request = app.createGetRequest(app.createURI(URI, LAT, LON));
		HttpResponse<String> response = app.getApiResponse(client, request);

		System.out.println(response.statusCode());
		System.out.println(response.body());
		System.out.println("--------------------------------------------------------");
	}

	private String createURI (String url, String... params) {
		StringBuilder uri = new StringBuilder(url);
		for (String param : params) {
			uri.append(param);
		}
		return uri.toString();
	}

	private HttpClient createClient() {
		HttpClient client = HttpClient.newBuilder()
				.version(HttpClient.Version.HTTP_2)
				.build();
		return client;
	}

	private HttpRequest createGetRequest(String uri) {
		HttpRequest request = HttpRequest.newBuilder()
				.uri(java.net.URI.create(uri))
				.timeout(Duration.ofMinutes(1))
				.header("Content-Type", "application/json")
				.header("X-Yandex-API-Key", "bd804162-bf13-4baa-9508-27b3ba88c782")
				.GET()
				.build();
		return request;
	}

	private <T> HttpResponse<T> getApiResponse(HttpClient client, HttpRequest request) throws IOException, InterruptedException {
		HttpResponse<T> response =
				(HttpResponse<T>) client.send(request, HttpResponse.BodyHandlers.ofString());
		return response;
	}
}
