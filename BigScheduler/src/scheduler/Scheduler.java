package scheduler;

import java.io.File;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import representation.Connection;
import representation.ConnectionEnd;
import representation.Node;
import representation.Port;
import representation.nodes.FlowNode;
import representation.nodes.Simulation;
import scheduler.datamodel.OpElement;
import dao.TaskDAO;
import datamodel.Task;
import datamodel.Workflow;

public class Scheduler {
	private String BASE_PATH = "temp\\";
	private Integer io = 0;;

	public List<String> schedule(Simulation sim) {
		createDirectory("temp");
		FlowNode f = sim.getFlowNode();
		Collection<Node> nodes = f.getNodes().values();
		Workflow wf = new Workflow("test_workflow", new Date(), "running");
		for (Node node : nodes) {
			scheduleNode(wf, node);
		}
		return null;
	}

	private void scheduleNode(Workflow wf, Node node) {

		List<Port> inPortList = node.getOperatorType().getiList();
		List<Port> outPortList = node.getOperatorType().getoList();
		String inParams = "";
		// create input param list
		for (Port ip : inPortList) {
			Connection conn = node.getInConnection(ip.getName());
			if (conn != null)
				inParams = inParams + " " + BASE_PATH + conn.getConnectionId()
						+ ".itm";
		}
		System.out.println(node.getId() + ":input:" + inParams);

		// create output param list
		String outParams = "";
		for (Port op : outPortList) {
			Connection conn = node.getOutConnection(op.getName());
			if (conn != null)
				outParams = outParams + " " + BASE_PATH
						+ conn.getConnectionId() + ".itm";
		}
		System.out.println(node.getId() + ":output:" + outParams);

		// Input inFile = new Input();
		// inFile.setFilePath(BASE_PATH + "c.getConnectionId()" + ".itm");
		// inFile.setAvailable(false);
		Task t = new Task();
		t.setStatus("waiting");
		t.setId_string(node.getId());
		t.setId(io);
		io++;
		t.setCommand_line(node.getOperatorType().getName() + " " + inParams
				+ " " + outParams);

		t.setWorkflow(wf);
		TaskDAO td = new TaskDAO();
		td.insertTask(t);
		// inFile.setTask(t);
		//
		// InputDAO id = new InputDAO();
		// id.insertInput(inFile);
	}

	private Set<OpElement> getFirstLevelNodes(FlowNode flow) {
		Set<OpElement> firstLevel = new HashSet<OpElement>();
		Map<String, Connection> inConns = flow.getInConnections();
		Collection<Connection> conns = inConns.values();
		for (Connection con : conns) {
			List<ConnectionEnd> destinations = con.getDestinations();
			// for (ConnectionEnd destiantion : destinations)
			// firstLevel.add(new OpElement(destiantion.ge, identifier));
		}
		return firstLevel;
	}

	private void createDirectory(String name) {
		File theDir = new File(name);

		// if the directory does not exist, create it
		if (!theDir.exists()) {
			try {
				theDir.mkdir();
			} catch (SecurityException se) {
				System.out.println("Could not create directory " + name + "\n");
				se.printStackTrace();
			}
		}
	}
}
