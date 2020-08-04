package com.redesocial.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="tb_theme")
public class Theme {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String description;

    @OneToMany(mappedBy = "theme",cascade = CascadeType.ALL)
    @JsonIgnoreProperties("theme")
    private List<Postage> postage;

    public List<Postage> getPostage() {
        return postage;
    }

    public void setPostage(List<Postage> postage) {
        this.postage = postage;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
