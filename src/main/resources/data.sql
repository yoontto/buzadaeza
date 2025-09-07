-- payment methods
INSERT INTO payment_method (method_id, method_code, method_name)
VALUES (1,'CARD','카드')
    ON DUPLICATE KEY UPDATE method_code=VALUES(method_code), method_name=VALUES(method_name);

INSERT INTO payment_method (method_id, method_code, method_name)
VALUES (2,'DEBIT','체크카드')
    ON DUPLICATE KEY UPDATE method_code=VALUES(method_code), method_name=VALUES(method_name);

INSERT INTO payment_method (method_id, method_code, method_name)
VALUES (3,'CASH','현금')
    ON DUPLICATE KEY UPDATE method_code=VALUES(method_code), method_name=VALUES(method_name);

INSERT INTO payment_method (method_id, method_code, method_name)
VALUES (4,'ACCOUNT','계좌이체')
    ON DUPLICATE KEY UPDATE method_code=VALUES(method_code), method_name=VALUES(method_name);

INSERT INTO payment_method (method_id, method_code, method_name)
VALUES (5,'POINT','포인트')
    ON DUPLICATE KEY UPDATE method_code=VALUES(method_code), method_name=VALUES(method_name);

-- payment platforms
INSERT INTO payment_platform (platform_id, platform_code, platform_name)
VALUES (1,'NAVERPAY','네이버페이')
    ON DUPLICATE KEY UPDATE platform_code=VALUES(platform_code), platform_name=VALUES(platform_name);

INSERT INTO payment_platform (platform_id, platform_code, platform_name)
VALUES (2,'KAKAOPAY','카카오페이')
    ON DUPLICATE KEY UPDATE platform_code=VALUES(platform_code), platform_name=VALUES(platform_name);

INSERT INTO payment_platform (platform_id, platform_code, platform_name)
VALUES (3,'TOSS','토스페이')
    ON DUPLICATE KEY UPDATE platform_code=VALUES(platform_code), platform_name=VALUES(platform_name);

INSERT INTO payment_platform (platform_id, platform_code, platform_name)
VALUES (4,'PAYCO','페이코')
    ON DUPLICATE KEY UPDATE platform_code=VALUES(platform_code), platform_name=VALUES(platform_name);
