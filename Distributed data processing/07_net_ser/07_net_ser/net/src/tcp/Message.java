package tcp;

import java.io.Serializable;
import java.util.Arrays;

public class Message implements Serializable {
    public int priority;
    public String message;
    public Integer[] data = new Integer[10];
    public int portnum;

    public Message(int p, String msg, int portnum) {
        this.priority = p;
        this.message = msg;
        Arrays.fill(data, 20);
        this.portnum = portnum;//创建端口号
    }

    @Override
    public String toString() {
        return "class Message: priority=" + priority + " message=" + message + " arrays=" + Arrays.asList(data) + " portnum=" + portnum;
    }
}
