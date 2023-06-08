package net.pizza.PizzaRESTAPIs.pizza;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/pizzaDetails")
public class PizzaController {

    @Autowired
    private PizzaService service;

    @PostMapping("/savePizza")
    public ResponseEntity<String> savePizza( @RequestBody Pizza pizza){
        Integer id = service.savePizza(pizza);
        return new ResponseEntity<String>("Pizza with '"+id+"' has been saved", HttpStatus.OK);

    }
    @GetMapping("/pizzaList")
    public ResponseEntity<List<Pizza>> getAllPizzas(){
        List<Pizza> list = service.getAllPizzas();
        return new ResponseEntity<List<Pizza>>(list,HttpStatus.OK);
    }

    @GetMapping("/getPizzaById/{id}")
    public ResponseEntity<Pizza> getPizzaById( @PathVariable("id")  Integer sno){
        Pizza std = service.getPizzaById(sno);
        return new ResponseEntity<Pizza>(std,HttpStatus.OK);
    }
    @PutMapping("/updatePizza/{id}")
    public ResponseEntity<String> updatePizza( @PathVariable("id") Integer id,  @RequestBody Pizza pizza){
        Pizza stdFromDb = service.getPizzaById(id);
        stdFromDb.setName(pizza.getName());
        stdFromDb.setDescription(pizza.getDescription());
        stdFromDb.setSmall_pizza_price(pizza.getSmall_pizza_price());
        stdFromDb.setMedium_pizza_price(pizza.getMedium_pizza_price());
        stdFromDb.setLarge_pizza_price(pizza.getLarge_pizza_price());
        stdFromDb.setCategory(pizza.getCategory());
        stdFromDb.setImage(pizza.getImage());
        stdFromDb.setCreatedAt(pizza.getCreatedAt());
        stdFromDb.setUpdatedAt(pizza.getUpdatedAt());
        service.savePizza(stdFromDb);
        return new ResponseEntity<String>("Pizza with '"+id+"' has been updated",HttpStatus.OK);
    }
    @DeleteMapping("deletePizza/{id}")
    public ResponseEntity<String> deletePizza(@PathVariable("id") Integer id){
        service.deletePizza(id);
        return new ResponseEntity<String>("Pizza with '"+id+"' has been deleted",HttpStatus.OK);
    }
}