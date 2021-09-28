package klase;

import izuzeci.NotSupportedOperationException;
import izuzeci.NumberNotInAreaException;

/**
 * <h2> Exponentiation and Factorial </h2>
 * 
 * This class inherits the Calculator class.
 * The class has two more methods that are calculateAdvanced() and hasCharacteristic().
 * 
 * The first method calculates the Exponentiation or factorial,
 * depending on what we send as an argument to that function.
 * 
 * The second method checks whether the number is Armstrong's or is Perfect, 
 * also depending on which argument is passed.
 * 
 * 
 * @author Natasa Trivuncevic
 *
 *
 */
public class CalculatorAdvanced extends Calculator {

	/**
	 * @param currentValue Sets the value to the one passed as the constructor argument.
	 */
	public CalculatorAdvanced(Double currentValue) {
		super(currentValue);
	}

	/**
	 * 
	 * This method calculates the Exponentiation or factorial of a number.
	 * Depending on the value passed as an argument, that case will be executed.
	 * In case we pass a character whose value is between '0' to '9',
	 * the Exponentiation of the number will be calculated in the first condition.
	 * A number of type double is passed, then its integer value is taken, casting is performed, 
	 * and then the Exponentiation is calculated.
	 * Here we have several conditions, if the Exponentiation is zero,
	 * the value will always be zero, and if the value is 1, we will always have the same number. 
	 * It is important to note that the result later is again a Double value.
	 * 
	 * In the second condition, if we pass the character '!' we will calculate the factorial of the number,
	 * provided that the whole part of the number must again be in the range from 0 to 10, and this condition is covered.
	 * In case the number is zero or one, the factorial value of that number is one.
	 *  
	 * If none of this happened, an exception is thrown.
	 * 
	 * @param action this is the only paramter to calculateAdvanced method. 
	 * It can take values ​​between '0' and '9' or factorial, while everything else is not allowed.
	 * 
	 * @see NumberNotInAreaException
	 * @see NotSupportedOperationException
	 * 
	 * 
	 * @throws NumberNotInAreaException - When calculating 
	 * factorial number value of currentValue must be in the range [0, 10]. Otherwise, this exception is created.
	 * 
	 * @throws NotSupportedOperationException - If the parameter value is not supported, this exception will be thrown.
	 */
	public void calculateAdvanced(char action) throws NumberNotInAreaException, NotSupportedOperationException {
		{

		double value = (double) getCurrentValue();
		int cijeliDio = (int) value;

		if (action >= '0' && action <= '9') {
			if (action == '0') {
				setCurrentValue(1.0);

			} else if (action == '1') {
				double res = (double) cijeliDio;
				setCurrentValue(res);
			} else {
				Double res = 1.0;
				while (action != '0') {
					res *= cijeliDio;
					action--;

				}

				setCurrentValue(res);
				}

		} else if (action == '!') {
			
			if (cijeliDio < 0 || cijeliDio > 10) {
				throw new NumberNotInAreaException("Broj nije u dozvoljenim granicama!");
			}
		if(cijeliDio==0 || cijeliDio==1) {
			setCurrentValue(1.0);
			}
		 
		
			Double res = 1.0;

			while (cijeliDio != 0) {
				res *= cijeliDio;
				cijeliDio--;
			}
			setCurrentValue(res);
			
		}
		else
		{
				throw new NotSupportedOperationException("Pogresne vrijednosti!");
		}
	}
		
}

	/**
	 * This method checks whether the number is Armstrong or Perfect. 
	 * If A is passed as an argument, a part of the code is processed that checks if the number is Armstrong, 
	 * and if P is passed, a check is made to see if the number is perfect.
	 * Otherwise, an exception is thrown.
	 * 
	 * The Double value is passed, then its Integer value is taken
	 * and it will be the number for which the check will be performed.
	 * 
	 * @param value this is the only paramter to hasCharacteristic method.
	 * Its values ​​can be either character A or character P.
	 * A is for Armstrong's number, while P is for Perfect Number.
	 * 
	 * @return true for a condition that is fulfilled, in every other case will return false.
	 * 
	 * @see NotSupportedOperationException
	 * @see NumberNotInAreaException
	 * 
	 * @throws NotSupportedOperationException
	 * @throws NumberNotInAreaException
	 */
	public Boolean hasCharacteristic(char value) throws NotSupportedOperationException, NumberNotInAreaException {
		
		
		if (getCurrentValue() < 1.0) {
			throw new NumberNotInAreaException("Broj nije u opsegu!");
		}
		
		double vrijednost = (double) getCurrentValue();
		int cijeliDio = (int) vrijednost;

		if (value == 'A') {
			int pom = cijeliDio;
			int br = 0;
			while (pom != 0) {
				pom /= 10;
				br++;
			}
			int pom1 = cijeliDio;
			Double res = 1.0;
			int ukupno = 0;
			while (pom1 != 0) {
				int pombr = br;
				int k = pom1 % 10;
				while (pombr > 0) {
					res *= k;
					pombr--;
				}
				ukupno += res;
				pom1 /= 10;
				res = 1.0;

			}

			if (ukupno == cijeliDio) {
				return true;
			}

		} else if (value == 'P') {
			int pom = cijeliDio;
			int res = 0;
			for (int i = 1; i < pom; i++) {
				if (pom % i == 0) {
					res += i;
				}
			}
			if (res == cijeliDio) {
				return true;
			} else
				return false;

		} else {
			throw new NotSupportedOperationException("Vrijednost nije podrzana!");
		}
		return false;

	}
}
