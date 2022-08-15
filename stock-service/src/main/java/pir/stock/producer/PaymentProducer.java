package pir.stock.producer;

import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class PaymentProducer {
    private final KafkaTemplate kafkaTemplate;

    public void payment(Long orderId){
        kafkaTemplate.send("stock-decrease", orderId);
    }
}
