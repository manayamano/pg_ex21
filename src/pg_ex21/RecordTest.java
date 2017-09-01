package pg_ex21;

import static org.junit.Assert.*;

import org.junit.Test;

public class RecordTest {

	@Test
	public void test() {
		Record records = new Record("5 2005/04/01 03:13 003 090-9999-1234");
		assertEquals("2005/04/01",records.date);
		assertEquals("03:13",records.time);
		assertEquals(3,records.getInterval());
		assertEquals("090-9999-1234",records.getNumber());
		assertEquals(3, records.getTimeHour());
	}


}
