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

	protected Block(UUID uuid, String title, LocalDateTime createDate) {
		this.uuid = uuid;
		this.title = title;
		this.createDate = createDate;
		this.updateDate = createDate;
	}

	public UUID getUuid() {
		return uuid;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
		this.updateDate = LocalDateTime.now();
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
		this.updateDate = LocalDateTime.now();
	}

	public void addAssignees(List<UUID> assignees) {
		this.assignees.addAll(assignees);
		this.updateDate = LocalDateTime.now();
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
		this.updateDate = LocalDateTime.now();
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
		this.updateDate = LocalDateTime.now();
	}

	public List<UUID> getComments() {
		return comments;
	}

	public void addComment(UUID comment) {
		this.comments.add(comment);
		this.updateDate = LocalDateTime.now();
	}

	public List<UUID> getRelations() {
		return relations;
	}

	public void addRelations(UUID relation) throws InvalidRoleValueException {
		if (this.uuid.toString().equals(relation.toString())) {
			// You cannot add your own UUID.
			throw new InvalidRoleValueException();
		}

		this.relations.add(relation);
		this.updateDate = LocalDateTime.now();
	}

	public LocalDateTime getCreateDate() {
		return this.createDate;
	}

	public LocalDateTime getUpdateDate() {
		return this.updateDate;
	}

	public void blockTranstion(BlockDto blockDto) {
		this.title = blockDto.getTitle();
		this.assignees = blockDto.getAssignees();
		this.status = blockDto.getStatus();
		this.description = blockDto.getDescription();
		this.comments.addAll(blockDto.getComments());
		this.relations.addAll(blockDto.getRelations());
	}

	public String toJson() throws JsonProcessingException{
		String assignees = mapper.writeValueAsString(this.assignees);
		String comments = mapper.writeValueAsString(this.comments);
		String relations = mapper.writeValueAsString(this.relations);

        return "{" +
				"uuid:\"" + uuid.toString() + "\"" +
				", title:\"" + title + "\"" +
				", assignees:\"" + assignees + "\"" +
				", status:\"" + status + "\"" +
				", comments:\"" + comments + "\"" +
				", description:\"" + description + "\"" +
				", relations:\"" +relations+ "/" +
				", createDate:\"" + createDate.format(DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss")) + "\"" +
				", updateDate:\"" + updateDate.format(DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss")) + "\"" +
				"}";
	}
}
