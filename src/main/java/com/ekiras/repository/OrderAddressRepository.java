
package com.ekiras.repository;

import com.ekiras.domain.OrderAddress;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 *
 * @author Louis Duong
 */
public interface OrderAddressRepository extends PagingAndSortingRepository<OrderAddress, Long> {
    OrderAddress findOneByOrderId(Long orderId);
}
