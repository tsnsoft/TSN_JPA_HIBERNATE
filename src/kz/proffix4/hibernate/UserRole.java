package kz.proffix4.hibernate;

public class UserRole {

    private Integer id;
    private String name;
    private String accessCodes;

    public UserRole() {
    }

    public UserRole(String name, String accessCodes) {
        this.name = name;
        this.accessCodes = accessCodes;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAccessCodes() {
        return accessCodes;
    }

    public void setAccessCodes(String accessCodes) {
        this.accessCodes = accessCodes;
    }

    @Override
    public String toString() {
        return String.format("UserRole [id=%s, name=%s, accessCodes=%s]", id, name, accessCodes);
    }
}
