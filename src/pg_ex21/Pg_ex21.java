package pg_ex21;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Pg_ex21 {

	public static void pg_ex21() {

		final String RECORD_FILE = "record.log";
		final String INVOICE_FILE = "invoice.dat";

		String file_path = "C:/eclipse/pleiades/workspace/pg_ex21_data";

		User user = new User();

		FileReader fr;
		BufferedReader br;

		try {
			fr = new FileReader(file_path + "/" + RECORD_FILE);
			br = new BufferedReader(fr);

			FileWriter filewriter = new FileWriter(file_path + "/" + INVOICE_FILE);

			String line;
			br.readLine();
			while((line = br.readLine()) != null){
				switch(line.charAt(0)){
				case '1':
					user = new User(line.substring(2,15));
					break;
				//case '9':
				case '0':
					//出力
					filewriter.write(user.getOutput());
					break;
				default:
					user.set(line);
				}
			}
			filewriter.close();

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}  catch (IOException e) {
			e.printStackTrace();
		}
	}
}
