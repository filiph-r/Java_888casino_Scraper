import services.HourlyJackpotScraperService;

import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

import static constants.PropertyConstants.MESSAGE_CURRENCY;
import static constants.PropertyConstants.MESSAGE_GREETING;
import static constants.PropertyConstants.JACKPOT_NAME;


public class Main
{
	public static void main(String[] args)
	{
		// Greet the user
		System.out.println(MESSAGE_GREETING);

		// Ask for currency input
		System.out.println(MESSAGE_CURRENCY);
		Scanner scanner = new Scanner(System.in);
		String currency = scanner.nextLine().toLowerCase();

		// Set up timer to call HourlyJackpotScraperService
		Timer timer = new Timer();
		timer.scheduleAtFixedRate(new TimerTask()
		{
			@Override
			public void run()
			{
				String jackpotAmount = HourlyJackpotScraperService.scrapeHourlyJackpot(currency);
				System.out.println(JACKPOT_NAME + ": " + jackpotAmount + " " + currency.toUpperCase());
			}
		}, 0, 30);

		scanner.close();
	}
}
