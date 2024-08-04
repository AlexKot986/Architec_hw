package seminar02.prototype;

public class RequestMessage extends Message {

    public RequestMessage(String fromUser, String toUser, String txt) {
        super(fromUser, toUser, txt);
    }

    @Override
    public Message clone(String text) {
        return new ResponseMessage(this.getToUser(), this.getFromUser(), text);
    }
}
