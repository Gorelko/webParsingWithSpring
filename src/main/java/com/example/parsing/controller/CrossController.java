package com.example.parsing.controller;

import com.example.parsing.domain.ParsingResult;
import com.example.parsing.repository.ParsingRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
public class CrossController {

    @Autowired
    private ParsingRepo parsingRepo;

    @GetMapping("/analysisCross")
    public String outData(Map<String, Object> model) {

        Iterable<ParsingResult> outDataAll = parsingRepo.dataAll();
        model.put("outDataAll", outDataAll);

        List<String> outDataArticleBrend1 = parsingRepo.findAllArticleBrend1();
        model.put("outDataArticleBrend1", outDataArticleBrend1);

        List<String> outDataArticleBrend2 = parsingRepo.findAllArticleBrend2();
        model.put("outDataArticleBrend2", outDataArticleBrend2);

        List<String> outDataBrend1 = parsingRepo.findAllBrend1();
        model.put("outDataBrend1", outDataBrend1);

        List<String> outDataBrend2 = parsingRepo.findAllBrend2();
        model.put("outDataBrend2", outDataBrend2);

        List<String> outDataCountDirty = parsingRepo.findAllCountDirty();
        model.put("outDataCountDirty", outDataCountDirty);

        List<String> outDataDescription = parsingRepo.findAllDescription();
        model.put("outDataDescription", outDataDescription);

        List<String> outDataDate = parsingRepo.findAllDate();
        model.put("outDataDate", outDataDate);

        List<String> outDataStock = parsingRepo.findAllStock();
        model.put("outDataStock", outDataStock);

        List<String> outDataPrice = parsingRepo.findAllPriceDirty();
        model.put("outDataPrice", outDataPrice);

        model.put("numberPage", "1");

        String countRowsCross = parsingRepo.numberOfRowsCross();
        int maxNumberPage = Integer.parseInt(countRowsCross)/50;
        List<String> numberPages = new ArrayList<>();
        for (int i = 1; i <= maxNumberPage; i++){
            numberPages.add(String.valueOf(i));
        }
        if (Integer.parseInt(countRowsCross)%50 > 0) {
            numberPages.add(String.valueOf(maxNumberPage+1));
        }
        model.put("listCountPage", numberPages);


        return "analysisCross";
    }



    @PostMapping("/analysisCross")
    public String outData2(
            @RequestParam("outDataBrend1") String outDataBrend1,
            @RequestParam("outDataBrend2") String outDataBrend2,
            @RequestParam("outDataArticleBrend1") String outDataArticleBrend1,
            @RequestParam("outDataArticleBrend2") String outDataArticleBrend2,
            @RequestParam("outDataCountDirty") String outDataCountDirty,
            @RequestParam("outDataDescription") String outDataDescription,
            @RequestParam("outDataDate") String outDataDate,
            @RequestParam("outDataStock") String outDataStock,
            @RequestParam("outDataPrice") String outDataPrice,
            @RequestParam("listCountPage") String curentPage,

            @RequestParam("filterBrend1Select") String filterBrend1Select,
            @RequestParam("filterBrend2Select") String filterBrend2Select,
            @RequestParam("filterArtBrend1Select") String filterArtBrend1Select,
            @RequestParam("filterArtBrend2Select") String filterArtBrend2Select,
            @RequestParam("filterCountArtSelect") String filterCountArtSelect,
            @RequestParam("filterDescriptionSelect") String filterDescriptionSelect,
            @RequestParam("filterDateSelect") String filterDateSelect,
            @RequestParam("filterStockSelect") String filterStockSelect,
            @RequestParam("filterPriceSelect") String filterPriceSelect,

            @RequestParam(value = "checkDel[]", required=false, defaultValue="" ) String checkDelete [],


            Map<String, Object> model
    ) {

        if (checkDelete.length > 0) {
                for (int i = 0; i < checkDelete.length; i++){
                    parsingRepo.deletProduct(Integer.parseInt(checkDelete[i]));
                }
            }

        checkDelete = null;



        if (outDataBrend1.equals("FILTER") && filterBrend1Select.equals("")){
            outDataBrend1 = "FILTER";
        } else if(!outDataBrend1.equals("FILTER") && !outDataBrend1.equals("") && filterBrend1Select.equals("")) {
            filterBrend1Select = outDataBrend1;
        } else if(!outDataBrend1.equals("FILTER") && !outDataBrend1.equals("") && !filterBrend1Select.equals("")) {
            filterBrend1Select = outDataBrend1;
        } else if(outDataBrend1.equals("FILTER") && !filterBrend1Select.equals("")) {
            outDataBrend1 = filterBrend1Select;
            filterBrend1Select = outDataBrend1;
        } else if(outDataBrend1.equals("") && !filterBrend1Select.equals("")) {
            outDataBrend1 = "FILTER";
            filterBrend1Select = "";
        }
         model.put("filterBrend1Select", filterBrend1Select);


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


        if (outDataArticleBrend1.equals("FILTER") && filterArtBrend1Select.equals("")){
            outDataArticleBrend1 = "FILTER";
        } else if(!outDataArticleBrend1.equals("FILTER") && !outDataArticleBrend1.equals("") && filterArtBrend1Select.equals("")) {
            filterArtBrend1Select = outDataArticleBrend1;
        } else if(!outDataArticleBrend1.equals("FILTER") && !outDataArticleBrend1.equals("") && !filterArtBrend1Select.equals("")) {
            filterArtBrend1Select = outDataArticleBrend1;
        } else if(outDataArticleBrend1.equals("FILTER") && !filterArtBrend1Select.equals("")) {
            outDataArticleBrend1 = filterArtBrend1Select;
            filterArtBrend1Select = outDataArticleBrend1;
        } else if(outDataArticleBrend1.equals("") && !filterArtBrend1Select.equals("")) {
            outDataArticleBrend1 = "FILTER";
            filterArtBrend1Select = "";
        }
        model.put("filterArtBrend1Select", filterArtBrend1Select);


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

        Iterable<ParsingResult> outDataAll = parsingRepo.pageWithNumber(outDataBrend1, outDataBrend2, outDataArticleBrend1, outDataArticleBrend2, outDataCountDirty, outDataDate, outDataDescription, outDataPrice, outDataStock, numberOffset);
        model.put("outDataAll", outDataAll);



        model.put("numberPage", curentPage);

        String countRowsCross = parsingRepo.countPageWithFilter(outDataBrend1, outDataBrend2, outDataArticleBrend1, outDataArticleBrend2, outDataCountDirty, outDataDate, outDataDescription, outDataPrice, outDataStock);
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


        List<String> filterDataArticleBrend1 = parsingRepo.findAllArticleBrend1();
        model.put("outDataArticleBrend1", filterDataArticleBrend1);

        List<String> filterDataArticleBrend2 = parsingRepo.findAllArticleBrend2();
        model.put("outDataArticleBrend2", filterDataArticleBrend2);

        List<String> filterDataBrend1 = parsingRepo.findAllBrend1();
        model.put("outDataBrend1", filterDataBrend1);

        List<String> filterDataBrend2 = parsingRepo.findAllBrend2();
        model.put("outDataBrend2", filterDataBrend2);

        List<String> filterDataCountDirty = parsingRepo.findAllCountDirty();
        model.put("outDataCountDirty", filterDataCountDirty);

        List<String> filterDataDescription = parsingRepo.findAllDescription();
        model.put("outDataDescription", filterDataDescription);

        List<String> filterDataDate = parsingRepo.findAllDate();
        model.put("outDataDate", filterDataDate);

        List<String> filterDataStock = parsingRepo.findAllStock();
        model.put("outDataStock", filterDataStock);

        List<String> filterDataPrice = parsingRepo.findAllPriceDirty();
        model.put("outDataPrice", filterDataPrice);




        return "analysisCross";
    }





}
