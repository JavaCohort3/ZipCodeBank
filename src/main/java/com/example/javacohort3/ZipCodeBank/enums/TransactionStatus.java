package com.example.javacohort3.ZipCodeBank.enums;

public enum TransactionStatus {
    PENDING("PENDING"),
    CANCELLED("CANCELLED"),
    COMPLETED("COMPLETED");

    private final String value;

    TransactionStatus(String value){
        this.value = value;
    }

    public static TransactionStatus fromValue(String value) {
        if (value != null) {
            for (TransactionStatus transactionStatus : values()) {
                if (transactionStatus.value.equals(value)) {
                    return transactionStatus;
                }
            }
        }
        return getDefault();
    }

    public String toValue(){
        return value;
    }

    public static TransactionStatus getDefault() {
        return PENDING;
    }

}
