package com.luv2code.ecommerce.dao;

import com.luv2code.ecommerce.entity.RazorPayUserOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RazorPayOrderRepository extends JpaRepository<RazorPayUserOrder, Long> {

    RazorPayUserOrder findByRazorpayOrderId(String orderId);
}

