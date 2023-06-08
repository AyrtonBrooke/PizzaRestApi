package net.pizza.PizzaRESTAPIs.pizza;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PizzaServiceImpl implements PizzaService{
    @Autowired
    private PizzaRepository pizzaRepository;
    @Override
    public Integer savePizza(Pizza pizza) {
        return pizzaRepository.save(pizza).getId();
    }
    @Override
    public List<Pizza> getAllPizzas() {
        return (List<Pizza>) pizzaRepository.findAll();
    }
    @Override
    public Pizza getPizzaById(Integer id) {
        return pizzaRepository.findById(id).get();
    }
    @Override
    public void deletePizza(Integer id) {
        pizzaRepository.deleteById(id);
    }
}
