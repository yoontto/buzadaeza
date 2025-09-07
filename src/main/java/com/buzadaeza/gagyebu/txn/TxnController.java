package com.buzadaeza.gagyebu.txn;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import com.buzadaeza.gagyebu.common.*;

@RestController
@RequestMapping("/api/txns")
@CrossOrigin(origins = "*")
public class TxnController {

    private final TxnRepository repo;
    private final PaymentMethodCodeRepository methodRepo;
    private final PaymentPlatformRepository platformRepo;
    private final TxnRequestValidator validator;

    public TxnController(TxnRepository repo,
                         PaymentMethodCodeRepository methodRepo,
                         PaymentPlatformRepository platformRepo,
                         TxnRequestValidator validator) {
        this.repo = repo;
        this.methodRepo = methodRepo;
        this.platformRepo = platformRepo;
        this.validator = validator;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Txn create(@RequestBody CreateTxnRequest req) {
        //값 검증 먼저
        validator.validate(req);

        List<CreateTxnRequest.PaymentDetail> payments = req.payments();

        Txn t = new Txn();
        t.setMerchant(req.merchant());
        t.setAmount(req.amount());
        //t.setPayerName(req.payerName());
        t.setMemo(req.memo());
        t.setUsedAt(req.usedAt());

        for (CreateTxnRequest.PaymentDetail p : payments) {
            TxnPayment tp = new TxnPayment();
            tp.setTxn(t);
            var method = methodRepo.findByCode(p.method().getCode())
                    .orElseThrow(() -> new IllegalArgumentException("등록되지 않은 결제수단 코드: " + p.method().getCode()));
            tp.setMethod(method);
            if (p.platformCode() != null && !p.platformCode().isBlank()) {
                var platform = platformRepo.findByCode(p.platformCode())
                        .orElseThrow(() -> new IllegalArgumentException("등록되지 않은 결제 플랫폼 코드: " + p.platformCode()));
                tp.setPlatform(platform);
            }
            tp.setAmount(p.amount());
            tp.setSeqNo(p.seqNo());
            t.getPayments().add(tp);
        }
        return repo.save(t);
    }

    @ExceptionHandler(IllegalArgumentException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public String handleIllegalArgument(IllegalArgumentException ex) {
        return ex.getMessage();
    }
}