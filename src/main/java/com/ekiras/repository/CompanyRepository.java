package com.ekiras.repository;

import com.ekiras.domain.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface CompanyRepository extends JpaRepository<Company, Integer> {

//    @Query("SELECT c FROM Company c")
//    Iterable<Company> findAll(long companyId);

//    @Query("SELECT c FROM Company c WHERE c.companyId = :companyId")
//    Company findByCompanyId(@Param("companyId") long companyId);
    
}
