package ru.netology.springbootdemoap2.exception;

public class UnauthorizedUser extends RuntimeException {
    public UnauthorizedUser (String msg) {
        super (msg);
    }
}
