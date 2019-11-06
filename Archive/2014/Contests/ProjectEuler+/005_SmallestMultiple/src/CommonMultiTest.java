import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;


public class CommonMultiTest {

	@Before
	public void setUp() throws Exception {
		Solution.D = true;
		Solution s = new Solution();
	}

	@Test
	public void test1() {
		assertEquals(Solution.commonMultiple(60, 6), 60);
	}
	@Test
	public void test2() {
		assertEquals(Solution.commonMultiple(8, 4), 8);
	}
	

}
