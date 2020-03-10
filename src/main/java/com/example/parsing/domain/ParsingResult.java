package com.example.parsing.domain;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class ParsingResult {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;

    String brend1;
    String article_brend1;
    String brend2;
    String article_brend2;
    String description_art;
    String count_dirty;
    String price_dirty;
    String stock;
    String date_swap;


    public ParsingResult() {

    }

    public ParsingResult(String article_brend1, String brend2, String article_brend2, String description_art, String count_dirty, String price_dirty, String stock, String date_swap) {
        this.article_brend1 = article_brend1;
        this.brend2 = brend2;
        this.article_brend2 = article_brend2;
        this.description_art = description_art;
        this.count_dirty = count_dirty;
        this.price_dirty = price_dirty;
        this.stock = stock;
        this.date_swap = date_swap;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBrend1() {
        return brend1;
    }

    public void setBrend1(String brend1) {
        this.brend1 = brend1;
    }

    public String getArticle_brend1() {
        return article_brend1;
    }

    public void setArticle_brend1(String article_brend1) {
        this.article_brend1 = article_brend1;
    }

    public String getBrend2() {
        return brend2;
    }

    public void setBrend2(String brend2) {
        this.brend2 = brend2;
    }

    public String getArticle_brend2() {
        return article_brend2;
    }

    public void setArticle_brend2(String article_brend2) {
        this.article_brend2 = article_brend2;
    }

    public String getDescription_art() {
        return description_art;
    }

    public void setDescription_art(String description_art) {
        this.description_art = description_art;
    }

    public String getCount_dirty() {
        return count_dirty;
    }

    public void setCount_dirty(String count_dirty) {
        this.count_dirty = count_dirty;
    }

    public String getPrice_dirty() {
        return price_dirty;
    }

    public void setPrice_dirty(String price_dirty) {
        this.price_dirty = price_dirty;
    }

    public String getStock() {
        return stock;
    }

    public void setStock(String stock) {
        this.stock = stock;
    }

    public String getDate_swap() {
        return date_swap;
    }

    public void setDate_swap(String date_swap) {
        this.date_swap = date_swap;
    }
}
