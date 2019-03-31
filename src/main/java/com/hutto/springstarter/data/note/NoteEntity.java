package com.hutto.springstarter.data.note;

import lombok.Data;
import lombok.ToString;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
@Document()
public class NoteEntity {
    @Id
    public ObjectId _id;
    public String id;
    public String note;
    public Date createDate;
    public Boolean archived;

    public NoteEntity(ObjectId _id, String id, String note, Date createDate, Boolean archived) {
        this._id = _id;
        this.id = id;
        this.note = note;
        this.createDate = createDate;
        this.archived = archived;
    }

    public NoteEntity() {
    }

    public NoteEntity(String id, String note, Date createDate, Boolean archived) {
        this(new ObjectId(),id, note, new Date(), false);
    }

    public NoteEntity(String id, String note) {
        this(id, note, new Date(), false);
    }

    public String get_id() { return _id.toHexString(); }
    public void set_id(ObjectId _id) { this._id = _id; }

    @Override
    public String toString() {
        return "NoteEntity{" +
                "_id=" + _id +
                ", id='" + id + '\'' +
                ", note='" + note + '\'' +
                ", createDate=" + createDate +
                ", archived=" + archived +
                '}';
    }
}
