package com.example.parsing.controller;

import com.example.parsing.domain.ParsingResult;
import com.example.parsing.repository.ParsingRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@Controller
public class EditCrossController {

    @Autowired
    private ParsingRepo parsingRepo;

    @GetMapping("/edit")
    public String outData(
            @RequestParam("enterArticle") String enterArticle,
            Map<String, Object> model
    ) {

        System.out.println(enterArticle);

        Iterable<ParsingResult> parsingResultsById = parsingRepo.findOneLow(Integer.parseInt(enterArticle));

        model.put("parsingResultsById", parsingResultsById);


        return "editCross";
    }


    @PostMapping("/edit")
    public String outData(

            @RequestParam("editBrend1") String editBrend1,
            @RequestParam("editArtBrend1") String editArtBrend1,
            @RequestParam("editBrend2") String editBrend2,
            @RequestParam("editArtBrend2") String editArtBrend2,
            @RequestParam("editDescription") String editDescription,
            @RequestParam("editCount") String editCount,
            @RequestParam("editPrice") String editPrice,
            @RequestParam("editStock") String editStock,
            @RequestParam("editDate") String editDate,
            @RequestParam("editId") String editId,

            Map<String, Object> model
    ) {

        parsingRepo.updateParsingLow(editBrend1, editArtBrend1, editBrend2, editArtBrend2, editDescription, editCount, editPrice, editStock, editDate, Integer.parseInt(editId));

        Iterable<ParsingResult> parsingResultsById = parsingRepo.findOneLow(Integer.parseInt(editId));

        model.put("parsingResultsById", parsingResultsById);

        return "editCross";
    }


}