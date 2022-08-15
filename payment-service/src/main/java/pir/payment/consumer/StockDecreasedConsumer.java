package pir.payment.consumer;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;
import pir.payment.service.PaymentService;

import java.util.Random;

@Slf4j
@Component
@RequiredArgsConstructor
public class StockDecreasedConsumer {
    private final PaymentService paymentService;

    private static final int BETWEEN_ZERO_AND_ONE = 2;

    @KafkaListener(topics = "stock-decrease" , groupId = "group-01")
    public void payment(Long orderId){
        try {
            errorPerHalf();
            paymentService.payment();
        }catch (Exception e){
            log.error("======== [Rollback] stock-rollback, orderId :{} /, {} ======== ", orderId, e.getMessage());
            paymentService.rollbackDecreasedStock(orderId);
        }
    }

    private void errorPerHalf() {
        int zeroOrOne = new Random().nextInt(BETWEEN_ZERO_AND_ONE);

        if (zeroOrOne == 0) {
            throw new RuntimeException("Error payment module");
        }
    }
}
