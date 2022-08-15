package pir.stock.consumer;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;
import pir.stock.service.StockService;

@Slf4j
@Component
@RequiredArgsConstructor
public class OrderCreatedConsumer {
    private final StockService stockService;

    @KafkaListener(topics = "order-create", groupId = "group-01")
    public void decrease(Long orderId){
        try {
            stockService.decrease(orderId);
            stockService.payment(orderId);
        }catch (Exception e){
            log.error("======== [Rollback] stock-rollback, orderId :{} ======== ", orderId);
            stockService.rollbackCreatedOrder(orderId);
        }
    }
}
