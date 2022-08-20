package ru.netology.MoneyTransferService.transaction;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PostConfirm {
    private String operationId;
    private String code;


    public PostConfirm(String operationId, String code) {
        this.operationId = operationId;
        this.code = code;
    }

    public PostConfirm() {
    }

    public String getOperationId() {
        return operationId;
    }

    public void setOperationId(String operationId) {
        this.operationId = operationId;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}

