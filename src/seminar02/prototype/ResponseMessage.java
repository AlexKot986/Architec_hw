package seminar02.prototype;

public class ResponseMessage extends Message {

    public ResponseMessage(String fromUser, String toUser, String txt) {
        super(fromUser, toUser, txt);
    }

    @Override
    public Message clone(String text) {
        return new ResponseMessage(this.getToUser(), this.getFromUser(), text);
    }

    @Override
    public void sendMessage()
    {
        System.out.println("ответ id: " + this.getId() +
                            " от " + this.getFromUser() +
                            " для " + this.getToUser() +
                            "\n          message -> " + this.getText());
    }
}
