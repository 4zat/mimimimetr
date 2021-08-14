package com.example.mimimimetr.domain;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "cat_table")
public class Cat {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int catId;

    private String catName;
    private int catPoint;
    private String filename;

    public int getCatId() {
        return catId;
    }

    public void setCatId(int catId) {
        this.catId = catId;
    }

    public String getCatName() {
        return catName;
    }

    public void setCatName(String catName) {
        this.catName = catName;
    }

    public int getCatPoint() {
        return catPoint;
    }

    public void setCatPoint(int catPoint) {
        this.catPoint = catPoint;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }
}
