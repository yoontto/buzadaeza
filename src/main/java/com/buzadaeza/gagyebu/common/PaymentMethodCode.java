package com.buzadaeza.gagyebu.common;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "payment_method")
@Getter @Setter
public class PaymentMethodCode {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "method_id")
    private Long id;

    @Column(name = "method_code", nullable = false, unique = true, length = 30)
    private String code; // e.g., CARD, DEBIT, CASH, ACCOUNT, POINT

    @Column(name = "method_name", nullable = false, length = 100)
    private String name; // display name (Korean)
}
