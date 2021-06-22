package com.tw.academy.basic.$6_primitive_obsession.practiceOne;

public class DeliveryManager {
    private final Address toAddress;
    private final Address fromAddress;

    public DeliveryManager(Address fromAddress, Address toAddress) {
        this.toAddress = toAddress;
        this.fromAddress = fromAddress;
    }

    public DeliverCenter allocate(){
        if (getProvince(this.toAddress.getAddress()).equals(getProvince(this.fromAddress.getAddress()))
                && getCity(this.toAddress.getAddress()).equals(getCity(this.fromAddress.getAddress()))){
            return DeliverCenter.LOCAL;
        }
        if (getProvince(this.toAddress.getAddress()).equals(getProvince(this.fromAddress.getAddress()))) {
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
