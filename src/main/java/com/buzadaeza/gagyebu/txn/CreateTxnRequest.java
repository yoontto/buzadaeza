package com.buzadaeza.gagyebu.txn;

import com.buzadaeza.gagyebu.common.PaymentMethod;

import java.util.List;

//요청 DTO
public record CreateTxnRequest(String merchant, Long amount, List<PaymentMethod> paymentMethods) {}
