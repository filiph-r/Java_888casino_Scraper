package constants;

import java.util.ResourceBundle;


public abstract class PropertyConstants
{
	public static final String REQUEST_URL;
	public static final String JACKPOT_NAME;

	static
	{
		ResourceBundle bundle = ResourceBundle.getBundle("config");
		REQUEST_URL = bundle.getString("request.url");
		JACKPOT_NAME = bundle.getString("jackpot.name");
	}
}
