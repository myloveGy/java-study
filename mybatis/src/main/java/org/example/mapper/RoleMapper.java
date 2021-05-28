package org.example.mapper;

import org.example.domain.Role;

import java.util.List;

public interface RoleMapper {
    // 查询多条数据
    List<Role> findAll(Role role);

    // 查询单条数据
    Role findOne(Integer roleId);

    // 查询通过用户ID
    Role findByUserId(Integer userId);
}
