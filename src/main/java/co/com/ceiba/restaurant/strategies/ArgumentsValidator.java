package co.com.ceiba.restaurant.strategies;

import co.com.ceiba.restaurant.exceptions.ExceptionsForRstrictions;

public class ArgumentsValidator {

	public static void restrictionForNull(Object valor, String mensaje) {
		if (valor == null) {
			throw new ExceptionsForRstrictions(mensaje);
		}
	}

	public static void restrictionForValueZero(int valor, String mensaje) {
		if (valor == 0) {
			throw new ExceptionsForRstrictions(mensaje);
		}
	}

	public static void restrictionForValueZero(float valor, String mensaje) {
		if (valor == 0) {
			throw new ExceptionsForRstrictions(mensaje);
		}
	}

}
