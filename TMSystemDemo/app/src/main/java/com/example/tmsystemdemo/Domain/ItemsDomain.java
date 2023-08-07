package com.example.tmsystemdemo.Domain;

import java.io.Serializable;
import java.util.Date;

public class ItemsDomain implements Serializable {

    private String eventName;
    private String eventLocation;
    private String eventDescription;
    private String eventType;
    private String pic;


    public ItemsDomain(String eventName, String eventLocation, String eventDescription, String eventType, String pic) {
        this.eventName = eventName;
        this.eventLocation = eventLocation;
        this.eventDescription = eventDescription;
        this.eventType = eventType;
        this.pic = pic;
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public String getEventLocation() {
        return eventLocation;
    }

    public void setEventLocation(String eventLocation) {
        this.eventLocation = eventLocation;
    }

    public String getEventDescription() {
        return eventDescription;
    }

    public void setEventDescription(String eventDescription) {
        this.eventDescription = eventDescription;
    }

    public String getEventType() {
        return eventType;
    }

    public void setEventType(String eventType) {
        this.eventType = eventType;
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }
}
