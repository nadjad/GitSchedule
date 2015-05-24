package simulatedexecutor.operators;

import java.util.Arrays;
import java.util.List;

public class Executor {

	public static void main(String[] args) {
		String s[] = { "temp\\fl1.txt", "temp\\fl2.txt" };
		execute("op1.jar", s);
	}

	public static void execute(String opPath, String ar[]) {
		String[] params = new String[ar.length + 3];
		params[0] = "java";
		params[1] = "-jar";
		params[2] = opPath;

		for (int i = 0; i < ar.length; i++) {
			params[3 + i] = ar[i];
		}

		try {
			List<String> lp = Arrays.asList(params);
			ProcessBuilder p = new ProcessBuilder();
			p.command(lp);
			p.start();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
