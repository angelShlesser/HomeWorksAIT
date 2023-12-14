package de.ait.movie;

public class SoldOutException extends Exception{
    public SoldOutException(String message) {
        super(message);
    }
}
