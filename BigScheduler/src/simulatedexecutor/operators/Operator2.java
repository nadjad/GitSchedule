package simulatedexecutor.operators;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class Operator2 {
	public static void main(String[] args) {
		String line;
		try {
			InputStream fis = new FileInputStream(args[0]);
			InputStreamReader isr = new InputStreamReader(fis);
			BufferedReader br = new BufferedReader(isr);
			line = br.readLine();
			fis.close();

			PrintWriter out = new PrintWriter(args[1]);

			line = "rrr*" + line;
			out.println(line);
			out.close();
			System.out.println("scris:" + line);

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
