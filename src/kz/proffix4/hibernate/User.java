package kz.proffix4.hibernate;

public class User {

    private Integer id;
    private UserRole userRole;
    private String login;
    private String password;
    private String description;
    private String note;
    private String availableDepartments;

    public User() {
    }

    public User(Integer id) {
        this.id = id;
    }

    public User(Integer id, UserRole userRole, String login) {
        this.id = id;
        this.userRole = userRole;
        this.login = login;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public UserRole getUserRole() {
        return userRole;
    }

    public void setUserRole(UserRole userRole) {
        this.userRole = userRole;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getAvailableDepartments() {
        return availableDepartments;
    }

    public void setAvailableDepartments(String availableDepartments) {
        this.availableDepartments = availableDepartments;
    }

    public String toString() {
        return String.format("роль-%d %s, логин-%s", userRole.getId(), userRole.getName(), login);
    }

}
