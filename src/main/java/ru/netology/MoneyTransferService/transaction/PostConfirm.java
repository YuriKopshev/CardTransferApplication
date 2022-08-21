package ru.netology.MoneyTransferService.transaction;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

public class PostConfirm {
    private final String operationId;
    private final String code;


    public PostConfirm(@JsonProperty("operationId") String operationId,@JsonProperty("code") String code) {
        this.operationId = operationId;
        this.code = code;
    }
    public String getOperationId() {
        return operationId;
    }

    public String getCode() {
        return code;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PostConfirm that = (PostConfirm) o;
        return operationId.equals(that.operationId) && code.equals(that.code);
    }

    @Override
    public int hashCode() {
        return Objects.hash(operationId, code);
    }

    @Override
    public String toString() {
        return operationId;
    }
}

