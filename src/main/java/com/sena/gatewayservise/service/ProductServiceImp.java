package com.sena.gatewayservise.service;

import com.google.gson.JsonElement;
import com.sena.gatewayservise.request.IProductServiceRequest;
import com.sena.gatewayservise.util.RetrofitUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class ProductServiceImp implements IProductService
{
    @Autowired
    private IProductServiceRequest productServiceRequest;

    @Override
    public JsonElement saveProduct(JsonElement requestBody)
    {
        return RetrofitUtils.executeInBlock(productServiceRequest.saveProduct(requestBody));
    }

    @Override
    public void deleteProduct(Long productId)
    {
        RetrofitUtils.executeInBlock(productServiceRequest.deleteProduct(productId));
    }

    @Override
    public List<JsonElement> getAllProducts()
    {
        return RetrofitUtils.executeInBlock(productServiceRequest.getAllProducts());
    }
}