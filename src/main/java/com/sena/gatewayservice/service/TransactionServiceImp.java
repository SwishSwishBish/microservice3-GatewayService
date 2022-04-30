package com.sena.gatewayservice.service;

import com.google.gson.JsonElement;
import com.sena.gatewayservice.request.ITransactionServiceRequest;
import com.sena.gatewayservice.util.RetrofitUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransactionServiceImp implements ITransactionService {

    @Autowired
    private ITransactionServiceRequest transactionServiceRequest;

    @Override
    public JsonElement saveTransaction(JsonElement transaction) {
        return RetrofitUtils.executeInBlock(transactionServiceRequest.saveTransaction(transaction));
    }

    @Override
    public void deleteTransaction(Long transactionId) {
        RetrofitUtils.executeInBlock(transactionServiceRequest.deleteTransaction(transactionId));
    }


    @Override
    public List<JsonElement> findAllTransactionOfUser(Long userId) {
        return RetrofitUtils.executeInBlock(transactionServiceRequest.findAllTransactionsOfAuthorizedUser(userId));
    }
}
