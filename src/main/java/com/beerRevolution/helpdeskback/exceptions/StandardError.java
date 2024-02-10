package com.beerRevolution.helpdeskback.exceptions;

import java.io.Serializable;

public class StandardError implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long timesTemp;
    private Integer status;
    private String error;
    private String message;
    private String path;

    public StandardError() {
        super();
    }

    public StandardError(Long timesTemp, Integer status, String error, String message, String path) {
        super();
        this.timesTemp = timesTemp;
        this.status = status;
        this.error = error;
        this.message = message;
        this.path = path;

    }
}
