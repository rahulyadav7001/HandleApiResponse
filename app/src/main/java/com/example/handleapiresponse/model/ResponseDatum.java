
package com.example.handleapiresponse.model;

import java.util.ArrayList;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ResponseDatum {

    @SerializedName("tot_veh")
    @Expose
    private Integer totVeh;
    @SerializedName("active")
    @Expose
    private Integer active;
    @SerializedName("inact")
    @Expose
    private Integer inact;
    @SerializedName("running")
    @Expose
    private Integer running;
    @SerializedName("stopped")
    @Expose
    private Integer stopped;
    @SerializedName("vehicles")
    @Expose
    private ArrayList<Vehicle> vehicles = null;

    public Integer getTotVeh() {
        return totVeh;
    }

    public void setTotVeh(Integer totVeh) {
        this.totVeh = totVeh;
    }

    public Integer getActive() {
        return active;
    }

    public void setActive(Integer active) {
        this.active = active;
    }

    public Integer getInact() {
        return inact;
    }

    public void setInact(Integer inact) {
        this.inact = inact;
    }

    public Integer getRunning() {
        return running;
    }

    public void setRunning(Integer running) {
        this.running = running;
    }

    public Integer getStopped() {
        return stopped;
    }

    public void setStopped(Integer stopped) {
        this.stopped = stopped;
    }

    public ArrayList<Vehicle> getVehicles() {
        return vehicles;
    }

    public void setVehicles(ArrayList<Vehicle> vehicles) {
        this.vehicles = vehicles;
    }

}
