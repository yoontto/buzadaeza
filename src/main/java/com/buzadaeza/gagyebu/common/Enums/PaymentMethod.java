package com.buzadaeza.gagyebu.common.Enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

import java.util.Arrays;

public enum PaymentMethod {
    CARD("CARD", "카드"),
    DEBIT("DEBIT", "체크카드"),
    CASH("CASH", "현금"),
    ACCOUNT("ACCOUNT", "계좌이체"),
    POINT("POINT", "포인트");

    private final String code;
    private final String displayName;

    PaymentMethod(String code, String displayName) {
        this.code = code;
        this.displayName = displayName;
    }

    public String getCode() { return code; }
    public String getDisplayName() { return displayName; }

    // 응답(JSON)으로 나갈 때는 code로 일관 출력
    @JsonValue
    public String toJson() {
        return this.code;
    }

    // 요청(JSON)으로 들어올 때는 상수명/코드/표시명 모두 허용
    @JsonCreator(mode = JsonCreator.Mode.DELEGATING)
    public static PaymentMethod fromJson(String value) {
        if (value == null) return null;
        String v = value.trim();

        return Arrays.stream(values())
                .filter(m ->
                        m.name().equalsIgnoreCase(v) ||     // "CARD"
                                m.code.equalsIgnoreCase(v) ||       // "CARD"
                                m.displayName.equals(v)              // "카드"
                )
                .findFirst()
                .orElseThrow(() ->
                        new IllegalArgumentException("Invalid PaymentMethod: " + value)
                );
    }
}
