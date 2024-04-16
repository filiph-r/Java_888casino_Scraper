import services.HourlyJackpotScraperService;

import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;


public class Main
{
		public static void main(String[] args) {
			// Greet the user
			System.out.println("Welcome to the Hourly Jackpot Scraper!");

			// Ask for currency input
			System.out.println("Please enter the currency (e.g., USD, EUR):");
			Scanner scanner = new Scanner(System.in);
			String currency = scanner.nextLine().toLowerCase();

			// Set up timer to call HourlyJackpotScraperService
			Timer timer = new Timer();
			timer.scheduleAtFixedRate(new TimerTask() {
				@Override
				public void run() {
					String jackpotAmount = HourlyJackpotScraperService.scrapeHourlyJackpot(currency);
					System.out.println("Hourly Jackpot: " + jackpotAmount + " " + currency.toUpperCase());
				}
			}, 0, 30);

			scanner.close();
		}
}
