package kr.blockboard.block;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.UUID;

public class BlockDto {

    private UUID uuid;
    private String title;
    private List<UUID> assignees = new ArrayList<>();
    private String status;
    private String description;
    private final List<UUID> comments = new LinkedList<>();
    private final List<UUID> relations = new ArrayList<>();
    private LocalDateTime createDate;
    private LocalDateTime updateDate;

    public UUID getUuid() {
        return uuid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<UUID> getAssignees() {
        return assignees;
    }

    public void setAssignees(List<UUID> assignees) {
        this.assignees = assignees;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<UUID> getComments() {
        return comments;
    }

    public List<UUID> getRelations() {
        return relations;
    }

    public LocalDateTime getCreateDate() {
        return createDate;
    }

    public LocalDateTime getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(LocalDateTime updateDate) {
        this.updateDate = updateDate;
    }
}
