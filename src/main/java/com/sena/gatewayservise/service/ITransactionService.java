package com.sena.gatewayservise.service;

import com.google.gson.JsonElement;

import java.util.List;

public interface ITransactionService {
    JsonElement saveTransaction(JsonElement transaction);

    void deleteTransaction(Long transactionId);

    List<JsonElement> findAllTransactionOfUser(Long userId);
}
