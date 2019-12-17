//package cn.zhangtl.zhangtlblog;
//
//import org.apache.rocketmq.client.exception.MQClientException;
//import org.apache.rocketmq.client.producer.DefaultMQProducer;
//import org.apache.rocketmq.client.producer.SendResult;
//import org.apache.rocketmq.common.message.Message;
//
//import java.util.concurrent.TimeUnit;
//
//public class RocketMqProduct {
//    public static void main(String[] args) throws Exception {
//        /*1.创建指定的生产者producter，并制定生产者组名*/
//        DefaultMQProducer producer = new DefaultMQProducer("group1");
//        /*2.指定namesrv*/
//        producer.setNamesrvAddr("127.0.0.1:9876");
//        /*4.启动producter*/
//        producer.start();
//        /*4.创建消息对象指定主题Topic，Tag和消息体*/
//        for (int i = 0; i <10 ; i++) {
//            Message test = new Message("test", "*", ("123123"+"-"+"i").getBytes());
//            /*5.发送消息*/
//            SendResult send = producer.send(test);
//            System.out.println(send.getMsgId()+"-"+send.getMessageQueue().getQueueId());
//            TimeUnit.SECONDS.sleep(1);
//        }
//        /*6.关闭生产者*/
//        producer.shutdown();
//    }
//}
