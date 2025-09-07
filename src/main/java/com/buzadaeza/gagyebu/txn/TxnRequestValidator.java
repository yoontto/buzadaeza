package com.buzadaeza.gagyebu.txn;

import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Validator component for CreateTxnRequest.
 * Extracted from TxnController to keep controller slim and reusable.
 */
@Component
public class TxnRequestValidator {

    public void validate(CreateTxnRequest req) {
        List<CreateTxnRequest.PaymentDetail> payments = req.payments();
        if (payments == null || payments.isEmpty()) {
            throw new IllegalArgumentException("결제수단은 최소 1개 이상이어야 합니다.");
        }
        if (payments.size() > 4) {
            throw new IllegalArgumentException("결제수단은 최대 4개까지 입력할 수 있습니다.");
        }
        long sum = payments.stream().mapToLong(CreateTxnRequest.PaymentDetail::amount).sum();
        if (req.amount() == null || req.amount() <= 0) {
            throw new IllegalArgumentException("총 지출액(amount)은 0보다 커야 합니다.");
        }
        if (sum != req.amount()) {
            throw new IllegalArgumentException("결제 상세 금액 합계와 총 지출액이 일치해야 합니다.");
        }
        Set<Integer> seqSet = new HashSet<>();
        for (CreateTxnRequest.PaymentDetail p : payments) {
            if (p.amount() == null || p.amount() <= 0) {
                throw new IllegalArgumentException("각 결제 상세 금액은 0보다 커야 합니다.");
            }
            if (p.seqNo() == null || p.seqNo() < 1 || p.seqNo() > 4) {
                throw new IllegalArgumentException("seqNo는 1~4 사이여야 합니다.");
            }
            if (!seqSet.add(p.seqNo())) {
                throw new IllegalArgumentException("seqNo는 거래 내에서 중복될 수 없습니다.");
            }
        }
    }
}
