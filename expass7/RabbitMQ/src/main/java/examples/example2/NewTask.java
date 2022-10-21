package examples.example2;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.MessageProperties;

/**
 * Hello world!
 */
public class NewTask {
    private static final String TASK_QUEUE_NAME = "task_queue";

    public static void main(String[] args) throws Exception {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");

        try (Connection connection = factory.newConnection();
             Channel channel = connection.createChannel()) {
            boolean durable = true;
            channel.queueDeclare(TASK_QUEUE_NAME, durable, false, false, null);

            String message = String.join(" ", args);

            channel.basicPublish("", "task_queue",
                    MessageProperties.PERSISTENT_TEXT_PLAIN,
                    message.getBytes());

            System.out.println(" [x] Sent '" + message + "'");
        }

    }
}
