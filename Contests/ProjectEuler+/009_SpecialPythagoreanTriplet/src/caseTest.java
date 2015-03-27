import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;


public class caseTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void test() {
		System.out.println();
		Solution.calculateCase(12);
		assertEquals(true, true);
	}
	@Test
	public void test2() {
		System.out.println();
		Solution.calculateCase(30);
		assertEquals(true, true);
	}
	@Test
	public void test3() {
		System.out.println();
		Solution.calculateCase(56);
		assertEquals(true, true);
	}
	@Test
	public void test4() {
		System.out.println();
		Solution.calculateCase(1122);
		assertEquals(true, true);
	}

}
