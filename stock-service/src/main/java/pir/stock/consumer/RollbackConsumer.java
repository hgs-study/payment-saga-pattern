package pir.stock.consumer;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;
import pir.stock.service.StockService;

@Slf4j
@Component
@RequiredArgsConstructor
public class RollbackConsumer {
    private final StockService stockService;

    @KafkaListener(topics = "stock-rollback", groupId = "group-01")
    public void rollbackDecreaseStock(Long orderId){
        log.error("======== [Rollback] stock-rollback, orderId :{} ======== ", orderId);
        stockService.increase(orderId);
        stockService.rollbackCreatedOrder(orderId);
    }

}
