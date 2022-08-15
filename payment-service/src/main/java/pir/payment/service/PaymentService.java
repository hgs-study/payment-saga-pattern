package pir.payment.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import pir.payment.producer.StockProducer;

@Slf4j
@Service
@RequiredArgsConstructor
public class PaymentService {
    private final StockProducer stockProducer;

    public void payment(){
        log.info("======== Start payment process!!! ======== ");
    }

    public void rollbackDecreasedStock(Long orderId){
        stockProducer.rollbackDecreasedStock(orderId);
    }
}
