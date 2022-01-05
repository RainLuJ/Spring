package com.lujun61.exception;

public class NoEnoughGoodsException extends RuntimeException{
    public NoEnoughGoodsException() {
        super();
    }

    public NoEnoughGoodsException(String message) {
        super(message);
    }
}
