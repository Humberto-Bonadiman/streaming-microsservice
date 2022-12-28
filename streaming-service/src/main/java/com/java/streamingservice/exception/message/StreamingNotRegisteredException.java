package com.java.streamingservice.exception.message;

public class StreamingNotRegisteredException extends RuntimeException {

    private static final long serialVersionUID = 1L;
    
    public StreamingNotRegisteredException() {
    	super("Streaming not found!");
    }

}
