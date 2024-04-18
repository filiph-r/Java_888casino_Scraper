package constants;

import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;


public abstract class PropertyConstants
{
	public static final String REQUEST_URL;
	public static final String JACKPOT_NAME;
	public static final int TIMER_DEFAULT_DURATION;
	public static final List<String> CURRENCIES;
	public static final String MESSAGE_GREETING;
	public static final String MESSAGE_CURRENCY;
	public static final String MESSAGE_NOT_FOUND;
	public static final String MESSAGE_NOT_VALID_NUMBER;
	public static final String MESSAGE_NOT_VALID_CURRENCY;

	static
	{
		ResourceBundle bundle = ResourceBundle.getBundle("config");
		REQUEST_URL = bundle.getString("request.url");
		JACKPOT_NAME = bundle.getString("jackpot.name");
		TIMER_DEFAULT_DURATION = Integer.parseInt(bundle.getString("timer.defaultDuration"));
		CURRENCIES = Arrays.asList(bundle.getString("currencies").split(","));
		MESSAGE_GREETING = bundle.getString("message.greeting");
		MESSAGE_CURRENCY = bundle.getString("message.currency");
		MESSAGE_NOT_FOUND = bundle.getString("message.notFound");
		MESSAGE_NOT_VALID_NUMBER = bundle.getString("message.notValidNumber");
		MESSAGE_NOT_VALID_CURRENCY= bundle.getString("message.notValidCurrency");
	}
}
