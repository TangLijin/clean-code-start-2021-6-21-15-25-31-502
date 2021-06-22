package com.tw.academy.basic.$6_primitive_obsession.practiceOne;

public class DeliveryManager {
    String toAddress;
    String fromAddress;

    public DeliveryManager(Address fromAddress, Address toAddress) {
        this.toAddress = toAddress.getAddress();
        this.fromAddress = fromAddress.getAddress();
    }

    public DeliverCenter allocate(){
        if (getProvince(toAddress).equals(getProvince(fromAddress)) && getCity(toAddress).equals(getCity(fromAddress))){
            return DeliverCenter.LOCAL;
        }
        if (getProvince(toAddress).equals(getProvince(fromAddress))) {
            return DeliverCenter.PROVINCE;
        }
        return DeliverCenter.FOREIGN;
    }

    private String getCity(String address) {
        return address.substring(address.indexOf("省") + 1, address.indexOf("市"));
    }

    private String getProvince(String address) {
        return address.substring(0, address.indexOf("省"));
    }
}
