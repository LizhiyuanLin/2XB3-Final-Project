package temp;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/*
 * Test cases for Assignment and Textbook referenced code are omitted for simplicity.
 */

public class IndustryTest {

	Industry industry0, industry1, industry2, industry3, industry4, industry5, industry6, industry7, industry8,industry9, industry10;

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		industry0 = new Industry("testIndustry0", "Canada", 30.66, 40.3, "2017-11", false);
		industry1 = new Industry("testIndustry1", "Canada", 30.66, 40.3, "2017-12", false);
		industry2 = new Industry("testIndustry2", "Canada", 30.65, 40.3, "2017-12", false);
		industry3 = new Industry("testIndustry3", "Canada", 30.66, 40.3, "2017-12", true);
		industry4 = new Industry("testIndustry4", "Canada", 30.66, 40.2, "2017-12", true);
		industry5 = new Industry("testIndustry5", "Canada", 30.65, 40.4, "2017-12", true);
		industry6 = new Industry("testIndustry6", "Canada", 20.26, 40.1, "2017-12", false);
		industry7 = new Industry("testIndustry7", "Canada", 17.36, 40.1, "2017-11", false);
		industry8 = new Industry("testIndustry8", "Canada", 25.72, 40.1, "2017-12", true);
		industry9 = new Industry("testIndustry9", "Canada", 31.93, 40.1, "2017-11", false);
		industry10 = new Industry("testIndustry10", "Canada", 19.47, 40.1, "2017-12", true);
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}

	/**
	 * Test method for
	 * {@link temp.Search#printout(temp.Industry[], java.lang.Double)}.
	 */
	@Test
	public void testSearchPrintout() {
		Industry indLst[] = {industry0, industry1, industry2, industry3, industry4, industry5,
				industry6, industry7, industry8, industry9, industry10}; 
		Sort.sortMergeTD(indLst, indLst.length);
		Industry result1[] = Search.printout(indLst,-32.2);
		
		// Every member of result is contained in original array
		for (int i = 0; i < result1.length; i++) {
			assertTrue(Arrays.asList(indLst).contains(result1[i]));
		}
		// this specific test case should not contain testIndustry9 in the result array.
		assertFalse(Arrays.asList(result1).contains(indLst[0]));
		
		//regular case
		Industry result2[] = Search.printout(indLst,30.65);
		for (int i = 0; i < result1.length; i++) {
			assertTrue(Arrays.asList(indLst).contains(result1[i]));
		}
		
		// edge case
		assertTrue(Search.printout(null,-32.2) == null);

	}

	/**
	 * Test method for
	 * {@link temp.RelaventIndustries#giveRecommendations(java.lang.String[])}.
	 */
	@Test
	public void testRIGiveRecommendations() {
		RelaventIndustries RelInd = new RelaventIndustries();
		String name[] = {"Sound recording industries","Forestry and logging"};
		ArrayList<String> recmd = RelInd.giveRecommendations(name);
		Iterator i = recmd.iterator();
		while(i.hasNext()) {
			assertTrue(RelInd.getGraph().contains(i.next().toString()));
		}
	}


	/**
	 * Test method for {@link temp.Industry#Name()}.
	 */
	@Test
	public void testIndustryName() {
		assertEquals(industry0.Name(), "testIndustry0");
		assertEquals(industry1.Name(), "testIndustry1");
		assertEquals(industry2.Name(), "testIndustry2");
		assertEquals(industry3.Name(), "testIndustry3");
		assertEquals(industry4.Name(), "testIndustry4");
		assertEquals(industry5.Name(), "testIndustry5");
	}

	/**
	 * Test method for {@link temp.Industry#region()}.
	 */
	@Test
	public void testIndustryRegion() {
		assertEquals(industry0.region(), "Canada");
		assertEquals(industry1.region(), "Canada");
		assertEquals(industry2.region(), "Canada");
		assertEquals(industry3.region(), "Canada");
		assertEquals(industry4.region(), "Canada");
		assertEquals(industry5.region(), "Canada");
	}

	/**
	 * Test method for {@link temp.Industry#HourlyEarn()}.
	 */
	@Test
	public void testIndustryHourlyEarn() {
		assertTrue(Math.abs(industry0.HourlyEarn() - 30.66) <= 0.0005);
		assertTrue(Math.abs(industry1.HourlyEarn() - 30.66) <= 0.0005);
		assertTrue(Math.abs(industry2.HourlyEarn() - 30.65) <= 0.0005);
		assertTrue(Math.abs(industry3.HourlyEarn() - 30.66) <= 0.0005);
		assertTrue(Math.abs(industry4.HourlyEarn() - 30.66) <= 0.0005);
		assertTrue(Math.abs(industry5.HourlyEarn() - 30.65) <= 0.0005);
	}

	/**
	 * Test method for {@link temp.Industry#WorkHour()}.
	 */
	@Test
	public void testIndustryWorkHour() {
		assertTrue(Math.abs(industry0.WorkHour() - 40.3) <= 0.005);
		assertTrue(Math.abs(industry1.WorkHour() - 40.3) <= 0.005);
		assertTrue(Math.abs(industry2.WorkHour() - 40.3) <= 0.005);
		assertTrue(Math.abs(industry3.WorkHour() - 40.3) <= 0.005);
		assertTrue(Math.abs(industry4.WorkHour() - 40.2) <= 0.005);
		assertTrue(Math.abs(industry5.WorkHour() - 40.4) <= 0.005);
	}

	/**
	 * Test method for {@link temp.Industry#Time()}.
	 */
	@Test
	public void testIndustryTime() {
		assertEquals(industry0.Time(), "2017-11");
		assertEquals(industry1.Time(), "2017-12");
		assertEquals(industry2.Time(), "2017-12");
		assertEquals(industry3.Time(), "2017-12");
		assertEquals(industry4.Time(), "2017-12");
		assertEquals(industry5.Time(), "2017-12");
	}

	/**
	 * Test method for {@link temp.Industry#Overtime()}.
	 */
	@Test
	public void testIndustryOvertime() {
		assertFalse(industry0.Overtime());
		assertFalse(industry1.Overtime());
		assertFalse(industry2.Overtime());
		assertTrue(industry3.Overtime());
		assertTrue(industry4.Overtime());
		assertTrue(industry5.Overtime());
	}

	/**
	 * Test method for {@link temp.Industry#toString()}.
	 */
	@Test
	public void testIndustryToString() {
		assertEquals(industry0.toString(),
				"Industry [name=testIndustry0, region=Canada, Hourly Earning=30.66, Hours of Working=40.3, Time=2017-11, Overtime = false]");
		assertEquals(industry1.toString(),
				"Industry [name=testIndustry1, region=Canada, Hourly Earning=30.66, Hours of Working=40.3, Time=2017-12, Overtime = false]");
		assertEquals(industry2.toString(),
				"Industry [name=testIndustry2, region=Canada, Hourly Earning=30.65, Hours of Working=40.3, Time=2017-12, Overtime = false]");
		assertEquals(industry3.toString(),
				"Industry [name=testIndustry3, region=Canada, Hourly Earning=30.66, Hours of Working=40.3, Time=2017-12, Overtime = true]");
		assertEquals(industry4.toString(),
				"Industry [name=testIndustry4, region=Canada, Hourly Earning=30.66, Hours of Working=40.2, Time=2017-12, Overtime = true]");
		assertEquals(industry5.toString(),
				"Industry [name=testIndustry5, region=Canada, Hourly Earning=30.65, Hours of Working=40.4, Time=2017-12, Overtime = true]");
	}

	/**
	 * Test method for {@link temp.Industry#compareTo(temp.Industry)}.
	 */
	@Test
	public void testIndustryCompareTo() {
		assertTrue(industry0.compareTo(industry1) == 0);
		assertTrue(industry1.compareTo(industry2) < 0);
		assertTrue(industry1.compareTo(industry5) < 0);
		assertTrue(industry3.compareTo(industry5) < 0);
		assertTrue(industry4.compareTo(industry5) < 0);
		assertTrue(industry2.compareTo(industry5) < 0);
		assertTrue(industry1.compareTo(industry3) < 0);
		assertTrue(industry0.compareTo(industry3) < 0);
		assertTrue(industry3.compareTo(industry4) > 0);
		assertTrue(industry1.compareTo(industry4) > 0);
	}
}
