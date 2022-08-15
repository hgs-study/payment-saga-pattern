package pir.stock.producer;

import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class OrderProducer {
    private final KafkaTemplate kafkaTemplate;

    public void rollbackCreatedOrder(Long orderId){
        kafkaTemplate.send("order-rollback", orderId);
    }
}
