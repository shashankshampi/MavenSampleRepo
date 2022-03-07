package com.example.Utils;

public enum StatusCode {
    INFORMATION(100),
    OK(200),
    MULTIPLE_CHOICE(300),
    BAD_REQUEST(400),
    INTERNAL_SERVER_ERROR(500);

    public final int status;

    private StatusCode(int status) {
        this.status = status;
    }

    public int getStatus() {
        return status;
    }
}
