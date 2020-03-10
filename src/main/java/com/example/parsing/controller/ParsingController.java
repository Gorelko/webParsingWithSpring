package com.example.parsing.controller;

import com.example.parsing.domain.ParsingResult;
import com.example.parsing.repository.ParsingRepo;
import com.example.parsing.service.parsing.amtel.ParserOpenAmtel;
import com.example.parsing.service.parsing.emex.ParserOpenEmex;
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
public class ParsingController {

    @Autowired
    private ParsingRepo parsingRepo;


    @Value("${upload.path}")
    private String uploadPath;



    @GetMapping("/parsing")
    public String parsingPage(
            Map<String, Object> model
    ) {

        FilesOnDisk filesOnDisk = new FilesOnDisk();

        model.put("arrUploadsFiles", filesOnDisk.outFilesOnDisk(uploadPath));

        return "parsing";
    }


    @PostMapping("/parsing")
    public String add(
            Map<String, Object> model,
            @RequestParam("file") MultipartFile file
    ) throws IOException {

        if (file != null && !file.getOriginalFilename().isEmpty()) {
            File uploadDir = new File(uploadPath);

            if (!uploadDir.exists()) {
                uploadDir.mkdir();
            }

/*            String uuidFile = UUID.randomUUID().toString();
            System.out.println(uuidFile);
            String resultFilename = uuidFile + "." + file.getOriginalFilename();*/
            String resultFilename = file.getOriginalFilename();
            System.out.println(resultFilename);

            file.transferTo(new File(uploadPath + "/" + resultFilename));


        }
        FilesOnDisk filesOnDisk = new FilesOnDisk();

        model.put("arrUploadsFiles", filesOnDisk.outFilesOnDisk(uploadPath));

        return "parsing";
    }

    @PostMapping("/startparsing")
    public String startParsing(
            @RequestParam(name="arrUploadsFiles") String arrUploadsFiles,
            @RequestParam(name="email") String mail,
            @RequestParam(name="siteSelect", required=false, defaultValue="None") String siteSelect,
            Map<String, Object> model
    ) throws InterruptedException {
        FilesOnDisk filesOnDisk = new FilesOnDisk();
        model.put("arrUploadsFiles", filesOnDisk.outFilesOnDisk(uploadPath));


        if (siteSelect.equals("Amtel")) {

            try {
                ParserOpenAmtel.parsing(uploadPath + "/" + arrUploadsFiles, mail, parsingRepo);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        } else if (siteSelect.equals("Emex")) {

            try {
                ParserOpenEmex.parsing(uploadPath + "/" + arrUploadsFiles, mail, parsingRepo);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }


        } else if (siteSelect.equals("None")) {
            return "parsing";
        }

        return "parsing";
    }




}
