package Entities;

public enum User {

    ROOT(0, "Root"),
    ADMIN(1, "Admin"),
    USER(2, "User");

    public final int priority;
    public final String name;

    User(int p, String n){
        priority = p;
        name = n;
    }

}
