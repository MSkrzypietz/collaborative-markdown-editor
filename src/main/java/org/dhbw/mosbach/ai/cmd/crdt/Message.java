package org.dhbw.mosbach.ai.cmd.crdt;

import org.dhbw.mosbach.ai.cmd.util.MessageType;

/**
 * A message sent by a client to the server
 *
 * @author 3040018
 */
public class Message {

    private int userId;
    private int docId;
    private int cursorPos;
    private int docState;
    private String msg;
    private MessageType messageType;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getDocId() {
        return docId;
    }

    public void setDocId(int docId) {
        this.docId = docId;
    }

    public int getCursorPos() {
        return cursorPos;
    }

    public void setCursorPos(int cursorPos) {
        this.cursorPos = cursorPos;
    }

    public int getDocState() {
        return docState;
    }

    public void setDocState(int docState) {
        this.docState = docState;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public MessageType getMessageType() {
        return messageType;
    }

    public void setMessageType(MessageType messageType) {
        this.messageType = messageType;
    }

    @Override
    public String toString() {
        return new StringBuilder()
                .append("\tuserId: " + this.userId + "\n")
                .append("\tdocId: " + this.docId + "\n")
                .append("\tmessageType: " + this.messageType.toString() + "\n")
                .append("\tcursorPos: " + this.cursorPos + "\n")
                .append("\tmsg: " + this.msg + "\n")
                .toString();
    }
}
