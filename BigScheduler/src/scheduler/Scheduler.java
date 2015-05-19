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
import representation.nodes.FlowNode;
import representation.nodes.Simulation;
import scheduler.datamodel.OpElement;
import datamodel.Workflow;

public class Scheduler {

	public List<String> schedule(Simulation sim) {
		createDirectory("temp");
		FlowNode f = sim.getFlow();
		Collection<Node> nodes = f.getNodes().values();
		Workflow wf = new Workflow("pppp2112332", new Date(), "running");
		for (Node node : nodes) {
			scheduleNode(wf, node);
		}
		return null;
	}

	private void scheduleNode(Workflow wf, Node node) {
		Collection<Connection> inCons = node.getInConnections().values();
		Collection<Connection> outCons = node.getOutConnections().values();

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
