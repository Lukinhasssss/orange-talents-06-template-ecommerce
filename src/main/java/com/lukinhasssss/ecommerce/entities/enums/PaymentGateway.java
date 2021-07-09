package com.lukinhasssss.ecommerce.entities.enums;

public enum PaymentGateway {

    PAYPAL, PAGSEGURO;

    private String url;

    static  {
        PAYPAL.url = "paypal.com?buyerId=";
        PAGSEGURO.url = "pagseguro.com?returnId=";
    }

    public String getUrl(Long id) {
        return this.url + id.toString() + "&redirectUrl=retornoPosPagamento";
    }

}
