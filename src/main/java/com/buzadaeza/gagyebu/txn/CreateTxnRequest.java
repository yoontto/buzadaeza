package com.buzadaeza.gagyebu.txn;

import com.buzadaeza.gagyebu.common.PaymentMethod;

//요청 DTO
public record CreateTxnRequest(String merchant, Long amount, PaymentMethod paymentMethod) {}
