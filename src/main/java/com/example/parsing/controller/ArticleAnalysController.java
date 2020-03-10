package com.example.parsing.controller;


import com.example.parsing.domain.ParsingResult;
import com.example.parsing.repository.ParsingRepo;
import com.example.parsing.repository.PriceAnalysisRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
public class ArticleAnalysController {

    @Autowired
    private PriceAnalysisRepo priceAnalysisRepo;
    @Autowired
    private ParsingRepo parsingRepo;




    @GetMapping("/articleanalysis")
    public String outData(
            @RequestParam("article") String article,
            @RequestParam("articleId") String articleId,
            Map<String, Object> model
    ) {


        model.put("article", article);
        model.put("articleId", articleId);


        Iterable<ParsingResult> outDataAll1 = parsingRepo.dataAllForArticle(article);
        model.put("outDataAll", outDataAll1);



        List<String> outDataBrend2 = parsingRepo.findAllBrend2(article);
        model.put("outDataBrend2", outDataBrend2);

        List<String> outDataArticleBrend2 = parsingRepo.findAllArticleBrend2(article);
        model.put("outDataArticleBrend2", outDataArticleBrend2);

        List<String> outDataCountDirty = parsingRepo.findAllCountDirty(article);
        model.put("outDataCountDirty", outDataCountDirty);

        List<String> outDataDescription = parsingRepo.findAllDescription(article);
        model.put("outDataDescription", outDataDescription);

        List<String> outDataDate = parsingRepo.findAllDate(article);
        model.put("outDataDate", outDataDate);

        List<String> outDataStock = parsingRepo.findAllStock(article);
        model.put("outDataStock", outDataStock);

        List<String> outDataPrice = parsingRepo.findAllPriceDirty(article);
        model.put("outDataPrice", outDataPrice);


        model.put("numberPage", "1");


        String countRowsCross = parsingRepo.numberOfRowsCross(article);
        int maxNumberPage = Integer.parseInt(countRowsCross)/50;
        List<String> numberPages = new ArrayList<>();
        for (int i = 1; i <= maxNumberPage; i++){
            numberPages.add(String.valueOf(i));
        }
        if (Integer.parseInt(countRowsCross)%50 > 0) {
            numberPages.add(String.valueOf(maxNumberPage+1));
        }
        model.put("listCountPage", numberPages);

        return "articleAnalysis";
    }

    @PostMapping("/articleanalysis")
    public String outData2(
            @RequestParam("article") String article,
            @RequestParam("articleId") String articleId,
            @RequestParam("enterPriceNew") String enterPriceNew,

            @RequestParam("outDataBrend2") String outDataBrend2,
            @RequestParam("outDataArticleBrend2") String outDataArticleBrend2,
            @RequestParam("outDataCountDirty") String outDataCountDirty,
            @RequestParam("outDataDescription") String outDataDescription,
            @RequestParam("outDataDate") String outDataDate,
            @RequestParam("outDataStock") String outDataStock,
            @RequestParam("outDataPrice") String outDataPrice,
            @RequestParam("listCountPage") String curentPage,

            @RequestParam("filterBrend2Select") String filterBrend2Select,
            @RequestParam("filterArtBrend2Select") String filterArtBrend2Select,
            @RequestParam("filterCountArtSelect") String filterCountArtSelect,
            @RequestParam("filterDescriptionSelect") String filterDescriptionSelect,
            @RequestParam("filterDateSelect") String filterDateSelect,
            @RequestParam("filterStockSelect") String filterStockSelect,
            @RequestParam("filterPriceSelect") String filterPriceSelect,




            Map<String, Object> model
    ) {






        model.put("article", article);
        model.put("articleId", articleId);

        if (outDataBrend2.equals("FILTER") && filterBrend2Select.equals("")){
            outDataBrend2 = "FILTER";
        } else if(!outDataBrend2.equals("FILTER") && !outDataBrend2.equals("") && filterBrend2Select.equals("")) {
            filterBrend2Select = outDataBrend2;
        } else if(!outDataBrend2.equals("FILTER") && !outDataBrend2.equals("") && !filterBrend2Select.equals("")) {
            filterBrend2Select = outDataBrend2;
        } else if(outDataBrend2.equals("FILTER") && !filterBrend2Select.equals("")) {
            outDataBrend2 = filterBrend2Select;
            filterBrend2Select = outDataBrend2;
        } else if(outDataBrend2.equals("") && !filterBrend2Select.equals("")) {
            outDataBrend2 = "FILTER";
            filterBrend2Select = "";
        }
        model.put("filterBrend2Select", filterBrend2Select);


        if (outDataArticleBrend2.equals("FILTER") && filterArtBrend2Select.equals("")){
            outDataArticleBrend2 = "FILTER";
        } else if(!outDataArticleBrend2.equals("FILTER") && !outDataArticleBrend2.equals("") && filterArtBrend2Select.equals("")) {
            filterArtBrend2Select = outDataArticleBrend2;
        } else if(!outDataArticleBrend2.equals("FILTER") && !outDataArticleBrend2.equals("") && !filterArtBrend2Select.equals("")) {
            filterArtBrend2Select = outDataArticleBrend2;
        } else if(outDataArticleBrend2.equals("FILTER") && !filterArtBrend2Select.equals("")) {
            outDataArticleBrend2 = filterArtBrend2Select;
            filterArtBrend2Select = outDataArticleBrend2;
        } else if(outDataArticleBrend2.equals("") && !filterArtBrend2Select.equals("")) {
            outDataArticleBrend2 = "FILTER";
            filterArtBrend2Select = "";
        }
        model.put("filterArtBrend2Select", filterArtBrend2Select);


        if (outDataCountDirty.equals("FILTER") && filterCountArtSelect.equals("")){
            outDataArticleBrend2 = "FILTER";
        } else if(!outDataCountDirty.equals("FILTER") && !outDataCountDirty.equals("") && filterCountArtSelect.equals("")) {
            filterCountArtSelect = outDataCountDirty;
        } else if(!outDataCountDirty.equals("FILTER") && !outDataCountDirty.equals("") && !filterCountArtSelect.equals("")) {
            filterCountArtSelect = outDataCountDirty;
        } else if(outDataCountDirty.equals("FILTER") && !filterCountArtSelect.equals("")) {
            outDataCountDirty = filterCountArtSelect;
            filterCountArtSelect = outDataCountDirty;
        } else if(outDataCountDirty.equals("") && !filterCountArtSelect.equals("")) {
            outDataCountDirty = "FILTER";
            filterCountArtSelect = "";
        }
        model.put("filterCountArtSelect", filterCountArtSelect);


        if (outDataDescription.equals("FILTER") && filterDescriptionSelect.equals("")){
            outDataArticleBrend2 = "FILTER";
        } else if(!outDataDescription.equals("FILTER") && !outDataDescription.equals("") && filterDescriptionSelect.equals("")) {
            filterDescriptionSelect = outDataDescription;
        } else if(!outDataDescription.equals("FILTER") && !outDataDescription.equals("") && !filterDescriptionSelect.equals("")) {
            filterDescriptionSelect = outDataDescription;
        } else if(outDataDescription.equals("FILTER") && !filterDescriptionSelect.equals("")) {
            outDataDescription = filterDescriptionSelect;
            filterDescriptionSelect = outDataDescription;
        } else if(outDataDescription.equals("") && !filterDescriptionSelect.equals("")) {
            outDataDescription = "FILTER";
            filterDescriptionSelect = "";
        }
        model.put("filterDescriptionSelect", filterDescriptionSelect);


        if (outDataDate.equals("FILTER") && filterDateSelect.equals("")){
            outDataArticleBrend2 = "FILTER";
        } else if(!outDataDate.equals("FILTER") && !outDataDate.equals("") && filterDateSelect.equals("")) {
            filterDateSelect = outDataDate;
        } else if(!outDataDate.equals("FILTER") && !outDataDate.equals("") && !filterDateSelect.equals("")) {
            filterDateSelect = outDataDate;
        } else if(outDataDate.equals("FILTER") && !filterDateSelect.equals("")) {
            outDataDate = filterDateSelect;
            filterDateSelect = outDataDate;
        } else if(outDataDate.equals("") && !filterDateSelect.equals("")) {
            outDataDate = "FILTER";
            filterDateSelect = "";
        }
        model.put("filterDateSelect", filterDateSelect);


        if (outDataStock.equals("FILTER") && filterStockSelect.equals("")){
            outDataArticleBrend2 = "FILTER";
        } else if(!outDataStock.equals("FILTER") && !outDataStock.equals("") && filterStockSelect.equals("")) {
            filterStockSelect = outDataStock;
        } else if(!outDataStock.equals("FILTER") && !outDataStock.equals("") && !filterStockSelect.equals("")) {
            filterStockSelect = outDataStock;
        } else if(outDataStock.equals("FILTER") && !filterStockSelect.equals("")) {
            outDataStock = filterStockSelect;
            filterStockSelect = outDataStock;
        } else if(outDataStock.equals("") && !filterStockSelect.equals("")) {
            outDataStock = "FILTER";
            filterStockSelect = "";
        }
        model.put("filterStockSelect", filterStockSelect);


        if (outDataPrice.equals("FILTER") && filterPriceSelect.equals("")){
            outDataArticleBrend2 = "FILTER";
        } else if(!outDataPrice.equals("FILTER") && !outDataPrice.equals("") && filterPriceSelect.equals("")) {
            filterPriceSelect = outDataPrice;
        } else if(!outDataPrice.equals("FILTER") && !outDataPrice.equals("") && !filterPriceSelect.equals("")) {
            filterPriceSelect = outDataPrice;
        } else if(outDataPrice.equals("FILTER") && !filterPriceSelect.equals("")) {
            outDataPrice = filterPriceSelect;
            filterPriceSelect = outDataPrice;
        } else if(outDataPrice.equals("") && !filterPriceSelect.equals("")) {
            outDataPrice = "FILTER";
            filterPriceSelect = "";
        }
        model.put("filterPriceSelect", filterPriceSelect);


        int numberOffset = (Integer.parseInt(curentPage) - 1) * 50;

        Iterable<ParsingResult> outDataAll = parsingRepo.pageWithNumber(article, outDataBrend2, outDataArticleBrend2, outDataCountDirty, outDataDate, outDataDescription, outDataPrice, outDataStock, numberOffset);
        model.put("outDataAll", outDataAll);

        model.put("numberPage", curentPage);


        String countRowsCross = parsingRepo.countPageWithFilter(article, outDataBrend2, outDataArticleBrend2, outDataCountDirty, outDataDate, outDataDescription, outDataPrice, outDataStock);
        model.put("outDataAll", outDataAll);
        int maxNumberPage = Integer.parseInt(countRowsCross)/50;
        List<String> numberPages = new ArrayList<>();
        for (int i = 1; i <= maxNumberPage; i++){
            numberPages.add(String.valueOf(i));
        }
        if (Integer.parseInt(countRowsCross)%50 > 0) {
            numberPages.add(String.valueOf(maxNumberPage+1));
        } else if(numberPages.size() == 0) {
            numberPages.add("1");
        }

        model.put("listCountPage", numberPages);




        List<String> filterDataArticleBrend2 = parsingRepo.findAllArticleBrend2(article);
        model.put("outDataArticleBrend2", filterDataArticleBrend2);

        List<String> filterDataBrend2 = parsingRepo.findAllBrend2(article);
        model.put("outDataBrend2", filterDataBrend2);

        List<String> filterDataCountDirty = parsingRepo.findAllCountDirty(article);
        model.put("outDataCountDirty", filterDataCountDirty);

        List<String> filterDataDescription = parsingRepo.findAllDescription(article);
        model.put("outDataDescription", filterDataDescription);

        List<String> filterDataDate = parsingRepo.findAllDate(article);
        model.put("outDataDate", filterDataDate);

        List<String> filterDataStock = parsingRepo.findAllStock(article);
        model.put("outDataStock", filterDataStock);

        List<String> filterDataPrice = parsingRepo.findAllPriceDirty(article);
        model.put("outDataPrice", filterDataPrice);

        if (!enterPriceNew.equals("")){
            priceAnalysisRepo.updatePriceNew(enterPriceNew, articleId);
        }




        return "articleAnalysis";
    }



}
