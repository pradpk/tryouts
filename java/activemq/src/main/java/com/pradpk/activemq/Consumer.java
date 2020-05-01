package com.pradpk.activemq;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

public class Consumer {

    private static MessageConsumer messageConsumer;
    private static Session session;
    private static Connection connection;

    public static void main(String[] a) throws JMSException {
        createSession();
        Destination destination = session.createTopic("TOPIC1");
        MessageConsumer consumer = session.createConsumer(destination);
        consumer.setMessageListener(message -> {
            System.out.println("Listener -> " + message);
        });

        //System.out.println("Message received : " + consumer.receive(1000));
    }

    private static void createSession() throws JMSException {
        ConnectionFactory connectionFactory = new ActiveMQConnectionFactory("tcp://localhost:61616");
        connection = connectionFactory.createConnection();
        connection.start();
        session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
    }

}
