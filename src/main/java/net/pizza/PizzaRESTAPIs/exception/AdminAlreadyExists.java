package net.pizza.PizzaRESTAPIs.exception;

public class AdminAlreadyExists extends RuntimeException {
    public AdminAlreadyExists(String message) {
        super(message);
    }
}
