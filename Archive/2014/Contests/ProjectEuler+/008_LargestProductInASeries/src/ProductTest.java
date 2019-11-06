import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;


public class ProductTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void test1() {
		assertEquals(362880, Solution.calculateProduct("123456789"));
	}

	@Test
	public void test2() {
		assertEquals(0, Solution.calculateProduct("1234567890"));
	}

	@Test
	public void test3() {
		assertEquals(0, Solution.calculateProduct("0123456789"));
	}
	@Test
	public void test4() {
		assertEquals(5*5*6*6*7*7*8, Solution.calculateProduct("5577668"));
	}
//	@Test
//	public void test5() {
//		assertEquals(0, Solution.calculateProduct("0123456789"));
//	}
//	@Test
//	public void test6() {
//		assertEquals(0, Solution.calculateProduct("0123456789"));
//	}
//	@Test
//	public void test7() {
//		assertEquals(0, Solution.calculateProduct("0123456789"));
//	}

}
