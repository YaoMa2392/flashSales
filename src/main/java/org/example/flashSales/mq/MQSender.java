package org.example.flashSales.mq;

import org.example.flashSales.config.RabbitMQConfig;
import org.example.flashSales.message.SecKillMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @description: 消息的发送者
 */
@Component
public class MQSender {

    private Logger logger = LoggerFactory.getLogger(this.getClass().getSimpleName());

    @Autowired
    private RabbitTemplate rabbitTemplate;

    /**
     * 发送秒杀请求消息，包含用户和商品id
     * @param secKillMessage
     */
    public void sendSecKillMessage(SecKillMessage secKillMessage) {
        logger.info("用户" + secKillMessage.getUser().getId() + "发起秒杀" + secKillMessage.getGoodsId() + "商品请求");
        rabbitTemplate.convertAndSend(RabbitMQConfig.QUEUE, secKillMessage);
    }
}