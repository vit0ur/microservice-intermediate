package com.projeto.pedido_service.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {

    @Value("${broker.exchange}")
    private String exchangeName;

    @Value("${broker.queue.pedido-criado}")
    private String pedidoCriadoQueue;

    @Value("${broker.queue.estoque-atualizado}")
    private String estoqueAtualizadoQueue;

    @Bean
    public TopicExchange exchange(){
        return new TopicExchange(exchangeName);
    }
    @Bean
    public Queue pedidoCriadoQueue(){
        return new Queue(pedidoCriadoQueue, true);
    }
    @Bean
    public Queue estoqueAtualizadoQueue(){
        return new Queue(estoqueAtualizadoQueue, true);
    }

    @Bean
    public Jackson2JsonMessageConverter messageConverter() {
        ObjectMapper objectMapper = new ObjectMapper();
        return new Jackson2JsonMessageConverter(objectMapper);
    }


    @Bean
    public Binding bindingEstoqueAtualizado(){
        return BindingBuilder.bind(estoqueAtualizadoQueue()).to(exchange()).with("estoque.atualizado");
    }

    @Bean
    public Binding bindingPedidoCriado(){
        return BindingBuilder.bind(pedidoCriadoQueue()).to(exchange()).with("pedido.criado");
    }

}