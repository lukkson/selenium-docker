package com.newtours.pages;

import com.searchmodule.pages.SearchPage;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class SearchTest extends BaseTest{

    @Test
    @Parameters({"keyword"})
    public void doSearch(String keyword){
        SearchPage searchPage = new SearchPage(driver);
        searchPage.goTo();
        searchPage.doSearch(keyword);
        searchPage.goToVidos();
        int result = searchPage.getResult();
        System.out.println(result);
        Assert.assertTrue(result > 0);
    }
}
