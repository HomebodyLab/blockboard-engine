package kr.blockboard.block;

import java.time.LocalDateTime;

public class Block {
	private String uuid;
	private String title;
	private String status;
	private String description;
	private LocalDateTime createDate;
	private LocalDateTime updateDate;

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	public String getUuid() {
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
}
