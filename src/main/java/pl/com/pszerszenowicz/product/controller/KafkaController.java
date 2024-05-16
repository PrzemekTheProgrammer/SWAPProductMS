package pl.com.pszerszenowicz.product.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Component;
import pl.com.pszerszenowicz.model.ProductInfo;
import pl.com.pszerszenowicz.product.config.KafkaConfig;
import pl.com.pszerszenowicz.product.service.ScanService;

@Component
@Slf4j
public class KafkaController {

    @Autowired
    ScanService scanService;

    @KafkaListener(topics = KafkaConfig.kafkaRequest)
    @SendTo
    public ProductInfo listen(String in) {
        log.info("Received message: {}", in);
        return scanService.processScan(in);
    }

}
