package com.java.moviesservice.exception.message;

public class MovieNotRegisteredException extends RuntimeException {

    private static final long serialVersionUID = 1L;
    
    public MovieNotRegisteredException() {
      super("Movie not found!");
    }

}
