package net.pizza.PizzaRESTAPIs.exception;

public class AdminNotFound extends RuntimeException {
    public AdminNotFound(String message) {
        super(message);
    }
}
