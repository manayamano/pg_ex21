package pg_ex21;

import static org.junit.Assert.*;

import org.junit.Test;

public class ServiceTest {

	@Test
	public void testService() {
		Service service = new Service();
		assertEquals(0,service.getE1());
		service.set("2 E1");
		service.set("2 C1 090-9999-9999");
		service.set("2 C1 090-9999-1234");
		service.set("2 C1 090-9999-1237");
		assertEquals(1,service.getE1());
		assertEquals(2,service.getC1());
	}


}
