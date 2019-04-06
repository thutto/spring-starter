package com.hutto.springstarter.data.note;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document()
public class NoteEntity {
    @Id
    private ObjectId _id;
    private String note;
    private Date createDate;
    private Boolean archived;

    public NoteEntity(ObjectId _id, String note, Date createDate, Boolean archived) {
        this._id = _id;
        this.note = note;
        this.createDate = createDate;
        this.archived = archived;
    }

    public NoteEntity(String id, String note, Date createDate, Boolean archived) {
        this._id = new ObjectId(id);
        this.note = note;
        this.createDate = createDate;
        this.archived = archived;
    }

    public NoteEntity() {
    }

    public NoteEntity(String note, Date createDate, Boolean archived) {
        this(new ObjectId(), note, new Date(), false);
    }

    public NoteEntity(String note) {
        this(note, new Date(), false);
    }

    public String get_id() {
        return _id.toHexString();
    }

    public void set_id(ObjectId _id) {
        this._id = _id;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Boolean getArchived() {
        return archived;
    }

    public void setArchived(Boolean archived) {
        this.archived = archived;
    }

    @Override
    public String toString() {
        return "NoteEntity{" +
                "_id=" + _id +
                ", note='" + note + '\'' +
                ", createDate=" + createDate +
                ", archived=" + archived +
                '}';
    }
}
