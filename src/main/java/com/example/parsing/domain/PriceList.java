package com.example.parsing.domain;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class PriceList {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;

    String article;
    String grou;
    String description;
    String oldPrice;
    String newPrice;

    public PriceList() {

    }

    public PriceList(String article, String group, String description, String oldPrice, String newPrice) {
        this.article = article;
        this.grou = group;
        this.description = description;
        this.oldPrice = oldPrice;
        this.newPrice = newPrice;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getArticle() {
        return article;
    }

    public void setArticle(String article) {
        this.article = article;
    }

    public String getGrou() {
        return grou;
    }

    public void setGrou(String grou) {
        this.grou = grou;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getOldPrice() {
        return oldPrice;
    }

    public void setOldPrice(String oldPrice) {
        this.oldPrice = oldPrice;
    }

    public String getNewPrice() {
        return newPrice;
    }

    public void setNewPrice(String newPrice) {
        this.newPrice = newPrice;
    }
}
