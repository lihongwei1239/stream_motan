package org.stream.common.mongodb.dmeo.entity;

public class Member {
	
	private String id;
    private String username;
    private String password;
    private String sex;
    private String email;

    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public String getSex() {
        return sex;
    }
    public void setSex(String sex) {
        this.sex = sex;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    @Override
    public String toString() {
        return "Member [id=" + id + ", username=" + username + ", password=" + password + ", sex=" + sex + ", email="
                + email + "]";
    }

}
