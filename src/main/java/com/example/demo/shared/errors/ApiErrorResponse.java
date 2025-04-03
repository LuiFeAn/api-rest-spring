package com.example.demo.shared.errors;

import java.util.List;

public class ApiErrorResponse {

    private int _statusCode;
    private String _message;
    private List<String> _causes;

    public ApiErrorResponse(int statusCode, String message, List<String> causes) {
        this._statusCode = statusCode;
        this._message = message;
        this._causes = causes;
    }

    public  int getStatusCode() {
        return _statusCode;
    }

    public  String getMessage() {
        return _message;
    }

    public  List<String> getCauses() {
        return _causes;
    }

}
