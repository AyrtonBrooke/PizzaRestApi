package net.pizza.PizzaRESTAPIs.checkout;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CheckoutServiceImpl implements CheckoutService{
    @Autowired
    private CheckoutRepository checkoutRepository;
    @Override
    public List<Checkout> getAllCheckouts() {
        return (List<Checkout>) checkoutRepository.findAll();
    }
}
