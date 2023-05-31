package by.asb.mti.config.bean;

import lombok.Getter;

@Getter
public enum Token {
    ACCESS_TOKEN("at", 6000),
    REFRESH_TOKEN("rt", 60000000);

    private final String value;
    private final int expiration;

    Token(String value, int expiration) {
        this.value = value;
        this.expiration = expiration;
    }
}
