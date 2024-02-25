package kr.blockboard.block;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.Objects;

public class Block {
    private String uuid;
    private final String author;
    private final String type;
    private final String title;
    private final String description;
    private final String status;
    private final String assignee;
    private final double priority;
    private final String severity;
    private final Date dueDate;
    private final LocalDateTime createDate;
	private final LocalDateTime updateDate;
    private final List<LinkedBlock> linkedBlocks;
    private final boolean completed;

    // 공수관리, 일정관리(Release), 첨부파일, comment, watches, vote 등 고민...ㅠㅠ

    public Block(String uuid, String author, String type, String title, String description, String status,
                 String assignee, double priority, String severity, Date dueDate, LocalDateTime createDate,
                 LocalDateTime updateDate, List<LinkedBlock> linkedBlocks, boolean completed) {
        this.uuid = Objects.requireNonNull(uuid, "UUID cannot be null");
        this.author = Objects.requireNonNull(author, "Author cannot be null");
        this.type = Objects.requireNonNull(type, "Type cannot be null");
        this.title = Objects.requireNonNull(title, "Title cannot be null");
        this.description = description;
        this.status = Objects.requireNonNull(status, "Status cannot be null");
        this.assignee = assignee;
        this.priority = priority;
        this.severity = severity;
        this.dueDate = new Date(Objects.requireNonNull(dueDate).getTime());
        this.createDate = Objects.requireNonNull(createDate, "CreateDate cannot be null");
        this.updateDate = Objects.requireNonNull(updateDate, "UpdateDate cannot be null");
        this.linkedBlocks = linkedBlocks;
        this.completed = completed;
    }

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

    public String getUuid() {
        return uuid;
    }

    public String getAuthor() {
        return author;
    }

    public String getType() {
        return type;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getStatus() {
        return status;
    }

    public String getAssignee() {
        return assignee;
    }

    public double getPriority() {
        return priority;
    }

    public String getSeverity() {
        return severity;
    }

    public Date getDueDate() {
        return new Date(dueDate.getTime());
    }

    public LocalDateTime getCreateDate() {
        return createDate;
    }

    public LocalDateTime getUpdateDate() {
        return updateDate;
    }

    public List<LinkedBlock> getLinkedBlocks() {
        return linkedBlocks;
    }

    public boolean isCompleted() {
        return completed;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Block block = (Block) o;
        return Double.compare(block.priority, priority) == 0 &&
                completed == block.completed &&
                uuid.equals(block.uuid) &&
                author.equals(block.author) &&
                type.equals(block.type) &&
                title.equals(block.title) &&
                description.equals(block.description) &&
                status.equals(block.status) &&
                assignee.equals(block.assignee) &&
                severity.equals(block.severity) &&
                dueDate.equals(block.dueDate) &&
                createDate.equals(block.createDate) &&
                updateDate.equals(block.updateDate) &&
                linkedBlocks.equals(block.linkedBlocks);
    }

    @Override
    public int hashCode() {
        return Objects.hash(uuid, author, type, title, description, status, assignee, priority, severity,
                dueDate, createDate, updateDate, linkedBlocks, completed);
    }

    @Override
    public String toString() {
        return "Block{" +
                "uuid='" + uuid + '\'' +
                ", author='" + author + '\'' +
                ", type='" + type + '\'' +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", status='" + status + '\'' +
                ", assignee='" + assignee + '\'' +
                ", priority=" + priority +
                ", severity='" + severity + '\'' +
                ", dueDate=" + dueDate +
                ", createDate=" + createDate +
                ", updateDate=" + updateDate +
                ", linkedBlocks=" + linkedBlocks +
                ", completed=" + completed +
                '}';
    }
}
