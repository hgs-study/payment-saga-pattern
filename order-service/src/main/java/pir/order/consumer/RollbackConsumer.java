package pir.order.consumer;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;
import pir.order.service.OrderService;

@Slf4j
@Component
@RequiredArgsConstructor
public class RollbackConsumer {
    private final OrderService orderService;

    @KafkaListener(topics = "order-rollback", groupId = "group-01")
    public void rollbackOrder(Long orderId){
        log.error("======== [Rollback] order-rollback, orderId :{}======== ", orderId);
        orderService.delete(orderId);
    }
}
