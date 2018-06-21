package io.elitejava3.BankAPI.enums;

public enum TransactionType {
    P2R("P2P"),
    DEPOSIT("DEPOSIT"),
    WITHDRAWAL("WITHDRAWAL");

    private final String value;

    TransactionType(String value){
        this.value = value;
    }

    public static TransactionType fromValue(String value) {
        if (value != null) {
            for (TransactionType transactionType : values()) {
                if (transactionType.value.equals(value)) {
                    return transactionType;
                }
            }
        }
        return getDefault();
    }

    public String toValue(){
        return value;
    }

    public static TransactionType getDefault() {
        return WITHDRAWAL;
    }


}
