package com.buzadaeza.gagyebu.txn;

import com.buzadaeza.gagyebu.common.PaymentMethodCode;

import java.time.LocalDateTime;
import java.util.List;

//요청 DTO
public record CreateTxnRequest(
        String merchant,
        Long amount,
        String memo,
        LocalDateTime usedAt,
        List<PaymentDetail> payments
) {
    public record PaymentDetail(PaymentMethodCode method, Long amount, Integer seqNo) {}
}
