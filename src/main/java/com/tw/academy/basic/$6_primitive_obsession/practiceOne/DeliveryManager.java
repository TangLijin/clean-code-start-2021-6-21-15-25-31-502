package com.tw.academy.basic.$6_primitive_obsession.practiceOne;

public class DeliveryManager {
    private final Address toAddress;
    private final Address fromAddress;

    public DeliveryManager(Address fromAddress, Address toAddress) {
        this.toAddress = toAddress;
        this.fromAddress = fromAddress;
    }

    public DeliverCenter allocate(){
        if (isSameProvince() && isSameCity()){
            return DeliverCenter.LOCAL;
        }
        if (isSameProvince()) {
            return DeliverCenter.PROVINCE;
        }
        return DeliverCenter.FOREIGN;
    }

    private boolean isSameCity() {
        return toAddress.getCity().equals(fromAddress.getCity());
    }

    private boolean isSameProvince() {
        return toAddress.getProvince().equals(fromAddress.getProvince());
    }

}
