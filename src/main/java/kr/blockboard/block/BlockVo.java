package kr.blockboard.block;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.UUID;

public class BlockVo {

    private UUID uuid;
    private String title;
    private List<UUID> assignees = new ArrayList<>();
    private String status;
    private String description;
    private final List<UUID> comments = new LinkedList<>();
    private final List<UUID> relations = new ArrayList<>();
    private LocalDateTime createDate;
    private LocalDateTime updateDate;

    public BlockVo(String title, List<UUID> assignees, String status, String description, LocalDateTime createDate, LocalDateTime updateDate) {
        this.uuid = UUID.randomUUID();
        this.title = title;
        this.assignees = assignees;
        this.status = status;
        this.description = description;
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

    public String getStatus() {
        return status;
    }

    public String getDescription() {
        return description;
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
}
