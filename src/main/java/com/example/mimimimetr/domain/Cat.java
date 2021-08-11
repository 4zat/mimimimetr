package com.example.mimimimetr.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
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
    private boolean bufVoice;
}
