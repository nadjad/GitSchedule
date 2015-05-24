package datamodel;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.Table;

@Entity
@Table(appliesTo = "tasks")
public class Task implements java.io.Serializable {
	private Integer id;
	private String id_string;
	private Workflow workflow;
	// private Integer vm_id;
	private String command_line;
	private String status;

	// private Integer same_vm_as;

	public Task(Integer id, String command_line, String status) {
		super();
		this.id = id;
		this.command_line = command_line;
		this.status = status;
	}

	public Task() {
		super();
	}

	@Id
	@Column(name = "id", unique = true, nullable = false)
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Column(name = "id_string", unique = true, nullable = false)
	public String getId_string() {
		return id_string;
	}

	public void setId_string(String id_string) {
		this.id_string = id_string;
	}

	@Column(name = "command_line", unique = false, nullable = true)
	public String getCommand_line() {
		return command_line;
	}

	public void setCommand_line(String command_line) {
		this.command_line = command_line;
	}

	@Column(name = "status", unique = false, nullable = false)
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "workflow_id", nullable = false)
	public Workflow getWorkflow() {
		return workflow;
	}

	public void setWorkflow(Workflow workflow) {
		this.workflow = workflow;
	}

}
