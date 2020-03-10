package com.example.parsing.service.readCsv;

import com.example.parsing.domain.PriceList;
import com.example.parsing.repository.PriceAnalysisRepo;
import com.opencsv.CSVReader;

import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/*import my.parsing.app.connection.WriteDbForFenoxPrice;*/

public class ReaderForFenoxCsv {

    public static void readMapa(String link, PriceAnalysisRepo priceAnalysisRepo) {

        priceAnalysisRepo.deleteAll();

        HashMap<Integer, Object> map = new HashMap<Integer, Object>();

        try {
            //csv file containing data
            String strFile = link;
      //      CSVReader reader = new CSVReader(new FileReader(strFile));
            CSVReader reader = new CSVReader(new InputStreamReader(new FileInputStream(strFile), "windows-1251"));
            String[] nextLine;
            int lineNumber = 0;
            while ((nextLine = reader.readNext()) != null) {
                lineNumber++;


                map.put(lineNumber, nextLine);

            }

        } catch (Exception e) {
            System.out.println(e);
        }


        for (Map.Entry<Integer, Object> mapEntry : map.entrySet()) {
            System.out.println(mapEntry.getKey() + "   " + Arrays.toString((Object[]) mapEntry.getValue()));
            String arr[] = Arrays.toString((Object[]) mapEntry.getValue()).split(";");
            System.out.println((arr[1]).replaceAll("[\\[\\](){}]", ""));
        }




        for (Map.Entry<Integer, Object> mapEntry : map.entrySet()) {


            String arrFenox[] = Arrays.toString((Object[]) mapEntry.getValue()).split(";");


            PriceList priceList = new PriceList();

            priceList.setArticle(arrFenox[0].replaceAll("[\\[\\](){}]", ""));
            priceList.setGrou(arrFenox[1]);
            priceList.setDescription(arrFenox[2]);
            priceList.setNewPrice("0");
            priceList.setOldPrice(arrFenox[3].replaceAll("[\\[\\](){}]", ""));

            priceAnalysisRepo.save(priceList);


        }


    }

}
