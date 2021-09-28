package test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import izuzeci.DivisionByZeroException;
import izuzeci.NotSupportedOperationException;
import izuzeci.NumberNotInAreaException;
import klase.Calculator;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.anyOf;
import static org.hamcrest.Matchers.closeTo;
import static org.hamcrest.Matchers.notNullValue;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.MatcherAssert.assertThat;

import java.util.stream.Stream;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;


import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import klase.CalculatorAdvanced;

class CalculatorAdvancedTest {

	 public CalculatorAdvanced calcAd = new CalculatorAdvanced(0.0);
	
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
		calcAd.setCurrentValue(0.0);
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testCalculatorAdvanced() {
		assertThat(calcAd, notNullValue());
	}

	@ParameterizedTest
	@MethodSource("metodaSaParametrima")
	void calculateAdvancedTest(char action, Double broj, Double res ) throws NumberNotInAreaException, NotSupportedOperationException {
		calcAd.setCurrentValue(broj);
		calcAd.calculateAdvanced(action);
		
		assertThat(calcAd.getCurrentValue(), is(res));
		
		
	}

	public static Stream<Arguments> metodaSaParametrima()
	{
		return Stream.of(
				Arguments.of('1', 5.0, 5.0),
				Arguments.of('1', -5.0, -5.0),
				Arguments.of('1', 1.0, 1.0),
				Arguments.of('2', 4.544, 16.0),
				Arguments.of('2', -6.789, 36.0),
				Arguments.of('0', 78.0, 1.0),
				Arguments.of('9', 1.0, 1.0),
				Arguments.of('9', -8.0, -134217728.0),
				Arguments.of('0', -78.12, 1.0),
				Arguments.of('2', 33.33, 1089.0),

				Arguments.of('!', 8.5, 40320.0),
				Arguments.of('!', 0.0, 1.0),
				Arguments.of('!', 1.99, 1.0)
				
				
				
				
				
				
				
				

				);

	}
	@Test
	void assertThrowExceptionTest()
	{
		Exception e = assertThrows(NotSupportedOperationException.class, ()-> calcAd.calculateAdvanced('q'));
		assertThat(e.getMessage(), is("Pogresne vrijednosti!"));
		
	}
	@Test
	void assertThrowNumberNotInAreaExceptionTestBig()
	{
		calcAd.setCurrentValue(15.0);
		Exception e = assertThrows(NumberNotInAreaException.class, ()-> calcAd.calculateAdvanced('!'));
		assertThat(e.getMessage(), is("Broj nije u dozvoljenim granicama!"));
		
	}
	@Test
	void assertThrowNumberNotInAreaExceptionTestSmall()
	{
		calcAd.setCurrentValue(-155.0);
		Exception e = assertThrows(NumberNotInAreaException.class, ()-> calcAd.calculateAdvanced('!'));
		assertThat(e.getMessage(), is("Broj nije u dozvoljenim granicama!"));
		
	}
	
	
	@ParameterizedTest
	@MethodSource("metodaSaParametrima2")
	void hasCharacteristicTest(char action, Double broj, Boolean res ) throws NotSupportedOperationException, NumberNotInAreaException {
		
		calcAd.setCurrentValue(broj);
		
		assertThat(calcAd.hasCharacteristic(action), is(res));
		
		
	}

	public static Stream<Arguments> metodaSaParametrima2()
	{
		return Stream.of(
				Arguments.of('A', 153.0, true),
				Arguments.of('A', 12.98, false), 
				Arguments.of('A',92727.0, true),
				Arguments.of('A', 5.78, true),
				Arguments.of('P', 556.0, false),
				Arguments.of('P', 6.1, true)			
	
				);
	}
	
	@Test
	void assertThrowNumberNotInAreaExceptionPerfectTest()
	{
		calcAd.setCurrentValue(-5.0);
		Exception e = assertThrows(NumberNotInAreaException.class, ()-> calcAd.hasCharacteristic('P'));
		assertThat(e.getMessage(), is("Broj nije u opsegu!"));
		
	}
	@Test
	void assertThrowNumberNotInAreaExceptionArmstTest()
	{
		calcAd.setCurrentValue(-5.0);
		Exception e = assertThrows(NumberNotInAreaException.class, ()-> calcAd.hasCharacteristic('A'));
		assertThat(e.getMessage(), is("Broj nije u opsegu!"));
		
	}
	@Test
	void assertNotSupportedOperationExceptionTest()
	{
		calcAd.setCurrentValue(7.0);
		Exception e = assertThrows(NotSupportedOperationException.class, ()-> calcAd.hasCharacteristic('S'));
		assertThat(e.getMessage(), is("Vrijednost nije podrzana!"));
		
	}

}