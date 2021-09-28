package test;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import izuzeci.DivisionByZeroException;
import izuzeci.NotSupportedOperationException;
import klase.Calculator;

import static org.hamcrest.Matchers.is;

import static org.hamcrest.Matchers.closeTo;
import static org.hamcrest.Matchers.notNullValue;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.util.stream.Stream;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

class CalculatorTest {

	public Calculator calc = new Calculator(0.0);
	
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
		calc.setCurrentValue(0.0);
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testCalculator() {
		assertThat(calc, notNullValue());
	}
	@Test
	void testCalculate()
	{}

	@ParameterizedTest
	@MethodSource("metodaSaParametrima")
	void testCalculateParam(Double vrijednost,Double tmp, char operator, Double rezultat ) throws DivisionByZeroException, NotSupportedOperationException {
		calc.setCurrentValue(vrijednost);
		calc.calculate(tmp, operator);
		
		assertThat(calc.getCurrentValue(), closeTo(rezultat, 0.1));
		
		
	}

	public static Stream<Arguments> metodaSaParametrima()
	{
		return Stream.of(
				Arguments.of(5.0, 1.0, '+', 6.0),
				Arguments.of(4.2, -9.5, '+' ,-5.3),
				Arguments.of(7.2, 5.0, '-', 2.2),
				Arguments.of(3.5, 1.0, '*', 3.5),
				Arguments.of(3.5, -1.5, '-', 5.0),
				Arguments.of(-1.2, -7.6, '-', 6.4),
				Arguments.of(-5.0, 1.0, '+', -4.0),
				Arguments.of(-4.0, 1.0, '-', -5.0),
				Arguments.of(2.0, 0.0, '*', 0.0),
				Arguments.of(9.5, -7.0, '*', -66.5),
				Arguments.of(-9.5, -7.0, '*', 66.5),
				Arguments.of(-4.2, -3.2, '+', -7.50),
				Arguments.of(-7.2, 2.0, '*', -14.4),
				Arguments.of(0.0, 789.0, '*', 0.0),
				Arguments.of(9.0, 3.0, '/', 3.0),
				Arguments.of(-4.4, 2.2, '/', -2.0),
				Arguments.of(17.9, -6.5, '/',-2.7),
				Arguments.of(-18.0, -9.2, '/',1.9),
				Arguments.of(0.0, 5.6, '/',0.0)
				
				
		
				);

	}
	
	@Test
	void assertThrowExceptionTest()
	{
		Exception e = assertThrows(DivisionByZeroException.class, ()->calc.calculate(0.0, '/'));
		assertThat(e.getMessage(), is("Dijeljenje sa nulom nije dozovljeno!!!"));
		
	}
	
	@Test
	void assertThrowInvalidOperatorExceptionTest()
	{
		Exception e = assertThrows(NotSupportedOperationException.class, ()->calc.calculate(0.0, ']'));
		assertThat(e.getMessage(), is("Nije validan operator!!!"));
		
	}
	
	@Test
	void testGetCurrentValue() {
		assertThat(calc.getCurrentValue(), is(0.0));
	}

	@Test
	void testSetCurrentValue() {
		calc.setCurrentValue(2.0);
		assertThat(calc.getCurrentValue(), is(2.0));
		
	}

}
