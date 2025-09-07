package com.buzadaeza.gagyebu.txn;

import com.buzadaeza.gagyebu.common.Enums.PaymentMethod;

import java.time.LocalDateTime;
import java.util.List;

//요청 DTO
public record CreateTxnRequest(
        String merchant,
        Long amount,
        String payerName,
        String memo,
        LocalDateTime usedAt,
        List<PaymentDetail> payments
) {
    public record PaymentDetail(PaymentMethod method, String platformCode, Long amount, Integer seqNo) {}
}
