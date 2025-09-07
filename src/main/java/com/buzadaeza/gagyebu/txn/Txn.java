package com.buzadaeza.gagyebu.txn;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity @Table(name = "txn")
@Getter @Setter
public class Txn {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "txn_id")
    private Long id;

//    @Column(name = "payer_name", length = 100)
//    private String payerName;  // 결제자 이름 (옵션)

    @Column(nullable = false, length = 120)
    private String merchant;   // 사용처

    @Column(name = "used_at")
    private LocalDateTime usedAt; // 사용일시

    @Column(name = "total_amount", nullable = false)
    private Long amount;       // 총 지출액(원, 정수)

    @Column(length = 500)
    private String memo;

    @OneToMany(mappedBy = "txn", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<TxnPayment> payments = new ArrayList<>();

    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @PrePersist
    void onCreate() { this.createdAt = LocalDateTime.now(); }
}
