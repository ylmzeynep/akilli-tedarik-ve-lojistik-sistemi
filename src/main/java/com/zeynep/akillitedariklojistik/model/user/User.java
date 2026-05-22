package com.zeynep.akillitedariklojistik.model.user;

public class User {

    private String username;

    private Role role;

    public User(String username, Role role) {

        this.username = username;
        this.role = role;
    }

    public String getUsername() {
        return username;
    }

    public Role getRole() {
        return role;
    }

    public boolean isAdmin() {

        return role == Role.ADMIN;
    }

    public boolean canManageStock() {

        return role == Role.ADMIN
                || role == Role.WAREHOUSE_STAFF;
    }

    public boolean canManageCargo() {

        return role == Role.ADMIN
                || role == Role.COURIER;
    }
}