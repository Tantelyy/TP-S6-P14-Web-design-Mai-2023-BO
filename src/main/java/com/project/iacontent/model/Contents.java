package com.project.iacontent.model;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
public class Contents {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private String title;

    @Column
    private String content;

    @Column
    private Timestamp dateHour;

    @ManyToOne
    @JoinColumn(name = "idadmin")
    private Administrator admin;

    @Transient
    private Integer idAdmin;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Timestamp getDateHour() {
        return dateHour;
    }

    public void setDateHour(Timestamp dateHour) {
        this.dateHour = dateHour;
    }

    public Administrator getAdmin() {
        return admin;
    }

    public void setAdmin(Administrator admin) {
        this.admin = admin;
    }

    public Integer getIdAdmin() {
        return idAdmin;
    }

    public void setIdAdmin(Integer idAdmin) {
        this.idAdmin = idAdmin;
    }

    @Override
    public String toString() {
        return "Contents{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", dateHour=" + dateHour +
                ", admin=" + admin +
                '}';
    }
}
