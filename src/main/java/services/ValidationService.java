package services;

import java.util.Objects;


public class ValidationService
{
	public static void validateNotNull(Object o) throws NullPointerException
	{
		if (Objects.isNull(o))
		{
			throw new NullPointerException();
		}
	}

	public static void validateNumber(int number) throws NumberFormatException
	{
		if (number <= 0)
		{
			throw new NumberFormatException();
		}
	}



}
