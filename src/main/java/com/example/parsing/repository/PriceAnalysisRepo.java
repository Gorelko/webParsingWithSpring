package com.example.parsing.repository;

import com.example.parsing.domain.PriceList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


public interface PriceAnalysisRepo extends JpaRepository<PriceList, Long> {

    @Transactional
    @Modifying
    @Query(value = "UPDATE price_list SET price_list.new_price = ?1 WHERE price_list.id = ?2 LIMIT 3", nativeQuery = true)
    void updatePriceNew(String price, String id);


    @Query("SELECT distinct p.article FROM PriceList p order by p.article ASC")
    List<String> findAllArticle();

    @Query("SELECT distinct p.grou FROM PriceList p order by p.grou ASC")
    List<String> findAllGrou();

    @Query("SELECT distinct p.description FROM PriceList p order by p.description ASC")
    List<String> findAllDescription();

    @Query("SELECT distinct p.newPrice FROM PriceList p order by p.newPrice ASC")
    List<String> findAllNewPrice();

    @Query("SELECT distinct p.oldPrice FROM PriceList p order by p.oldPrice ASC")
    List<String> findAllOldPrice();

    @Query("SELECT count(p) FROM PriceList p")
    String numberOfRows();

    @Query(value = "select * from price_list limit 50 offset 0 ", nativeQuery = true)
    Iterable<PriceList> outFirstPagePrice();


    @Query(value = "select * from price_list t where if(?1 = 'FILTER', article IS NOT NULL, article = ?1) and if(?2 = 'FILTER', grou IS NOT NULL, grou = ?2) and if(?3 = 'FILTER', description IS NOT NULL, description = ?3) and if(?4 = 'FILTER', old_price IS NOT NULL, old_price = ?4) and if(?5 = 'FILTER', new_price IS NOT NULL, new_price = ?5) limit 50 offset ?6", nativeQuery = true)
    Iterable<PriceList> pageWithNumber(String article, String group, String description, String oldPrice, String NewPrice, int offset);

    @Query(value = "select count(*) from price_list t where if(?1 = 'FILTER', article IS NOT NULL, article = ?1) and if(?2 = 'FILTER', grou IS NOT NULL, grou = ?2) and if(?3 = 'FILTER', description IS NOT NULL, description = ?3) and if(?4 = 'FILTER', old_price IS NOT NULL, old_price = ?4) and if(?5 = 'FILTER', new_price IS NOT NULL, new_price = ?5)", nativeQuery = true)
    String countPageWithFilter(String article, String group, String description, String oldPrice, String NewPrice);


    @Transactional
    @Modifying
    @Query(value = "DELETE FROM price_list where id > 0", nativeQuery = true)
    void truncatePrice();


    @Transactional
    @Modifying
    @Query(value = "INSERT INTO price_list (article, description, grou, new_price, old_price) VALUES (?1, ?2, ?3, ?4, ?5)", nativeQuery = true)
    void savePrice(String article, String description, String grou, String new_price, String old_price);





}


