package com.example.parsing.controller;

import com.example.parsing.repository.PriceAnalysisRepo;
import com.example.parsing.service.readCsv.ReaderForFenoxCsv;
import com.example.parsing.service.uploadsFiles.FilesOnDisk;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.Map;

@Controller
public class UpdatePriceController {

    @Value("${upload.path}")
    private String uploadPath;

    @Autowired
    private PriceAnalysisRepo priceAnalysisRepo;


    @GetMapping("/updatePrice")
    public String outData(
            Map<String, Object> model
    ) {

        FilesOnDisk filesOnDisk = new FilesOnDisk();

        model.put("arrUploadsFiles", filesOnDisk.outFilesOnDisk(uploadPath));




        return "updatePrice";
    }



    @PostMapping("/updatePrice")
    public String startParsing(
            @RequestParam("file") MultipartFile file,
            Map<String, Object> model
    ) throws IOException {

        if (file != null && !file.getOriginalFilename().isEmpty()) {
            File uploadDir = new File(uploadPath);

            if (!uploadDir.exists()) {
                uploadDir.mkdir();
            }

            String resultFilename = file.getOriginalFilename();

            file.transferTo(new File(uploadPath + "/" + resultFilename));

        }

        FilesOnDisk filesOnDisk = new FilesOnDisk();

        model.put("arrUploadsFiles", filesOnDisk.outFilesOnDisk(uploadPath));


        return "updatePrice";
    }


    @PostMapping("/updatePrice2")
    public String startParsing(
            @RequestParam(name="arrUploadsFiles") String arrUploadsFiles,
            @RequestParam(name="siteSelect", required=false, defaultValue="None") String siteSelect,
            Map<String, Object> model
    ) throws InterruptedException {
        FilesOnDisk filesOnDisk = new FilesOnDisk();
        model.put("arrUploadsFiles", filesOnDisk.outFilesOnDisk(uploadPath));

        ReaderForFenoxCsv readerForFenoxCsv = new ReaderForFenoxCsv();
        readerForFenoxCsv.readMapa(uploadPath + "/" + arrUploadsFiles, priceAnalysisRepo);






        return "updatePrice";
    }



}
