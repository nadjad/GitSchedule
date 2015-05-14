package test;

import java.util.Date;

import dao.DataAccess;
import datamodel.Input;
import datamodel.Task;
import datamodel.Workflow;

public class Test {

	public Test() {
		super();
		testInsertInput();
		// testInsert();
		// testDelete();
	}

	public void testInsertInput() {
		DataAccess da = new DataAccess();
		Workflow w = new Workflow();
		w.setStatus("running");
		w.setStart(new Date());
		w.setTitle("pppp2112332");
		Task t = new Task();
		t.setId(456);
		t.setStatus("running");
		t.setCommand_line("oooo3oo");
		t.setWorkflow(w);
		Input ii = new Input();
		ii.setAvailable(false);
		ii.setFilePath("poooorereroo");
		ii.setTask(t);
		da.insertInput(ii);

	}

	public void testInsert() {
		DataAccess da = new DataAccess();
		Workflow w = new Workflow();
		w.setStatus("running");
		w.setStart(new Date());
		w.setTitle("pppp211");
		da.insertWorkflow(w);
		w.setTitle("pppp139");
		da.insertWorkflow(w);
	}

	public void testDelete() {
		DataAccess da = new DataAccess();
		Workflow w = new Workflow();
		w.setStatus("running");
		w.setStart(new Date());
		w.setTitle("pppp");
		da.insertWorkflow(w);
		da.deleteWorkflow("pppp");
	}

	public static void main(String[] args) {
		new Test();
	}
}
