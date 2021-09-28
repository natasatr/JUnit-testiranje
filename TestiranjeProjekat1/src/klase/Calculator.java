package klase;

import izuzeci.DivisionByZeroException;
import izuzeci.NotSupportedOperationException;

	/**<h1> Operation with numbers </h1>
	 * The Calculator program implements an application that
	 * calculates the values ​​of two numbers over which 
	 * the operations of addition, subtraction, multiplication, 
	 * and division are applied.
	 * 
	 * 
	 * @author Natasa Trivuncevic
	 * @version 1.1
	 * @since 24.12.2020
	 */
	
public class Calculator {
	
	
	private Double currentValue=0.0;
	
	/**
	 * Constructor for this class.
	 *
	 * @param currentValue  is the value it sets in the constructor.
	 *  Default value is zero.

	 */
	public Calculator(Double currentValue)
	{
		this.currentValue=currentValue;
	}
	
	/**
	 * This method performs the basics of a mathematical operation on two operands.
	 * It receives two parameters, the first of which must be a Double value and the second a character.
	 * The second parameter can only take the value '+', '-', '*', '/'. 
	 * Everything else is illegal.
	 * Once the send operator is applied, the result is placed in the currentValue.
	 * 
	 * 
	 * @param value This is the first paramter to calculate method.
	 * Must be of type Double. 
	 * 
	 * @param operator This is the second paramter to calculate method. 
	 * Must be of type char. This operator can only be a character '+', '-', '+', '/'.
	 * Other characters are not allowed. 
	 * In the case of division by zero, an exception is thrown.
	 * That exception is DivisionByZeroException.
	 * 
	 * @throws DivisionByZeroException this exception is thrown in case the value is zero.
	 * @throws NotSupportedOperationException This exception is thrown in case the operator is not allowed.
	 * So, if we enter anything for an operator that is not '+'or '-'or '*' or '/', this exception is discarded.
	 * 
	 * 
	 * @see DivisionByZeroException
	 * @see NotSupportedOperationException
	 
	 
	 */
	public void calculate(Double value, char operator) throws DivisionByZeroException, NotSupportedOperationException
	{
		if(operator == '+')
		{
			currentValue += value;
		
		}
		else if(operator == '-')
		{
			currentValue -= value;
		}
		else if(operator == '*')
		{ 
			currentValue *= value;
		}
		else if(operator == '/')
		{
			if(value == 0.0)
			{
				throw new DivisionByZeroException("Dijeljenje sa nulom nije dozovljeno!!!");
			}
	
			currentValue /= value;
		}
		else 
		{
			throw new NotSupportedOperationException("Nije validan operator!!!");
		}
	}
	
	/**
	 * @return A value that is of type Double.
	 */
	public Double getCurrentValue() {
		return currentValue;
	}
	
	/**
	 * @param currentValue Sets the value to some Double value.
	 */
	public void setCurrentValue(Double currentValue) {
		this.currentValue = currentValue;
	}

}
