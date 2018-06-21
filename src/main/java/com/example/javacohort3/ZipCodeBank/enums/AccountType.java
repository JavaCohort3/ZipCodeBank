package com.example.javacohort3.ZipCodeBank.enums;

public enum AccountType {
    SAVINGS("Savings"),
    CHECKING("Checking"),
    CREDIT("Credit");

    private final String value;

    AccountType(String value) {
        this.value = value;
    }

    public static AccountType fromValue(String value) {
        if (value != null) {
            for (AccountType accountType : values()) {
                if (accountType.value.equals(value)) {
                    return accountType;
                }
            }
        }
        return getDefault();
        // you may return a default value
        //or
        //throw new IllegalArgumentException("Invalid Account Type: " + value);
    }

    public String toValue() {
        return value;
    }

    public static AccountType getDefault() {
        return CHECKING;
    }

}
