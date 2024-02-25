import java.util.Objects;

public class LinkedBlock {
    private final String role;
    private final String id;

    public LinkedBlock(String role, String id) {
        this.role = Objects.requireNonNull(role, "Role cannot be null");
        this.id = Objects.requireNonNull(id, "ID cannot be null");
    }

    public String getRole() {
        return role;
    }

    public String getId() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LinkedBlock that = (LinkedBlock) o;
        return role.equals(that.role) &&
                id.equals(that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(role, id);
    }

    @Override
    public String toString() {
        return "LinkedBlock{" +
                "role='" + role + '\'' +
                ", id='" + id + '\'' +
                '}';
    }
}
