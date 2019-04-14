package temp;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/*
 * Test cases for Assignment and Textbook reference code are omitted for simplicity.
 */

public class IndustryTest {

	Industry industry1, industry2, industry3, industry4, industry5;

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		industry1 = new Industry("testIndustry1", "Canada", 30.66, 40.3, "2017-12", false);
		industry2 = new Industry("testIndustry2", "Canada", 30.65, 40.3, "2017-12", false);
		industry3 = new Industry("testIndustry3", "Canada", 30.66, 40.3, "2017-12", true);
		industry4 = new Industry("testIndustry4", "Canada", 30.66, 40.2, "2017-12", true);
		industry5 = new Industry("testIndustry5", "Canada", 30.65, 40.2, "2017-12", true);
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
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link temp.RelaventIndustries#RelaventIndustries()}.
	 */
	@Test
	public void testRIRelaventIndustries() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for
	 * {@link temp.RelaventIndustries#giveRecommendations(java.lang.String[])}.
	 */
	@Test
	public void testRIGiveRecommendations() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link temp.RelaventIndustries#getGraph()}.
	 */
	@Test
	public void testRIGetGraph() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link temp.Industry#Name()}.
	 */
	@Test
	public void testIndustryName() {
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
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link temp.Industry#HourlyEarn()}.
	 */
	@Test
	public void testIndustryHourlyEarn() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link temp.Industry#WorkHour()}.
	 */
	@Test
	public void testIndustryWorkHour() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link temp.Industry#Time()}.
	 */
	@Test
	public void testIndustryTime() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link temp.Industry#Overtime()}.
	 */
	@Test
	public void testIndustryOvertime() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link temp.Industry#toString()}.
	 */
	@Test
	public void testIndustryToString() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link temp.Industry#compareTo(temp.Industry)}.
	 */
	@Test
	public void testIndustryCompareTo() {
		fail("Not yet implemented");
	}
}
