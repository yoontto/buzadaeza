package com.buzadaeza.gagyebu.txn;

import com.buzadaeza.gagyebu.common.PaymentMethod;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDateTime;

@Entity @Table(name = "txn")
@Getter @Setter
public class Txn {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 120)
    private String merchant;   // 사용처

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 20)
    private PaymentMethod paymentMethod;       // 결제수단

    @Column(nullable = false)
    private Long amount;       // 금액(원, 정수)

    @Column(nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @PrePersist
    void onCreate() { this.createdAt = LocalDateTime.now(); }
}
