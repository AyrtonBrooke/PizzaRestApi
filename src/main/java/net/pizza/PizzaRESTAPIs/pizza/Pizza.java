package net.pizza.PizzaRESTAPIs.pizza;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "pizzas")
public class Pizza {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "name")
    private String name;
    @Column(name = "description")
    private String description;
    @Column(name = "small_pizza_price")
    private BigDecimal small_pizza_price;
    @Column(name = "medium_pizza_price")
    private BigDecimal medium_pizza_price;
    @Column(name = "large_pizza_price")
    private BigDecimal large_pizza_price;
    @Column(name = "category")
    private String category;
    @Column(name = "image")
    private String image;

    @CreationTimestamp
    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @UpdateTimestamp
    @Column(name = "updated_at", nullable = false)
    private LocalDateTime updatedAt;
}
