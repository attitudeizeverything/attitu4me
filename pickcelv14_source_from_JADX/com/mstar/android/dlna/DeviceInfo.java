package com.mstar.android.dlna;

public class DeviceInfo {
    private String address;
    private String device_type;
    private String friendly_name;
    private String location;
    private String manufacturer;
    private String manufacturer_url;
    private String model_description;
    private String model_name;
    private String model_number;
    private String model_url;
    private int port;
    private String serial_number;
    private String udn;
    private String upc;

    public DeviceInfo(String device_type, String friendly_name, String manufacturer, String manufacturer_url, String model_description, String model_name, String model_number, String model_url, String serial_number, String udn, String upc, String location, String address, int port) {
        this.device_type = device_type;
        this.friendly_name = friendly_name;
        this.manufacturer = manufacturer;
        this.manufacturer_url = manufacturer_url;
        this.model_description = model_description;
        this.model_name = model_name;
        this.model_number = model_number;
        this.model_url = model_url;
        this.serial_number = serial_number;
        this.udn = udn;
        this.upc = upc;
        this.location = location;
        this.address = address;
        this.port = port;
    }

    public String toString() {
        return "DeviceInfo [device_type=" + this.device_type + ", friendly_name=" + this.friendly_name + ", manufacturer=" + this.manufacturer + ", manufacturer_url=" + this.manufacturer_url + ", model_description=" + this.model_description + ", model_name=" + this.model_name + ", model_number=" + this.model_number + ", model_url=" + this.model_url + ", serial_number=" + this.serial_number + ", udn=" + this.udn + ", upc=" + this.upc + ", location=" + this.location + ", address=" + this.address + ", port=" + this.port + "]";
    }

    public String getDeviceType() {
        return this.device_type;
    }

    public void setDeviceType(String device_type) {
        this.device_type = device_type;
    }

    public String getFriendlyName() {
        return this.friendly_name;
    }

    public void setFriendlyName(String friendly_name) {
        this.friendly_name = friendly_name;
    }

    public String getManufacturer() {
        return this.manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getManufacturerURL() {
        return this.manufacturer_url;
    }

    public void setManufacturerURL(String manufacturer_url) {
        this.manufacturer_url = manufacturer_url;
    }

    public String getModelDescription() {
        return this.model_description;
    }

    public void setModelDescription(String model_description) {
        this.model_description = model_description;
    }

    public String getModelName() {
        return this.model_name;
    }

    public void setModelName(String model_name) {
        this.model_name = model_name;
    }

    public String getModelNumber() {
        return this.model_number;
    }

    public void setModelNumber(String model_number) {
        this.model_number = model_number;
    }

    public String getModelURL() {
        return this.model_url;
    }

    public void setModelURL(String model_url) {
        this.model_url = model_url;
    }

    public String getSerialNumber() {
        return this.serial_number;
    }

    public void setSerialNumber(String serial_number) {
        this.serial_number = serial_number;
    }

    public String getUDN() {
        return this.udn;
    }

    public void setUDN(String udn) {
        this.udn = udn;
    }

    public String getUPC() {
        return this.upc;
    }

    public void setUPC(String upc) {
        this.upc = upc;
    }

    public String getLocation() {
        return this.location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getAddress() {
        return this.address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getPort() {
        return this.port;
    }

    public void setPort(int port) {
        this.port = port;
    }
}
