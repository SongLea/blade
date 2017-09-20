package com.blade.mvc.ui;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

/**
 * @author biezhi
 * @date 2017/9/20
 */
public class HtmlCreatorTest {

    private HtmlCreator htmlCreator;

    @Before
    public void before() {
        htmlCreator = new HtmlCreator();
    }

    @Test
    public void testHtmlCreator() {
        Assert.assertEquals("<!DOCTYPE html><head><meta charset=\"utf-8\"><style type='text/css'>.version{padding:10px;text-decoration-line: none;}</style><hr/><br/><p><center><a href='https://github.com/biezhi/blade' target='_blank'>Blade-2.0.2-beta</a></center></p></body>", htmlCreator.html());
    }

    @Test
    public void testCenter() {
        htmlCreator.center("Hello");
        Assert.assertEquals(true, htmlCreator.html().contains("<center>Hello</center>"));
    }

    @Test
    public void testTitle() {
        htmlCreator.title("Blade");
        Assert.assertEquals(true, htmlCreator.html().contains("<title>Blade</title>"));
    }

    @Test
    public void testAdd() {
        htmlCreator.add("nice");
        Assert.assertEquals(true, htmlCreator.html().contains("nice"));
    }

    @Test
    public void testBold() {
        htmlCreator.addBold("base");
        Assert.assertEquals(true, htmlCreator.html().contains("<b>base</b>"));
    }

    @Test
    public void testAddRowToTable() {
        htmlCreator.addRowToTable(Arrays.asList("name", "age"));
        Assert.assertEquals(true, htmlCreator.html().contains("<td>name</td><td>age</td>"));
    }

    @Test
    public void testBr() {
        htmlCreator.br();
        Assert.assertEquals(true, htmlCreator.html().contains("<br/>"));
    }

    @Test
    public void testP() {
        htmlCreator.startP();
        Assert.assertEquals(true, htmlCreator.html().contains("<p>"));
        htmlCreator.add("aaa");
        htmlCreator.endP();
        Assert.assertEquals(true, htmlCreator.html().contains("</p>"));
    }

    @Test
    public void testHeadTitle() {
        htmlCreator.h1("Hello H1");
        Assert.assertEquals(true, htmlCreator.html().contains("<h1>Hello H1</h1>"));

        htmlCreator.h2("Hello H2");
        Assert.assertEquals(true, htmlCreator.html().contains("<h2>Hello H2</h2>"));
    }

}
