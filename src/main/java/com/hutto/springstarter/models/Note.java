package com.hutto.springstarter.models;

import lombok.Data;
import org.bson.types.ObjectId;

import java.util.Date;

@Data
public class Note {
    public ObjectId _id;
    public String id;
    public String note;
    public Date createDate;
    public Boolean archived;

    @Override
    public String toString() {
        return "Note{" +
                "_id=" + _id +
                ", id='" + id + '\'' +
                ", note='" + note + '\'' +
                ", createDate=" + createDate +
                ", archived=" + archived +
                '}';
    }
}
