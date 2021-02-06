package com.github.saintukrainian.storebackend.exceptions;

public class ProductsNotFoundException {
    private String message;

    public ProductsNotFoundException(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
