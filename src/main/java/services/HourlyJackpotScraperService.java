package services;

import com.google.gson.Gson;
import models.JackpotResponse;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;
import java.util.Objects;

import static constants.PropertyConstants.*;


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
			if (!jackpotResponse.isSuccess())
			{
				return MESSAGE_NOT_FOUND;
			}
			final List<JackpotResponse.Pot> pots = jackpotResponse.getResult().getJackpots().getPots();
			ValidationService.validateNotNull(pots);

			for (JackpotResponse.Pot pot : pots)
			{
				if (JACKPOT_NAME.equals(pot.getName()))
				{
					return pot.getAmount();
				}
			}
		}
		catch (IOException | InterruptedException | NullPointerException e)
		{
			e.printStackTrace();
		}

		return MESSAGE_NOT_FOUND;
	}
}
