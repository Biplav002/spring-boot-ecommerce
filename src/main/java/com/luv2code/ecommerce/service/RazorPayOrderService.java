package com.luv2code.ecommerce.service;

import com.luv2code.ecommerce.Util.Signature;
import com.luv2code.ecommerce.dao.RazorPayOrderRepository;
import com.luv2code.ecommerce.entity.RazorPayUserOrder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Slf4j
@Service
public class RazorPayOrderService {

    @Autowired
    private RazorPayOrderRepository orderRepository;

    @Transactional
    public RazorPayUserOrder saveOrder(final String razorpayOrderId) {
        RazorPayUserOrder order = new RazorPayUserOrder();
        order.setRazorpayOrderId(razorpayOrderId);
        //order.setUserId(null);
        return orderRepository.save(order);
    }

    @Transactional
    public String validateAndUpdateOrder(final String razorpayOrderId, final String razorpayPaymentId, final String razorpaySignature, final String secret) {
        String errorMsg = null;
        try {
            RazorPayUserOrder order = orderRepository.findByRazorpayOrderId(razorpayOrderId);
            // Verify if the razorpay signature matches the generated one to
            // confirm the authenticity of the details returned
            String generatedSignature = Signature.calculateRFC2104HMAC(order.getRazorpayOrderId() + "|" + razorpayPaymentId, secret);
            if (generatedSignature.equals(razorpaySignature)) {
                order.setRazorpayOrderId(razorpayOrderId);
                order.setRazorpayPaymentId(razorpayPaymentId);
                order.setRazorpaySignature(razorpaySignature);
                orderRepository.save(order);
            } else {
                errorMsg = "Payment validation failed: Signature doesn't match";
            }
        } catch (Exception e) {
            log.error("Payment validation failed", e);
            errorMsg = e.getMessage();
        }
        return errorMsg;
    }
}
