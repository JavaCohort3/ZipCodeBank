package io.elitejava3.BankAPI.enums;

public enum Status {
    PENDING("PENDING"),
    CANCELLED("CANCELLED"),
    COMPLETED("COMPLETED");

    private final String value;

    Status(String value){
        this.value = value;
    }

    public static Status fromValue(String value) {
        if (value != null) {
            for (Status status : values()) {
                if (status.value.equals(value)) {
                    return status;
                }
            }
        }
        return getDefault();
    }

    public String toValue(){
        return value;
    }

    public static Status getDefault() {
        return PENDING;
    }

}
