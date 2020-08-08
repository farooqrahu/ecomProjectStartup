package com.ekiras.repository;

import com.ekiras.domain.ProductCategory;
import com.ekiras.domain.ProductCategoryId;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 *
 * @author NHU_LINH
 */

@Repository
@Transactional
public interface ProductCategoryRepository extends CrudRepository<ProductCategory, ProductCategoryId> {
    //todo
    Optional<ProductCategory> findById(ProductCategoryId productId);
    
    @Query("SELECT p FROM ProductCategory p WHERE p.id.productId = :productId")
    List<ProductCategory> getProCateByProductId(@Param("productId") Long productId);
}
