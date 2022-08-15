package pir.order.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import pir.order.domain.Order;
import pir.order.domain.OrderRepository;
import pir.order.producer.StockProducer;

@Slf4j
@Service
@RequiredArgsConstructor
public class OrderService {
    private final OrderRepository orderRepository;
    private final StockProducer stockProducer;

    public void order(String productId){
        final Order order = new Order(productId);
        final Order newOrder = orderRepository.save(order);
        stockProducer.order(newOrder.getId());
    }

    public void delete(Long orderId){
        orderRepository.deleteById(orderId);
        log.info("{}번 주문번호 삭제", orderId);
    }
}
