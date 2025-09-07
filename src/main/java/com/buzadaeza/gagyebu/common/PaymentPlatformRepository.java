package com.buzadaeza.gagyebu.common;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PaymentPlatformRepository extends JpaRepository<PaymentPlatform, Long> {
    Optional<PaymentPlatform> findByCode(String code);
}
