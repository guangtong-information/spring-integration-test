package com.intergration.test.integration.interceptor;


import com.intergration.test.integration.transformer.HotDrinkOrder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.support.ChannelInterceptor;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

/**
 * 渠道拦截器
 */
@Slf4j
@Service
public class ChangeDrinks implements ChannelInterceptor {

    /**
     * 发送前
     *
     * @param message
     * @param channel
     * @return
     */
    @Override
    public Message<?> preSend(Message<?> message, MessageChannel channel) {
        //消息头处理
        MessageHeaders messageHeaders = message.getHeaders();
        String keep = messageHeaders.get("keep") != null ? messageHeaders.get("keep").toString() : "";
        String appname = messageHeaders.get("appname") != null ? messageHeaders.get("appname").toString() : "";
        String all = keep + "," + appname;

        //消息内容处理
        Object dirnk = message.getPayload();
        //匹配热饮后，在饮料名称前表示<加热>
        if (dirnk instanceof HotDrinkOrder) {
            log.info("[{}] 转换热饮preSend，渠道名：{}，消息：{}", all, channel, message);
            HotDrinkOrder request = (HotDrinkOrder) message.getPayload();
            request.setName("<加热>" + request.getName());
            Message<?> message1 = MessageBuilder.withPayload(request)
                    .copyHeaders(messageHeaders)
                    .build();
            return message1;
        }

        return message;
    }

    /**
     * 发送到达
     *
     * @param message 消息内容
     * @param channel 到达的消息渠道
     * @param send    发送是否成功
     */
    @Override
    public void postSend(Message<?> message, MessageChannel channel, boolean send) {
        log.info("postSend，消息：{}，渠道名：{}，发送是否成功：{}", channel, message, send);
    }

    /**
     * 发送结束
     *
     * @param message
     * @param channel
     * @param send
     * @param ex
     */
    @Override
    public void afterSendCompletion(Message<?> message, MessageChannel channel, boolean send, Exception ex) {
        log.info("afterSendCompletion，消息：{}，渠道名：{}，发送是否成功：{}，异常：{}", channel, message, send, ex);
    }

    @Override
    public boolean preReceive(MessageChannel channel) {
        log.info("preReceive，渠道名：{}", channel);
        return true;
    }

    @Override
    public Message<?> postReceive(Message<?> message, MessageChannel channel) {
        log.info("postReceive，消息：{}，渠道名：{}", channel, message);
        return message;
    }

    @Override
    public void afterReceiveCompletion(Message<?> message, MessageChannel channel, Exception ex) {
        log.info("afterReceiveCompletion，消息：{}，渠道名：{}，异常：{}", channel, message, ex);
    }


}
