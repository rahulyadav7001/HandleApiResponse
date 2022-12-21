
package com.example.handleapiresponse.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Vehicle {

    @SerializedName("sr")
    @Expose
    private Integer sr;
    @SerializedName("assets_id")
    @Expose
    private String assetsId;
    @SerializedName("unitid")
    @Expose
    private String unitid;
    @SerializedName("equipment")
    @Expose
    private String equipment;
    @SerializedName("number_plate")
    @Expose
    private String numberPlate;
    @SerializedName("date_time")
    @Expose
    private String dateTime;
    @SerializedName("loc")
    @Expose
    private String loc;
    @SerializedName("odometer")
    @Expose
    private String odometer;
    @SerializedName("speed")
    @Expose
    private String speed;
    @SerializedName("ign")
    @Expose
    private String ign;
    @SerializedName("gps")
    @Expose
    private String gps;
    @SerializedName("batt")
    @Expose
    private String batt;
    @SerializedName("lat")
    @Expose
    private String lat;
    @SerializedName("lng")
    @Expose
    private String lng;
    @SerializedName("icon")
    @Expose
    private String icon;

    public Integer getSr() {
        return sr;
    }

    public void setSr(Integer sr) {
        this.sr = sr;
    }

    public String getAssetsId() {
        return assetsId;
    }

    public void setAssetsId(String assetsId) {
        this.assetsId = assetsId;
    }

    public String getUnitid() {
        return unitid;
    }

    public void setUnitid(String unitid) {
        this.unitid = unitid;
    }

    public String getEquipment() {
        return equipment;
    }

    public void setEquipment(String equipment) {
        this.equipment = equipment;
    }

    public String getNumberPlate() {
        return numberPlate;
    }

    public void setNumberPlate(String numberPlate) {
        this.numberPlate = numberPlate;
    }

    public String getDateTime() {
        return dateTime;
    }

    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }

    public String getLoc() {
        return loc;
    }

    public void setLoc(String loc) {
        this.loc = loc;
    }

    public String getOdometer() {
        return odometer;
    }

    public void setOdometer(String odometer) {
        this.odometer = odometer;
    }

    public String getSpeed() {
        return speed;
    }

    public void setSpeed(String speed) {
        this.speed = speed;
    }

    public String getIgn() {
        return ign;
    }

    public void setIgn(String ign) {
        this.ign = ign;
    }

    public String getGps() {
        return gps;
    }

    public void setGps(String gps) {
        this.gps = gps;
    }

    public String getBatt() {
        return batt;
    }

    public void setBatt(String batt) {
        this.batt = batt;
    }

    public String getLat() {
        return lat;
    }

    public void setLat(String lat) {
        this.lat = lat;
    }

    public String getLng() {
        return lng;
    }

    public void setLng(String lng) {
        this.lng = lng;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

}
