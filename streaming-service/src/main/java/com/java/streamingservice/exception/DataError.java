package com.java.streamingservice.exception;

public class DataError {
    private String message;

    public DataError(String message) {
	  this.message = message;
	}

    public String getmessage() {
      return message;
    }

    public void setmessage(String message) {
      this.message = message;
    }
}
