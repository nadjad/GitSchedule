package test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.Arrays;
import java.util.List;

import representation.nodes.ContentNode;
import representation.values.StringValue;
import scheduler.Scheduler;
import scheduler.datamodel.Variable;
import scheduler.transfer.ValueSerializer;

public class TestRun {

	private static void testSerialization() {
		// System.out.println(ValueSerializer.serialize(new IntValue(35)));
		// System.out.println(ValueSerializer.serialize(new FloatValue(35.3f)));
		// System.out.println(ValueSerializer.serialize(new StringValue(
		// "random string")));
		ValueSerializer.serialize(new Variable("aaaa",
				new StringValue("cosmin")));
		ValueSerializer.deSerialize("aaaa");
		// System.out.println(ValueSerializer.serialize(new IntValue(35)));
		// System.out.println(ValueSerializer.serialize(new IntValue(35)));
	}

	public static void testScheduler() {
		// run the parser
		String[] params = new String[5];
		params[0] = "java";
		params[1] = "-jar";
		params[2] = "WordelParser.jar";
		params[3] = "Input.txt";
		params[4] = "simul.dat";
		try {
			List<String> lp = Arrays.asList(params);
			ProcessBuilder p = new ProcessBuilder();
			p.command(lp);
			p.start();
		} catch (Exception e) {
			e.printStackTrace();
		}

		ContentNode cn = null;
		// read the obtained simulation
		try {
			ObjectInputStream ois = new ObjectInputStream(new FileInputStream(
					new File("simul.dat")));
			cn = (ContentNode) ois.readObject();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (cn != null) {
			// System.out.println("***" + cn.getSimulation());
			Scheduler sch = new Scheduler();
			sch.schedule(cn.getSimulation());
		}
	}

	public static void main(String[] args) {
		// testSerialization();
		testScheduler();
	}
}
