package com.buzadaeza.gagyebu.txn;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/txns")
@CrossOrigin(origins = {"http://localhost:5173", "http://localhost:3000"})
public class TxnController {

    private final TxnRepository repo;
    public TxnController(TxnRepository repo) { this.repo = repo; }

    @PostMapping
    public Txn create(@RequestBody CreateTxnRequest req) {
        Txn t = new Txn();
        t.setMerchant(req.merchant());
        t.setAmount(req.amount());
        t.setPaymentMethod(req.paymentMethod());
        return repo.save(t);
    }
}