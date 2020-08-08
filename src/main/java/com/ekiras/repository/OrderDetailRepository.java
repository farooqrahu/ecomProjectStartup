
package com.ekiras.repository;

import com.ekiras.domain.OrderDetail;
import java.util.List;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 *
 * @author Louis Duong
 */
public interface OrderDetailRepository extends PagingAndSortingRepository<OrderDetail, Long> {
    
    List<OrderDetail> findAllByOrderId(Long orderId);
}
