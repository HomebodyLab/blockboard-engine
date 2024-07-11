package kr.blockboard.block;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.management.relation.InvalidRoleValueException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class Block {
	private final ObjectMapper mapper = new ObjectMapper();
	private final UUID uuid;
	private String title;
	private List<UUID> assignees = new ArrayList<>();
	private String status;
	private String description;
	private final List<UUID> comments = new LinkedList<>();
	private final List<UUID> relations = new ArrayList<>();
	private final LocalDateTime createDate;
	private LocalDateTime updateDate;

	protected Block(UUID uuid, LocalDateTime createDate, LocalDateTime updateDate) {
		this.uuid = uuid;
		this.createDate = createDate;
		this.updateDate = updateDate;
	}

	public UUID getUuid() {
		return uuid;
	}

	public String getTitle() {
		return title;
	}

	public List<UUID> getAssignees() {
		return assignees;
	}

	public void addAssignee(UUID assignee) {
		for (UUID uuid : this.assignees) {
			if (uuid.equals(assignee)) {
				return;
			}
		}

		this.assignees.add(uuid);
	}

	public void addAssignees(List<UUID> assignees) {
		this.assignees.addAll(assignees);
	}

	public String getStatus() {
		return status;
	}

	public String getDescription() {
		return description;
	}

	public List<UUID> getComments() {
		return comments;
	}

	public void addComment(UUID uuid) {
		this.comments.add(uuid);
	}

	public List<UUID> getRelations() {
		return relations;
	}

	public void addRelations(UUID uuid) throws InvalidRoleValueException {
		if (this.uuid.toString().equals(uuid.toString())) {
			// You cannot add your own UUID.
			throw new InvalidRoleValueException();
		}

		this.relations.add(uuid);
	}

	public LocalDateTime getCreateDate() {
		return this.createDate;
	}

	public LocalDateTime getUpdateDate() {
		return this.updateDate;
	}

	public String toJson() throws JsonProcessingException{
		String relations = mapper.writeValueAsString(this.relations);

        return "{" +
				"uuid:\"" + uuid.toString() + "\"" +
				", title:\"" + title + "\"" +
				", status:\"" + status + "\"" +
				", description:\"" + description + "\"" +
				", relations:\"" +relations+ "/" +
				", createDate:\"" + createDate.format(DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss")) + "\"" +
				", updateDate:\"" + updateDate.format(DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss")) + "\"" +
				"}";
	}
}
