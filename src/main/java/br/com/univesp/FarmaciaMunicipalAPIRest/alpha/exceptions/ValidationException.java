package br.com.univesp.FarmaciaMunicipalAPIRest.alpha.exceptions;

public class ValidationException extends RuntimeException {
    public ValidationException(String message) {
        super(message);
    }
}
