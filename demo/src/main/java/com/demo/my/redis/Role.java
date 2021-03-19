package com.demo.my.redis;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

public class Role implements Serializable {

    private Long id;

    @JsonProperty("role_name")
    private String roleName;

    @JsonProperty("created_at")
    private String createdAt;

    public Long getId() {
        return id;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }
}
