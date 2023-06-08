package net.pizza.PizzaRESTAPIs.checkout;

import org.springframework.data.repository.CrudRepository;

public interface CheckoutRepository extends CrudRepository<Checkout, Integer> {
}

