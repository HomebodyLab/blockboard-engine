package kr.blockboard.block;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.UUID;

public class Block {
	private UUID uuid;
	private String title;
	private String status;
	private String description;
	private String relation;
	private LocalDateTime createDate;
	private LocalDateTime updateDate;

	public void setUuid(UUID uuid) {
		this.uuid = uuid;
	}

	public UUID getUuid() {
		return uuid;
	}

	public String getTitle() {
		return title;
	}

	public String getStatus() {
		return status;
	}

	public String getDescription() {
		return description;
	}

	public LocalDateTime getCreateDate() {
		return createDate;
	}

	public LocalDateTime getUpdateDate() {
		return updateDate;
	}

	public String toJson() {
		return "{" +
				"uuid:\"" + uuid.toString() + "\"" +
				", title:'" + title + "\"" +
				", status:'" + status + "\"" +
				", description:'" + description + "\"" +
				", createDate:" + createDate.format(DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss")) +
				", updateDate:" + updateDate.format(DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss")) +
				'}';
	}
}
