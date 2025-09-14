package com.buzadaeza.gagyebu.common;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "payment_platform")
@Getter @Setter
public class PaymentPlatformCode {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "platform_id")
    private Long id;

    @Column(name = "platform_code", nullable = false, unique = true, length = 30)
    private String code; // e.g., NAVERPAY, KAKAOPAY, TOSS

    @Column(name = "platform_name", nullable = false, length = 100)
    private String name;
}
