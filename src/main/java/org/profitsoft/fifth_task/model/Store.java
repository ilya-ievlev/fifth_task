package org.profitsoft.fifth_task.model;

import jakarta.persistence.*;

import javax.annotation.processing.Generated;
//import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "store")
public class Store {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "store")
    List<Item> itemList;


    public Store(String name, List<Item> itemList) {
        this.name = name;
        this.itemList = itemList;
    }

    public Store() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Item> getItemList() {
        return itemList;
    }

    public void setItemList(List<Item> itemList) {
        this.itemList = itemList;
    }
}
