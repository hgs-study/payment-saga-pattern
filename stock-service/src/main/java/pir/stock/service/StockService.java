package pir.stock.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import pir.stock.producer.OrderProducer;
import pir.stock.producer.PaymentProducer;

@Slf4j
@Service
@RequiredArgsConstructor
public class StockService {
    private final PaymentProducer paymentProducer;
    private final OrderProducer orderProducer;

    public void decrease(Long orderId){
        log.info("{}번 상품 재고 -1", orderId);
    }

    public void increase(Long orderId){
        log.info("{}번 상품 재고 +1", orderId);
    }

    public void payment(Long orderId){
        paymentProducer.payment(orderId);
    }

    public void rollbackCreatedOrder(Long orderId){
        orderProducer.rollbackCreatedOrder(orderId);
    }
}
