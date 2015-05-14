package scheduler.datamodel;

import representation.values.Value;

public class Variable {
	private String name;
	private Value value;

	public Variable(String name, Value value) {
		super();
		this.name = name;
		this.value = value;
	}

	public Object getValue() {
		return value.getValue();
	}

	public Value getValueObject() {
		return value;
	}

	// public void setValue(Object value) {
	// Value val=new Valu
	// this.value = value;
	// }
	public void setValue(Value value) {
		this.value = value;
	}

	public String getName() {
		return name;
	}

}
