package com.hutto.springstarter.models;

import lombok.Data;
import org.bson.types.ObjectId;

import java.util.Date;
import java.util.List;

@Data
public class Note {
    public ObjectId _id;
    public String id;
    public String note;
    public Date createDate;
    public Boolean archived;
    public List<FieldError> fieldErrors;

    @Override
    public String toString() {
        return "Note{" +
                "_id=" + _id +
                ", id='" + id + '\'' +
                ", note='" + note + '\'' +
                ", createDate=" + createDate +
                ", archived=" + archived +
                ", fieldErrors=" + fieldErrors +
                '}';
    }
}
