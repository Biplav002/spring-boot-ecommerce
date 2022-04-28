package com.luv2code.ecommerce.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

/**
 * The persistent class for the user_order database table.
 *
 */
@Entity
@Table(name = "razorpay_user_order")
@NoArgsConstructor
@Getter
@Setter
public class RazorPayUserOrder implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 65981149772133526L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

   // private Long userId;
   @Column
    private String razorpayPaymentId;
    @Column
    private String razorpaySignature;

    @Column(name = "razorpayOrderId")
    private String razorpayOrderId;




}
