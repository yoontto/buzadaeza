package com.buzadaeza.gagyebu.txn;

import com.buzadaeza.gagyebu.common.PaymentMethodCode;
import com.buzadaeza.gagyebu.common.PaymentPlatform;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "txn_payment",
       uniqueConstraints = {
           @UniqueConstraint(name = "uq_txn_seq", columnNames = {"txn_id", "seq_no"}),
           @UniqueConstraint(name = "uq_txn_method_platform", columnNames = {"txn_id", "method_id", "platform_id"})
       })
@Getter @Setter
public class TxnPayment {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "txn_payment_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "txn_id", nullable = false)
    private Txn txn;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "method_id", nullable = false)
    private PaymentMethodCode method;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "platform_id")
    private PaymentPlatform platform; // nullable

    @Column(name = "amount", nullable = false)
    private Long amount;

    @Column(name = "seq_no", nullable = false)
    private Integer seqNo;
}
