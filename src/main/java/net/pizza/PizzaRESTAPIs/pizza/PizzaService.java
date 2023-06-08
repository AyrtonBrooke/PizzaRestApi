package net.pizza.PizzaRESTAPIs.pizza;

import java.util.List;

public interface PizzaService {
    public Integer savePizza(Pizza pizza);

    public List<Pizza> getAllPizzas();
    public Pizza getPizzaById(Integer id);
    public void deletePizza(Integer id);
}
