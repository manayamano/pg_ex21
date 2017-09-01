package pg_ex21;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestUser {

	//
	@Test
	public void test(){
		User user = new User("090-1234-0002");
		assertEquals("090-1234-0002",user.number);

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
		assertEquals(0, user.callfee);
		user.set("5 2005/04/01 03:13 003 090-9999-1234");
		user.set("5 2005/04/01 09:13 007 090-9999-1111");
		assertEquals(200, user.callfee);

	}

	@Test
	public void testCallfee3(){
		User user = new User("090-1234-0002");
		user.set("2 E1");
		user.set("5 2005/04/01 03:13 003 090-9999-1234");
		user.set("5 2005/04/01 09:13 007 090-9999-1111");
		assertEquals(165, user.callfee);

	}

	@Test
	public void testCallfee4(){
		User user = new User("090-1234-0002");
		user.set("2 E1");
		user.set("2 C1 090-9999-9999");
		user.set("2 C1 090-9999-1234");
		user.set("5 2005/04/01 03:13 003 090-9999-1234");
		user.set("5 2005/04/01 09:13 007 090-9999-1111");
		assertEquals(135,user.callfee);
		user.set("5 2005/04/01 17:13 007 090-9999-9999");
		assertEquals(184,user.callfee);
	}

	@Test
	public void testCallfee2(){
		User user = new User("090-1234-0002");
		user.set("2 C1 090-9999-9999");
		user.set("2 C1 090-9999-1234");
		user.set("5 2005/04/01 03:13 003 090-9999-1234");
		user.set("5 2005/04/01 09:13 007 090-9999-1111");
		assertEquals(170,user.callfee);
	}

	//出力
	@Test
	public void testOutput(){
		User user = new User("090-1234-0002");
		user.set("2 E1");
		user.set("2 C1 090-9999-9999");
		user.set("2 C1 090-9999-1234");
		user.set("5 2005/04/01 03:13 003 090-9999-1234");
		user.set("5 2005/04/01 09:13 007 090-9999-1111");
		user.set("5 2005/04/01 17:13 007 090-9999-9999");
		String output =
				"1 090-1234-0002\n" +
				"5 1300\n" +
				"7 184\n" +
				"9 ====================\n";
		assertEquals(output, user.getOutput());
	}





}
