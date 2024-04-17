import services.HourlyJackpotScraperService;

import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

import static constants.PropertyConstants.*;


public class Main
{
	public static void main(String[] args)
	{
		// Greet the user
		System.out.println(MESSAGE_GREETING);

		int duration = 0;
		if (args.length == 0)
		{
			duration = TIMER_DEFAULT_DURATION;
		}
		else
		{
			try
			{
				duration = Integer.parseInt(args[0]) * 1000;
			}
			catch (NumberFormatException e)
			{
				System.out.println(MESSAGE_NOT_VALID_NUMBER);
				return;
			}
		}

		// Ask for currency input
		System.out.println(MESSAGE_CURRENCY);
		Scanner scanner = new Scanner(System.in);
		String currency = scanner.nextLine().toUpperCase();

		while (!CURRENCIES.contains(currency))
		{
			System.out.println(currency + " " + MESSAGE_NOT_VALID_CURRENCY);
			System.out.println(MESSAGE_CURRENCY);
			currency = scanner.nextLine().toUpperCase();
		}


		// Set up timer to call HourlyJackpotScraperService
		Timer timer = new Timer();
		String finalCurrency = currency.toLowerCase();
		timer.scheduleAtFixedRate(new TimerTask()
		{
			@Override
			public void run()
			{
				String jackpotAmount = HourlyJackpotScraperService.scrapeHourlyJackpot(finalCurrency);
				System.out.println(JACKPOT_NAME + ": " + jackpotAmount + " " + finalCurrency.toUpperCase());
			}
		}, 0, duration);

		scanner.close();
	}
}
