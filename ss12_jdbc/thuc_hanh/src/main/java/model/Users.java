package model;

public class Users {
    private int id;
    private String name;
    private String email;
    private String address;

    public Users() {
    }

    public Users(String name, String email, String address) {
        this.name = name;
        this.email = email;
        this.address = address;
    }

    public Users(int id, String name, String email, String address) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.address = address;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
