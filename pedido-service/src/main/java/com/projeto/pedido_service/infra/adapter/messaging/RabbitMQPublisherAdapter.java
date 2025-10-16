//package com.projeto.pedido_service.infra.adapter.messaging;
//
//import com.projeto.pedido_service.domain.PedidoCriadoEvent;
//import com.projeto.pedido_service.domain.PedidoEventPublisherPort;
//import org.springframework.amqp.rabbit.core.RabbitTemplate;
//import org.springframework.stereotype.Component;
//
//@Component
//public class RabbitMQPublisherAdapter implements PedidoEventPublisherPort {
//
//    private final RabbitTemplate rabbitTemplate;
//
//    public RabbitMQPublisherAdapter(RabbitTemplate rabbitTemplate) {
//        this.rabbitTemplate = rabbitTemplate;
//    }
//
//    @Override
//    public void publicarPedidoCriado(PedidoCriadoEvent event) {
//        rabbitTemplate.convertAndSend("pedidos.exchange", "pedido.criado", event);
//    }
//}
