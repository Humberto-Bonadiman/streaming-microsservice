package com.java.seriesservice.exception.message;

public class SerieNotRegisteredException extends RuntimeException {

    private static final long serialVersionUID = 1L;
    
    public SerieNotRegisteredException() {
    	super("Serie not found!");
    }
}
