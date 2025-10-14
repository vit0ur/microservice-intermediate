package com.projeto.produto_persistence_service.config;

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

    @Value("${broker.queue.produto-salvar}")
    private String produtoSalvar;

    @Value("${broker.queue.produto-salvo}")
    private String produtoSalvo;

    @Value("${broker.queue.produto-reservar}")
    private String produtoReservar;

    @Value("${broker.queue.estoque-resultado}")
    private String estoqueResultado;

    @Bean
    public TopicExchange produtoExchange(){
        return new TopicExchange(exchangeName);
    }

    @Bean
    public Queue produtoSalvoQueue(){
        return new Queue(produtoSalvo,true);
    }

    @Bean
    public Queue produtoSalvarQueue(){
        return new Queue(produtoSalvar,true);
    }

    @Bean
    public Queue produtoReservarQueue(){
        return new Queue(produtoReservar,true);
    }

    @Bean
    public Queue estoqueResultadoQueue(){
        return new Queue(estoqueResultado,true);
    }

    @Bean
    public Binding bindinProdutoSalvar(){
        return BindingBuilder.bind(produtoSalvarQueue()).to(produtoExchange()).with("produto-salvar");
    }
    @Bean
    public Binding bindinEstoqueResultado(){
        return BindingBuilder.bind(estoqueResultadoQueue()).to(produtoExchange()).with("estoque-resultado");
    }

    @Bean
    public Binding bindinprodutoReservar(){
        return BindingBuilder.bind(produtoReservarQueue()).to(produtoExchange()).with("produto-reserver");
    }

    @Bean
    public Binding bindinProdutoSalvo(){
        return BindingBuilder.bind(produtoSalvoQueue()).to(produtoExchange()).with("produto-salvo");
    }

    @Bean
    public Jackson2JsonMessageConverter messageConverter() {
        ObjectMapper objectMapper = new ObjectMapper();
        return new Jackson2JsonMessageConverter(objectMapper);
    }
}