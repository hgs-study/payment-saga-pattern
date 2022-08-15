package pir.order.domain;

import javax.persistence.*;

@Entity
@Table(name = "orders")
public class Order {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String productId;

    public Order() {
    }

    public Order(String productId) {
        this.productId = productId;
    }

    public Long getId() {
        return id;
    }
}
