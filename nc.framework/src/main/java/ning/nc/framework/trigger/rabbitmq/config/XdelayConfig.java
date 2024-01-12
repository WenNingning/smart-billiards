package ning.nc.framework.trigger.rabbitmq.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.CustomExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ning.nc.framework.trigger.rabbitmq.TimeTriggerConfig;

import java.util.HashMap;
import java.util.Map;

/**
 * Mq 延时队列配置
 * @author Allen
 *
 */

@Configuration
public class XdelayConfig {

    /**
     * 创建一个立即消费队列
     * @return
     */
    @Bean
    public Queue immediateQueue() {
        return new Queue(TimeTriggerConfig.IMMEDIATE_QUEUE_XDELAY, true);
    }

    @Bean
    public CustomExchange delayExchange() {
        Map<String, Object> args = new HashMap<String, Object>();
        args.put("x-delayed-type", "direct");
        return new CustomExchange(TimeTriggerConfig.DELAYED_EXCHANGE_XDELAY, "x-delayed-message", true, false, args);
    }


    @Bean
    public Binding bindingNotify() {
        return BindingBuilder.bind(immediateQueue()).to(delayExchange()).with(TimeTriggerConfig.DELAY_ROUTING_KEY_XDELAY).noargs();
    }
}

