package com.buzadaeza.gagyebu.common;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PaymentMethodCodeRepository extends JpaRepository<PaymentMethodCode, Long> {
    Optional<PaymentMethodCode> findByCode(String code);
}
