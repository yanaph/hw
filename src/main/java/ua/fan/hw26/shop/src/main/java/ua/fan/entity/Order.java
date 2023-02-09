package ua.fan.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity(name = "orders")
public class Order {
    @Id
    @Column(name = "order_id")
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    private String id;
    @Column(name = "date")
    private LocalDateTime date;
    @Column(name = "total_price")
    private BigDecimal totalPrice;
    @Column
    private Integer discount;

    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "orders_goods",
            joinColumns = @JoinColumn(name = "order_id"),
            inverseJoinColumns = @JoinColumn(name = "goods_id")
    )
    private List<Goods> goods;

    public Order(Client client, List<Goods> goods, LocalDateTime date, Integer discount) {
        this.date = date;
        this.discount = discount;
        totalPrice = BigDecimal.ZERO;
        setGoods(goods);
        setClient(client);
        this.goods.forEach(goods1 -> {
            totalPrice = totalPrice.add(goods1.getPrice());
        });
        if (discount > 0) {
            totalPrice = totalPrice.multiply(BigDecimal.valueOf(100 - discount).scaleByPowerOfTen(-2));
        }

    }
}

