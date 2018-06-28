package com.example.javacohort3.ZipCodeBank.enums;

public enum BillStatus {
    PENDING("PENDING"),
    CANCELLED("CANCELLED"),
    COMPLETED("COMPLETED"),
    RECURRING("RECURRING");

    private final String value;

    BillStatus(String value) {
        this.value = value;
    }

    public static BillStatus fromValue(String value) {
        if (value != null) {
            for (BillStatus billStatus : values()) {
                if (billStatus.value.equals(value)) {
                    return billStatus;
                }
            }

        }
        return getDefault();
    }

    public String toValue() {
        return value;
    }

    public static BillStatus getDefault() {
        return PENDING;
    }
}