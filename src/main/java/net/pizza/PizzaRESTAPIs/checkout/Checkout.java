package net.pizza.PizzaRESTAPIs.checkout;


import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "checkout")
public class Checkout {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "user_id")
    private Integer userId;
    @Column(name = "pizza_id")
    private Integer pizzaId;
    @Column(name = "name")
    private String name;
    @Column(name = "description")
    private String description;
    @Column(name = "pizza_price")
    private BigDecimal pizza_price;
    @Column(name = "body")
    private BigDecimal body;
    @Column(name = "phone")
    private String phone;
    @Column(name = "total")
    private BigDecimal total;
    @Column(name = "delivery_choice")
    private String delivery_choice;
    @CreationTimestamp
    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @UpdateTimestamp
    @Column(name = "updated_at", nullable = false)
    private LocalDateTime updatedAt;
}
