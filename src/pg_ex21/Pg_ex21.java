package pg_ex21;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Pg_ex21 {

	public static void main(String[] args) {

		final String RECORD_FILE = "record.log";
		final String INVOICE_FILE = "invoice.dat";

		String file_path = "C:\\eclipse\\pleiades\\workspacepg_ex21_data";

		// record.log
		int count=0;
		User[] user = new User[10000];
		//10000でいいか？

		FileReader fr;
		BufferedReader br;

		try {
			fr = new FileReader(file_path + RECORD_FILE);
			br = new BufferedReader(fr);

			String line;
			while((line = br.readLine()) != null){
				switch(line.charAt(0)){
				case '1':
					user[count] = new User(line.substring(2,14));
					break;
				case '9':
					//出力

				default:
					user[count].set(line);
				}
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}  catch (IOException e) {
			e.printStackTrace();
		}
	}




}
