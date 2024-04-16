package services;

import com.google.gson.Gson;
import models.JackpotResponse;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import static constants.PropertyConstants.REQUEST_URL;
import static constants.PropertyConstants.JACKPOT_NAME;

public class HourlyJackpotScraperService
{
	public static String scrapeHourlyJackpot(final String currency)
	{
		String url = String.format(REQUEST_URL, currency);

		HttpClient client = HttpClient.newHttpClient();
		HttpRequest request = HttpRequest.newBuilder()
				.uri(URI.create(url))
				.build();

		try
		{
			HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
			String responseBody = response.body();

			Gson gson = new Gson();
			JackpotResponse jackpotResponse = gson.fromJson(responseBody, JackpotResponse.class);

			for (JackpotResponse.Pot pot : jackpotResponse.getResult().getJackpots().getPots())
			{
				if (JACKPOT_NAME.equals(pot.getName()))
				{
					return pot.getAmount();
				}
			}
		}
		catch (IOException | InterruptedException e)
		{
			e.printStackTrace();
		}

		return "Amount for Hourly Drop Jackpot not found";
	}
}
