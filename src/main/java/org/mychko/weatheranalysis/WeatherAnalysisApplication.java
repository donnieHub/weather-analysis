package org.mychko.weatheranalysis;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;

public class WeatherAnalysisApplication {

	public static void main(String[] args) throws IOException, InterruptedException {
		HttpClient client = HttpClient.newBuilder()
				.version(HttpClient.Version.HTTP_2)
				.build();

		HttpRequest request = HttpRequest.newBuilder()
				.uri(URI.create("https://api.weather.yandex.ru/v2/informers?lat=55.75396&lon=37.620393"))
				.timeout(Duration.ofMinutes(1))
				.header("Content-Type", "application/json")
				.header("X-Yandex-API-Key", "bd804162-bf13-4baa-9508-27b3ba88c782")
				.GET()
				.build();

		HttpResponse<String> response =
				client.send(request, HttpResponse.BodyHandlers.ofString());
		System.out.println(response.statusCode());
		System.out.println(response.body());
		System.out.println("the end");
	}
}
