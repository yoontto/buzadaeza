-- payment methods
INSERT INTO payment_method (method_code, method_name) VALUES ('CARD','카드');
INSERT INTO payment_method (method_code, method_name) VALUES ('DEBIT','체크카드');
INSERT INTO payment_method (method_code, method_name) VALUES ('CASH','현금');
INSERT INTO payment_method (method_code, method_name) VALUES ('ACCOUNT','계좌이체');
INSERT INTO payment_method (method_code, method_name) VALUES ('POINT','포인트');

-- payment platforms
INSERT INTO payment_platform (platform_code, platform_name) VALUES ('NAVERPAY','네이버페이');
INSERT INTO payment_platform (platform_code, platform_name) VALUES ('KAKAOPAY','카카오페이');
INSERT INTO payment_platform (platform_code, platform_name) VALUES ('TOSS','토스페이');
INSERT INTO payment_platform (platform_code, platform_name) VALUES ('PAYCO','페이코');
