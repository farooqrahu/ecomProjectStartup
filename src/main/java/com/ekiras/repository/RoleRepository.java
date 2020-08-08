package com.ekiras.repository;

import com.ekiras.domain.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Integer> {

	Role findByName(String name);

}
