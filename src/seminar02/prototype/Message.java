package seminar02.prototype;

public abstract class Message {

    private static int counter = 0;
    private int id;
    private String fromUser;
    private String toUser;
    private String text;

    public Message(String fromUser, String toUser, String txt) {
        this.id = ++counter;
        this.fromUser = fromUser;
        this.toUser = toUser;
        this.text = txt;
    }
    public abstract Message clone(String text);

    public int getId() {
        return this.id;
    }
    public String getFromUser() {
        return this.fromUser;
    }
    public String getToUser() {
        return this.toUser;
    }
    public void setText(String text) {
        this.text = text;
    }
    public String getText() {
        return this.text;
    }

    public void sendMessage() {
        System.out.println("сообщениe id: " + this.id +
                            " от " + this.fromUser +
                            " для " + this.toUser +
                            "\n          message -> " + this.text);
    }

}
