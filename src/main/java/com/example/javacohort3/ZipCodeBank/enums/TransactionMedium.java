package com.example.javacohort3.ZipCodeBank.enums;

public enum TransactionMedium {
    BALANCE("BALANCE"),
    REWARDS("REWARDS");

    private final String value;

    TransactionMedium(String value){
        this.value = value;
    }

    public static TransactionMedium fromValue(String value) {
        if (value != null) {
            for (TransactionMedium transactionMedium : values()) {
                if (transactionMedium.value.equals(value)) {
                    return transactionMedium;
                }
            }
        }
        return getDefault();
    }

    public String toValue(){
        return value;
    }

    public static TransactionMedium getDefault() {
        return BALANCE;
    }

}
