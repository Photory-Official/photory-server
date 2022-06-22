package com.photory.exception;

public class MessageFailedException extends RuntimeException {

    private static final String MESSAGE = "인증 메일 전송 실패";

    public MessageFailedException() {
        super(MESSAGE);
    }
}