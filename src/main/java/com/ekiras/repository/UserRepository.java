package com.ekiras.repository;

import com.ekiras.domain.Role;
import com.ekiras.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RepositoryRestResource(exported = false)
public interface UserRepository extends JpaRepository<User, Integer> {
    @Transactional
    User findByUserName(String username);

    @Transactional
    @Query("select U from User U inner join  U.roles r where r IN (:role)")
    List<User> findUserByRole(@Param("role") Role role);

    @Transactional
    @Query("select U from User U where U.id=?1")
    User findUserById(Long userId);

    @Transactional
    @Query("select U from User U where U.employeeId=?1")
    User employeeIdExist(String empId);

    @Transactional
    @Query("select U from User U where U.userName=?1")
    User userNameExist(String userName);

    @Transactional
    @Query("select U from User U inner join  U.roles r where r.name IN ('ROLE_SALE_REP','ROLE_DATA_ENTRY','ROLE_WAREHOUSE_MANAGER')")
    List<User> findAllUsers();

    @Transactional
    @Query("select U from User U inner join  U.roles r where r.name='ROLE_SALE_REP'")
    List<User> findAllSaleRepUsers();
}
