package test;

import representation.values.StringValue;
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

	public static void main(String[] args) {
		testSerialization();
	}
}
