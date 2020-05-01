package com.pradpk.activemq;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

/**
 * Simple Java class to create a JMS message and publish it to a topic.
 */
public class Publisher {

    private static MessageProducer messageProducer;
    private static Session session;
    private static Connection connection;

    public static void main(String[] a) throws JMSException {
        System.out.println("Testing publisher...");
        createSession();
        Destination destination = session.createTopic("TOPIC1");
        Message message = session.createTextMessage("Test Message12");

        MessageProducer producer = session.createProducer(destination);
        producer.send(destination, message);
        connection.close();
    }

    private static void createSession() throws JMSException {
        ConnectionFactory connectionFactory = new ActiveMQConnectionFactory("tcp://localhost:61616");
        connection = connectionFactory.createConnection();
        connection.start();
        session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
    }

}
