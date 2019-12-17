//package cn.zhangtl.zhangtlblog;
//
//import org.apache.rocketmq.client.consumer.DefaultMQPushConsumer;
//import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyContext;
//import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyStatus;
//import org.apache.rocketmq.client.consumer.listener.MessageListenerConcurrently;
//import org.apache.rocketmq.common.message.MessageExt;
//
//import java.util.List;
//
//public class RocketMqConsumer {
//    public static void main(String[] args) throws Exception {
//        /*1.创建消费者consumer,制定消费者组名*/
//        DefaultMQPushConsumer group1 = new DefaultMQPushConsumer("group1");
//        /*2、制定namesrv*/
//        group1.setNamesrvAddr("127.0.0.1:9876");
//        /*3.订阅主题Topic接tag*/
//        group1.subscribe("test","*");
//        /*4.设置回调函数。处理消息*/
//        group1.registerMessageListener(new MessageListenerConcurrently() {
//            @Override
//            public ConsumeConcurrentlyStatus consumeMessage(List<MessageExt> list, ConsumeConcurrentlyContext consumeConcurrentlyContext) {
//                System.out.println(list);
//                return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
//            }
//        });
//        /*5.启动消费者*/
//        group1.start();
//    }
//}
