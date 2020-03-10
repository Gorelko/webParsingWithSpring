package com.example.parsing.service.parsing.emex;

import com.example.parsing.domain.ParsingResult;
import com.example.parsing.repository.ParsingRepo;
import com.example.parsing.service.mail.*;
import com.example.parsing.service.readCsv.ReaderForCsv;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;

import java.util.*;
import java.util.concurrent.TimeUnit;

/*import my.parsing.app.connection.WriteInDb;*/


public class ParserOpenEmex {


    public static void parsing(String link, String email, ParsingRepo parsingRepo) throws InterruptedException {


        HashMap<Integer, Object> map = ReaderForCsv.readMapa(link);

        System.setProperty("webdriver.gecko.driver", "D:\\geckodriver.exe"); //прописываем адресс для драйвера

        ProfilesIni listProfiles = new ProfilesIni();

        FirefoxProfile profile = listProfiles.getProfile("profileTools");

        FirefoxOptions opt = new FirefoxOptions();
        opt.setProfile(profile);


        WebDriver driver = new FirefoxDriver(opt);

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.manage().window().maximize();


        List<List<String>> products = new ArrayList<List<String>>();

        int count = 1;
        for (Map.Entry<Integer, Object> mapEntry : map.entrySet()) {

            driver.get("https://emex.ru/");

            WebElement element = driver.findElement(By.id("detail-num-input"));

            String arr[] = Arrays.toString((Object[]) mapEntry.getValue()).replaceAll("[\\[\\](){}]", "").split(";");

            Thread.sleep(3000);
            element.sendKeys(arr[1]);
            Thread.sleep(3000);
            element.sendKeys(Keys.ENTER);

            try {


                WebElement element2 = driver.findElement(By.xpath("//div[contains(text(),'" + arr[0] + "')]"));

                String element3 = String.valueOf(driver.findElement(By.xpath("//div[contains(text(),'Найдено несколько совпадений')]")));
                if (element3.contains("Найдено несколько совпадений")) {
                    element2.click();
                }

            } catch (Exception e) {
                System.out.println("В поиске один вариант!");
            }


            List<List<String>> list = EmexParsArt.emexParsing(driver, arr[1], arr[0]);
/*            new WriteInDb().writeInDB(list); //запись для базы данных*/



            for (List<String> product : list) {

                ParsingResult parsingResult = new ParsingResult();

                System.out.println(product);

                parsingResult.setBrend1(product.get(0));
                parsingResult.setArticle_brend1(product.get(1));
                parsingResult.setBrend2(product.get(2));
                parsingResult.setArticle_brend2(product.get(3));
                parsingResult.setDescription_art(product.get(4));
                parsingResult.setCount_dirty(product.get(5));
                parsingResult.setPrice_dirty(product.get(6));
                parsingResult.setStock(product.get(7));
                parsingResult.setDate_swap(product.get(8));

                parsingRepo.save(parsingResult);

            }


            count++;

        }

        if (email.length() > 0) {
            MailLogin.senderOut(email);
        }

    }


}