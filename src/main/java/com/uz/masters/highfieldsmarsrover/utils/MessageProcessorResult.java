package com.uz.masters.highfieldsmarsrover.utils;

import java.util.HashMap;
import java.util.Map;

public class MessageProcessorResult {

    private boolean reply;
    private Map<String, Object> resultContext = new HashMap<>();
    public boolean isReply() {
        return reply;
    }
    public void setReply(boolean reply) {
        this.reply = reply;
    }
    public Map<String, Object> getResultContext() {
        return resultContext;
    }
    public void setResultContext(Map<String, Object> resultContext) {
        this.resultContext = resultContext;
    }
}
