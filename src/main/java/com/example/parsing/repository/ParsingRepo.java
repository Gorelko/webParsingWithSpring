package com.example.parsing.repository;

import com.example.parsing.domain.ParsingResult;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface ParsingRepo extends JpaRepository<ParsingResult, Long> {

    @Query("SELECT p FROM ParsingResult p where p.id = ?1")
    Iterable<ParsingResult> findOneLow(int id);

    @Query(value = "SELECT * FROM parsing_result t limit 50 offset 0", nativeQuery = true)
    Iterable<ParsingResult> dataAll();

    @Transactional
    @Modifying
    @Query("UPDATE ParsingResult t SET t.brend1 = ?1, t.article_brend1 = ?2, t.brend2 = ?3, t.article_brend2 = ?4, t.description_art = ?5, t.count_dirty = ?6, t.price_dirty = ?7, t.stock = ?8, t.date_swap = ?9 WHERE t.id = ?10")
    void updateParsingLow(String brend1, String artBrend1, String brend2, String artBrend2, String description, String count, String price, String stock, String date, int id);

    @Query("SELECT distinct p.article_brend1 FROM ParsingResult p order by p.article_brend1 ASC")
    List<String> findAllArticleBrend1();

    @Query("SELECT distinct p.article_brend2 FROM ParsingResult p order by p.article_brend2 ASC")
    List<String> findAllArticleBrend2();

    @Query("SELECT distinct p.brend1 FROM ParsingResult p order by p.brend1 ASC")
    List<String> findAllBrend1();

    @Query("SELECT distinct p.brend2 FROM ParsingResult p order by p.brend2 ASC")
    List<String> findAllBrend2();

    @Query("SELECT distinct p.count_dirty FROM ParsingResult p order by p.count_dirty ASC")
    List<String> findAllCountDirty();

    @Query("SELECT distinct p.date_swap FROM ParsingResult p order by p.date_swap ASC")
    List<String> findAllDate();

    @Query("SELECT distinct p.description_art FROM ParsingResult p order by p.description_art ASC")
    List<String> findAllDescription();

    @Query("SELECT distinct p.price_dirty FROM ParsingResult p order by p.price_dirty ASC")
    List<String> findAllPriceDirty();

    @Query("SELECT distinct p.stock FROM ParsingResult p order by p.stock ASC")
    List<String> findAllStock();

    @Query("SELECT count(p) FROM ParsingResult p")
    String numberOfRowsCross();

    @Query(value = "select * from parsing_result where if(?1 = 'FILTER', brend1 IS NOT NULL, brend1 = ?1) and if(?2 = 'FILTER', brend2 IS NOT NULL, brend2 = ?2) and if(?3 = 'FILTER', article_brend1 IS NOT NULL, article_brend1 = ?3) and if(?4 = 'FILTER', article_brend2 IS NOT NULL, article_brend2 = ?4) and if(?5 = 'FILTER', count_dirty IS NOT NULL, count_dirty = ?5) and if(?6 = 'FILTER', date_swap IS NOT NULL, date_swap = ?6) and if(?7 = 'FILTER', description_art IS NOT NULL, description_art = ?7) and if(?8 = 'FILTER', price_dirty IS NOT NULL, price_dirty = ?8) and if(?9 = 'FILTER', stock IS NOT NULL, stock = ?9) limit 50 offset ?10", nativeQuery = true)
    Iterable<ParsingResult> pageWithNumber(String brend1, String brend2, String artBrend1, String artBrend2, String countDirty, String date, String description, String price, String stock, int offset);

    @Query(value = "select count(*) from parsing_result where if(?1 = 'FILTER', brend1 IS NOT NULL, brend1 = ?1) and if(?2 = 'FILTER', brend2 IS NOT NULL, brend2 = ?2) and if(?3 = 'FILTER', article_brend1 IS NOT NULL, article_brend1 = ?3) and if(?4 = 'FILTER', article_brend2 IS NOT NULL, article_brend2 = ?4) and if(?5 = 'FILTER', count_dirty IS NOT NULL, count_dirty = ?5) and if(?6 = 'FILTER', date_swap IS NOT NULL, date_swap = ?6) and if(?7 = 'FILTER', description_art IS NOT NULL, description_art = ?7) and if(?8 = 'FILTER', price_dirty IS NOT NULL, price_dirty = ?8) and if(?9 = 'FILTER', stock IS NOT NULL, stock = ?9)", nativeQuery = true)
    String countPageWithFilter(String brend1, String brend2, String artBrend1, String artBrend2, String countDirty, String date, String description, String price, String stock);

    @Transactional
    @Modifying
    @Query("DELETE FROM ParsingResult p WHERE p.id = ?1")
    void deletProduct(int deleteArr);


    @Query(value = "SELECT * FROM parsing_result t where t.article_brend1 = ?1 order by t.price_dirty limit 50 offset 0", nativeQuery = true)
    Iterable<ParsingResult> dataAllForArticle(String article);



    @Query("SELECT distinct p.brend2 FROM ParsingResult p where p.article_brend1 = ?1 order by p.brend2 ASC")
    List<String> findAllBrend2(String article);

    @Query("SELECT distinct p.article_brend2 FROM ParsingResult p where p.article_brend1 = ?1 order by p.article_brend2 ASC")
    List<String> findAllArticleBrend2(String article);

    @Query("SELECT distinct p.count_dirty FROM ParsingResult p where p.article_brend1 = ?1 order by p.count_dirty ASC")
    List<String> findAllCountDirty(String article);

    @Query("SELECT distinct p.date_swap FROM ParsingResult p where p.article_brend1 = ?1 order by p.date_swap ASC")
    List<String> findAllDate(String article);

    @Query("SELECT distinct p.description_art FROM ParsingResult p where p.article_brend1 = ?1 order by p.description_art ASC")
    List<String> findAllDescription(String article);

    @Query("SELECT distinct p.price_dirty FROM ParsingResult p where p.article_brend1 = ?1 order by p.price_dirty ASC")
    List<String> findAllPriceDirty(String article);

    @Query("SELECT distinct p.stock FROM ParsingResult p where p.article_brend1 = ?1 order by p.stock ASC")
    List<String> findAllStock(String article);

    @Query("SELECT count(p) FROM ParsingResult p where p.article_brend1 = ?1")
    String numberOfRowsCross(String article);

    @Query(value = "select * from parsing_result where article_brend1 = ?1 and  if(?2 = 'FILTER', brend2 IS NOT NULL, brend2 = ?2) and if(?3 = 'FILTER', article_brend2 IS NOT NULL, article_brend2 = ?3) and if(?4 = 'FILTER', count_dirty IS NOT NULL, count_dirty = ?4) and if(?5 = 'FILTER', date_swap IS NOT NULL, date_swap = ?5) and if(?6 = 'FILTER', description_art IS NOT NULL, description_art = ?6) and if(?7 = 'FILTER', price_dirty IS NOT NULL, price_dirty = ?7) and if(?8 = 'FILTER', stock IS NOT NULL, stock = ?8) limit 50 offset ?9", nativeQuery = true)
    Iterable<ParsingResult> pageWithNumber(String article, String brend2, String artBrend2, String countDirty, String date, String description, String price, String stock, int offset);

    @Query(value = "select count(*) from parsing_result where article_brend1 = ?1 and  if(?2 = 'FILTER', brend2 IS NOT NULL, brend2 = ?2) and if(?3 = 'FILTER', article_brend2 IS NOT NULL, article_brend2 = ?3) and if(?4 = 'FILTER', count_dirty IS NOT NULL, count_dirty = ?4) and if(?5 = 'FILTER', date_swap IS NOT NULL, date_swap = ?5) and if(?6 = 'FILTER', description_art IS NOT NULL, description_art = ?6) and if(?7 = 'FILTER', price_dirty IS NOT NULL, price_dirty = ?7) and if(?8 = 'FILTER', stock IS NOT NULL, stock = ?8)", nativeQuery = true)
    String countPageWithFilter(String article, String brend2, String artBrend1, String countDirty, String date, String description, String price, String stock);




}