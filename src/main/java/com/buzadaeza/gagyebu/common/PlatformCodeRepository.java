package com.buzadaeza.gagyebu.common;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface PlatformCodeRepository extends JpaRepository<PaymentPlatformCode, Long> {
    Optional<PaymentPlatformCode> findByCode(String code);
}
