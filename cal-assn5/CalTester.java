import static org.junit.Assert.*;

import org.junit.Test;

public class CalTester {

	public static void main(String[] args) {
		org.junit.runner.JUnitCore.main("CalTester");

	}

	@Test
	public void test_same_month_first_last_day() {
		assertEquals(30, Cal.cal(1, 1, 1, 31, 2018));
	}

	@Test
	public void test_end_of_years(){
	  	assertEquals(1,Cal.cal(1,1,1,2,10000));
	}


	@Test
	public void test_same_month_different_day() {
		assertEquals(19, Cal.cal(12, 8, 12, 27, 2018));
	}

	@Test
	public void test_same_month_same_day() {
		assertEquals(0, Cal.cal(2, 15, 2, 15, 2018));
	}

	@Test
	public void test_different_month_same_day() {
		assertEquals(61, Cal.cal(5, 15, 7, 15, 2018));
	}

	@Test
	public void test_different_month_different_day() {
		assertEquals(48, Cal.cal(1, 3, 2, 20, 2018));
	}

	@Test
	public void test_first_last_of_year() {
		assertEquals(365, Cal.cal(1, 1, 12, 31, 1980));
	}

	@Test
	public void test_first_last_of_year_leap() {
		assertEquals(366, Cal.cal(1, 1, 12, 31, 1984));
	}

	@Test
	public void test_leap_year_29() {
		assertEquals(1, Cal.cal(2,28,2,29,1984));
	}
	
	@Test 
	public void test_for_failure(){
		assertEquals(-1, Cal.cal(2, 22, 1, 21, 1980));
	}
	
	@Test
	public void test_for_failure1(){
		assertEquals(-1, Cal.cal(2, 29, 2, 29, 1981));
	}


}
