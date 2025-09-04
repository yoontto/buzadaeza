package com.buzadaeza.gagyebu.txn;

import com.buzadaeza.gagyebu.common.PaymentMethod;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/txns")
@CrossOrigin(origins = "*")
public class TxnController {

    private final TxnRepository repo;
    public TxnController(TxnRepository repo) { this.repo = repo; }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Txn create(@RequestBody CreateTxnRequest req) {
        List<PaymentMethod> methods = req.paymentMethods();
        if (methods == null || methods.isEmpty()) {
            throw new IllegalArgumentException("결제수단은 최소 1개 이상이어야 합니다.");
        }
        if (methods.size() > 4) {
            throw new IllegalArgumentException("결제수단은 최대 4개까지 입력할 수 있습니다.");
        }
        Txn t = new Txn();
        t.setMerchant(req.merchant());
        t.setAmount(req.amount());
        t.setPaymentMethods(methods);
        return repo.save(t);
    }

    @ExceptionHandler(IllegalArgumentException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public String handleIllegalArgument(IllegalArgumentException ex) {
        return ex.getMessage();
    }
}