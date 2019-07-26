package com.uz.masters.highfieldsmarsrover.utils;

import com.uz.masters.highfieldsmarsrover.exceptions.MarsRoverClientIllegalStateException;
import org.springframework.util.Assert;

import java.util.HashMap;
import java.util.Map;

public class MessageProcessorResultContext {

    private final Map<String, Object> resultContextParameters;

    protected MessageProcessorResultContext() {
        resultContextParameters = new HashMap<>();
    }

    public static final MessageProcessorResultContext newInstance(){
        return new MessageProcessorResultContext();
    }

    public MessageProcessorResultContext addAttribute(final String attributeKey, final Object attributeValue){
        Assert.notNull(attributeKey, "Context attribute key cannot be empty or null");
        resultContextParameters.put(attributeKey, attributeValue);
        return this;
    }

    @SuppressWarnings("unchecked")
    public <T> T getAttribute(final String attributeKey){
        final Object attributeValue = resultContextParameters.get(attributeKey);
        if(attributeValue == null) {
            throw new MarsRoverClientIllegalStateException("Attribute with key " + attributeKey + " has not been set in the context");
        }
        return (T)attributeValue;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("MessageProcessorResultContext [");
        if (resultContextParameters != null)
            builder.append("resultContextParameters=").append(resultContextParameters);
        builder.append("]");
        return builder.toString();
    }
}
