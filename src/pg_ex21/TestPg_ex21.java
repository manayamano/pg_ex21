package pg_ex21;

import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.Test;

public class TestPg_ex21 {

	@Test
	public void test() {
		Pg_ex21.pg_ex21();
		//diff
		Runtime runtime = Runtime.getRuntime();
		Process p;

		try {
			p = runtime.exec("fc /B c:\\eclipse\\pleiades\\workspace\\pg_ex21_data\\invoice.dat_sample c:\\eclipse\\pleiades\\workspace\\pg_ex21_data\\invoice.dat");
			assertEquals(0,p.waitFor());
		} catch (InterruptedException e) {
			// TODO 自動生成された catch ブロック
		e.printStackTrace();
		}catch (IOException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
	}
}
