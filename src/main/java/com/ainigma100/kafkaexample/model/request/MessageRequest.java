package com.ainigma100.kafkaexample.model.request;

import lombok.Getter;

import java.io.Serializable;

@Getter
public class MessageRequest implements Serializable {

    private String message;

}
