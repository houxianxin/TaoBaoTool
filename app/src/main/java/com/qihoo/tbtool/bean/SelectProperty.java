package com.qihoo.tbtool.bean;


import com.qihoo.tbtool.dao.converter.TBPropertyConverter;

import org.greenrobot.greendao.annotation.Convert;
import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Property;

import java.util.HashMap;

@Entity
public class SelectProperty {
    @Id(autoincrement = true)
    @Property(nameInDb = "id")
    public Long id;

    @Property(nameInDb = "item_id")
    public String itemId;


    @Convert(converter = TBPropertyConverter.class, columnType = String.class)
    public HashMap<String, String> tbProperty;


    @Generated(hash = 1822150714)
    public SelectProperty(Long id, String itemId,
            HashMap<String, String> tbProperty) {
        this.id = id;
        this.itemId = itemId;
        this.tbProperty = tbProperty;
    }


    @Generated(hash = 1165645908)
    public SelectProperty() {
    }


    public Long getId() {
        return this.id;
    }


    public void setId(Long id) {
        this.id = id;
    }


    public String getItemId() {
        return this.itemId;
    }


    public void setItemId(String itemId) {
        this.itemId = itemId;
    }


    public HashMap<String, String> getTbProperty() {
        return this.tbProperty;
    }


    public void setTbProperty(HashMap<String, String> tbProperty) {
        this.tbProperty = tbProperty;
    }
}