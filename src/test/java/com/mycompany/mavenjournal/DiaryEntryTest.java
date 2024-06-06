/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mavenjournal;

import Data.DiaryEntry;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Stiv
 */
public class DiaryEntryTest {
    
    public DiaryEntryTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getTitle method, of class DiaryEntry.
     */
    @Test
    public void testGetTitle() {
        System.out.println("getTitle");
        DiaryEntry instance = new DiaryEntry("", "");
        String expResult = "";
        String result = instance.getTitle();
        assertEquals(expResult, result);
    }


    @Test
    public void testGetBodyText() {
        System.out.println("getBodyText");
        DiaryEntry instance = new DiaryEntry("", "");
        String expResult = "";
        String result = instance.getBodyText();
        assertEquals(expResult, result);
    }
    
       @Test
    public void  testTimestamp() throws InterruptedException {
        DiaryEntry instance = new DiaryEntry("T1", "Testing");
        TimeUnit.SECONDS.sleep(1); 
        DiaryEntry instance2 = new DiaryEntry("T2", "Testing2");
        String instance2Result = instance2.getDateAsString();
        String instance1Result = instance.getDateAsString();
        assertFalse(instance1Result.equals(instance2Result));
    }
   


    
}
