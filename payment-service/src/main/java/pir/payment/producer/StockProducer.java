package pir.payment.producer;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class StockProducer {
    private final KafkaTemplate kafkaTemplate;

    public void rollbackDecreasedStock(Long orderId){
        kafkaTemplate.send("stock-rollback", orderId);
    }
}
