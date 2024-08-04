package seminar02.prototype;

public class Main {
    public static void main(String[] args) {
        Message message1 = new RequestMessage("John", "Mike", "ask message1");
        message1.sendMessage();

        Message message2 = message1.clone("answer message2");
        message2.sendMessage();

        Message message3 = message2.clone("ответ получен");
        message3.sendMessage();

    }
}
