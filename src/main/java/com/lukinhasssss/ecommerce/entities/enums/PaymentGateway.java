package com.lukinhasssss.ecommerce.entities.enums;

public enum PaymentGateway {

    PAYPAL, PAGSEGURO;

    private String url;
    private String name;

    static  {
        PAYPAL.url = "paypal.com?buyerId=";
        PAGSEGURO.url = "pagseguro.com?returnId=";
        PAYPAL.name = "paypal";
        PAGSEGURO.name = "pagseguro";
    }

    public String getUrl(Long id) {
        return this.url + id.toString() + "&redirectUrl=" + name + "-payment";
    }

}
