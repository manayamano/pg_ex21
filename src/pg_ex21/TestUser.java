package pg_ex21;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestUser {

	//
	@Test
	public void test(){
		User user = new User("090-1234-0002");
		assertEquals("090-1234-0002",user.getNumber());

	}


	//service
	@Test
	public void testService() {
		User user = new User("090-1234-0002");
		Service service = user.getService();
		assertEquals(0,service.getE1());
		user.set("2 E1");
		user.set("2 C1 090-9999-9999");
		user.set("2 C1 090-9999-1234");
		user.set("2 C1 090-9999-1237");
		assertEquals(1,service.getE1());
		assertEquals(2,service.getC1());
		//assertEquals("090-9999-9999", service.getC1Number(0));
		//assertEquals("090-9999-1234", service.getC1Number(1));
	}

	//kiroku
	@Test
	public void testKiroku(){
		User user = new User("090-1234-0002");
		user.set("5 2005/04/01 03:13 003 090-9999-1234");
		assertEquals("2005/04/01",user.getRecord(0).date);
		assertEquals("03:13",user.getRecord(0).time);
		assertEquals("003",user.getRecord(0).interval);
		assertEquals("090-9999-1234",user.getRecord(0).number);
	}

	//基本料金
	@Test
	public void testBasicfee(){
		User user = new User("090-1234-0002");
		assertEquals(1000,user.getBasicfee());
		user.set("2 E1");
		assertEquals(1200,user.getBasicfee());
		user.set("2 C1 090-9999-9999");
		assertEquals(1300,user.getBasicfee());
		user.set("2 C1 090-9999-1234");
		assertEquals(1300,user.getBasicfee());

	}

	//通話料金計算
	@Test
	public void testCallfee1(){
		User user = new User("090-1234-0002");
		assertEquals(0, user.getCallfee());
		user.set("5 2005/04/01 03:13 003 090-9999-1234");
		user.set("5 2005/04/01 09:13 007 090-9999-1111");
		assertEquals(200, user.getCallfee());
		user.set("2 E1");
		assertEquals(165, user.getCallfee());
		user.set("2 C1 090-9999-9999");
		user.set("2 C1 090-9999-1234");
		assertEquals(135,user.getCallfee());
		user.set("5 2005/04/01 17:13 007 090-9999-9999");
		assertEquals(184,user.getCallfee());
	}

	@Test
	public void testCallfee2(){
		User user = new User("090-1234-0002");
		user.set("5 2005/04/01 03:13 003 090-9999-1234");
		user.set("5 2005/04/01 09:13 007 090-9999-1111");
		user.set("2 C1 090-9999-9999");
		user.set("2 C1 090-9999-1234");
		assertEquals(170,user.getCallfee());
	}

	//出力
	@Test
	public void testOutput(){
		User user = new User("090-1234-0002");
		user.set("5 2005/04/01 03:13 003 090-9999-1234");
		user.set("5 2005/04/01 09:13 007 090-9999-1111");
		user.set("2 E1");
		user.set("2 C1 090-9999-9999");
		user.set("2 C1 090-9999-1234");
		user.set("5 2005/04/01 17:13 007 090-9999-9999");
		String output =
				"1 090-1234-0002\n" +
				"5 1300\n" +
				"7 184\n" +
				"9 ====================\n";
		assertEquals(output, user.getOutput());
	}





}
