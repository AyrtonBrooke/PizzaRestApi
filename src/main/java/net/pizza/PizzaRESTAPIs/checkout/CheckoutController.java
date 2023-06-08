package net.pizza.PizzaRESTAPIs.checkout;

import net.pizza.PizzaRESTAPIs.pizza.Pizza;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/orders")
public class CheckoutController {
    @Autowired
    private CheckoutService service;

    @GetMapping("/checkoutList")
    public ResponseEntity<List<Checkout>> getAllCheckouts(){
        List<Checkout> list = service.getAllCheckouts();
        return new ResponseEntity<List<Checkout>>(list, HttpStatus.OK);
    }
}