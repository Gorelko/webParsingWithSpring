package com.example.parsing.controller;


import com.example.parsing.domain.PriceList;
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
public class PriceAnalysisController {

    @Autowired
    private PriceAnalysisRepo priceAnalysisRepo;

    @GetMapping("/analysisPrice")
    public String outData(Map<String, Object> model) {

        Iterable<PriceList> outDataAll = priceAnalysisRepo.outFirstPagePrice();
        model.put("outDataAll", outDataAll);

        List<String> listArticle = priceAnalysisRepo.findAllArticle();
        model.put("listArticle", listArticle);

        List<String> listGroup = priceAnalysisRepo.findAllGrou();
        model.put("listGroup", listGroup);

        List<String> listDescription = priceAnalysisRepo.findAllDescription();
        model.put("listDescription", listDescription);

        List<String> listNewPrice = priceAnalysisRepo.findAllNewPrice();
        model.put("listNewPrice", listNewPrice);

        List<String> listOldPrice = priceAnalysisRepo.findAllOldPrice();
        model.put("listOldPrice", listOldPrice);

        model.put("numberPage", "1");

        String countRowsCross = priceAnalysisRepo.numberOfRows();
        int maxNumberPage = Integer.parseInt(countRowsCross)/50;
        List<String> numberPages = new ArrayList<>();
        for (int i = 1; i <= maxNumberPage; i++){
            numberPages.add(String.valueOf(i));
        }
        if (Integer.parseInt(countRowsCross)%50 > 0) {
            numberPages.add(String.valueOf(maxNumberPage+1));
        }
        model.put("listCountPage", numberPages);


        return "analysPrice";
    }


    @PostMapping("/analysisPrice")
    public String outDataWithFilter(
            @RequestParam("listArticle") String listArticle,
            @RequestParam("listGroup") String listGroup,
            @RequestParam("listDescription") String listDescription,
            @RequestParam("listOldPrice") String listOldPrice,
            @RequestParam("listNewPrice") String listNewPrice,

            @RequestParam("filterArticle") String filterArticle,
            @RequestParam("filterGroup") String filterGroup,
            @RequestParam("filterDescription") String filterDescription,
            @RequestParam("filterOldPrice") String filterOldPrice,
            @RequestParam("filterNewPrice") String filterNewPrice,

            @RequestParam("listCountPage") String curentPage,

            Map<String, Object> model
    ) {


        if (listArticle.equals("FILTER") && filterArticle.equals("")){
            listArticle = "FILTER";
        } else if(!listArticle.equals("FILTER") && !listArticle.equals("") && filterArticle.equals("")) {
            filterArticle = listArticle;
        } else if(!listArticle.equals("FILTER") && !listArticle.equals("") && !filterArticle.equals("")) {
            filterArticle = listArticle;
        } else if(listArticle.equals("FILTER") && !filterArticle.equals("")) {
            listArticle = filterArticle;
            filterArticle = listArticle;
        } else if(listArticle.equals("") && !filterArticle.equals("")) {
            listArticle = "FILTER";
            filterArticle = "";
        }
        model.put("filterArticle", filterArticle);


        if (listGroup.equals("FILTER") && filterGroup.equals("")){
            listGroup = "FILTER";
        } else if(!listGroup.equals("FILTER") && !listGroup.equals("") && filterGroup.equals("")) {
            filterGroup = listGroup;
        } else if(!listGroup.equals("FILTER") && !listGroup.equals("") && !filterGroup.equals("")) {
            filterGroup = listGroup;
        } else if(listGroup.equals("FILTER") && !filterGroup.equals("")) {
            listGroup = filterGroup;
            filterGroup = listGroup;
        } else if(listGroup.equals("") && !filterGroup.equals("")) {
            listGroup = "FILTER";
            filterGroup = "";
        }
        model.put("filterGroup", filterGroup);

        if (listDescription.equals("FILTER") && filterDescription.equals("")){
            listDescription = "FILTER";
        } else if(!listDescription.equals("FILTER") && !listDescription.equals("") && filterDescription.equals("")) {
            filterDescription = listDescription;
        } else if(!listDescription.equals("FILTER") && !listDescription.equals("") && !filterDescription.equals("")) {
            filterDescription = listDescription;
        } else if(listDescription.equals("FILTER") && !filterDescription.equals("")) {
            listDescription = filterDescription;
            filterDescription = listDescription;
        } else if(listDescription.equals("") && !filterDescription.equals("")) {
            listDescription = "FILTER";
            filterDescription = "";
        }
        model.put("filterDescription", filterDescription);


        if (listOldPrice.equals("FILTER") && filterOldPrice.equals("")){
            listOldPrice = "FILTER";
        } else if(!listOldPrice.equals("FILTER") && !listOldPrice.equals("") && filterOldPrice.equals("")) {
            filterOldPrice = listOldPrice;
        } else if(!listOldPrice.equals("FILTER") && !listOldPrice.equals("") && !filterOldPrice.equals("")) {
            filterOldPrice = listOldPrice;
        } else if(listOldPrice.equals("FILTER") && !filterOldPrice.equals("")) {
            listOldPrice = filterOldPrice;
            filterOldPrice = listOldPrice;
        } else if(listOldPrice.equals("") && !filterOldPrice.equals("")) {
            listOldPrice = "FILTER";
            filterOldPrice = "";
        }
        model.put("filterOldPrice", filterOldPrice);


        if (listNewPrice.equals("FILTER") && filterNewPrice.equals("")){
            listNewPrice = "FILTER";
        } else if(!listNewPrice.equals("FILTER") && !listNewPrice.equals("") && filterNewPrice.equals("")) {
            filterNewPrice = listNewPrice;
        } else if(!listNewPrice.equals("FILTER") && !listNewPrice.equals("") && !filterNewPrice.equals("")) {
            filterNewPrice = listNewPrice;
        } else if(listNewPrice.equals("FILTER") && !filterNewPrice.equals("")) {
            listNewPrice = filterNewPrice;
            filterNewPrice = listNewPrice;
        } else if(listNewPrice.equals("") && !filterNewPrice.equals("")) {
            listNewPrice = "FILTER";
            filterNewPrice = "";
        }
        model.put("filterNewPrice", filterNewPrice);


        int numberOffset = (Integer.parseInt(curentPage) - 1) * 50;

        Iterable<PriceList> outDataAll = priceAnalysisRepo.pageWithNumber(listArticle, listGroup, listDescription, listOldPrice, listNewPrice, numberOffset);
     //   Iterable<PriceList> outDataAll = priceAnalysisRepo.findAll();
        model.put("outDataAll", outDataAll);

        model.put("numberPage", curentPage);

        String countRowsCross = priceAnalysisRepo.countPageWithFilter(listArticle, listGroup, listDescription, listOldPrice, listNewPrice);
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


        List<String> filterListArticle = priceAnalysisRepo.findAllArticle();
        model.put("listArticle", filterListArticle);

        List<String> filterListGroup = priceAnalysisRepo.findAllGrou();
        model.put("listGroup", filterListGroup);

        List<String> filterListDescription = priceAnalysisRepo.findAllDescription();
        model.put("listDescription", filterListDescription);

        List<String> filterListNewPrice = priceAnalysisRepo.findAllNewPrice();
        model.put("listNewPrice", filterListNewPrice);

        List<String> filterListOldPrice = priceAnalysisRepo.findAllOldPrice();
        model.put("listOldPrice", filterListOldPrice);





        return "analysPrice";
    }



}
