package com.hutto.springstarter.models;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.hutto.springstarter.models.base.Base;
import lombok.Data;

import java.util.Date;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Note extends Base {
    public String id;
    public String note;
    public Date createDate;
    public Boolean archived;

    @Override
    public String toString() {
        return "Note{" +
                ", id='" + id + '\'' +
                ", note='" + note + '\'' +
                ", createDate=" + createDate +
                ", archived=" + archived +
                '}';
    }
}
