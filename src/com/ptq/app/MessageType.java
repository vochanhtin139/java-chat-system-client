package com.ptq.app;

public enum MessageType {
    TEXT(1), EMOJI(2), FILE(3);

    private final int value;

    public int getValue() {
        return value;
    }

    private MessageType(int value) {
        this.value = value;
    }

    public static MessageType toMessageType(int value) {
        return switch (value) {
            case 1 -> TEXT;
            case 2 -> EMOJI;
            default -> FILE;
        };
    }
}