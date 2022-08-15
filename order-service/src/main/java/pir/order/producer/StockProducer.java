package pir.order.producer;

import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class StockProducer {
    private final KafkaTemplate kafkaTemplate;

    public void order(Long orderId){
        kafkaTemplate.send("order-create", orderId);
    }
}
