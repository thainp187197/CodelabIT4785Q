package com.thainp20187197.codelabit4785q.model;

import java.io.Serializable;

public class Company implements Serializable {
    private final String name;
    private final String catchPhrase;
    private final String bs;

    public Company(String name, String catchPhrase, String bs) {
        this.name = name;
        this.catchPhrase = catchPhrase;
        this.bs = bs;
    }

    public String getName() {
        return name;
    }

    public String getCatchPhrase() {
        return catchPhrase;
    }

    public String getBs() {
        return bs;
    }
}
