package co.edu.uniquindio.exceptions;

public class ClienteNotFoundException extends RuntimeException {
    public ClienteNotFoundException(String message) {
        super(message);
    }
}