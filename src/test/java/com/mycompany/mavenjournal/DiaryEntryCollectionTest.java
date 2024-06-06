/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mavenjournal;

import Data.DiaryEntry;
import Data.DiaryEntryCollection;
import java.beans.PropertyChangeListener;
import java.util.concurrent.TimeUnit;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

/**
 *
 * @author Stiv
 */
public class DiaryEntryCollectionTest {
    @Mock
    PropertyChangeListener pcl;

    @InjectMocks
    DiaryEntryCollection instance;
    
   

    public DiaryEntryCollectionTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        instance = new DiaryEntryCollection();
        instance.addPropertyChangeListener(pcl);
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getCurrentEntryIndex method, of class DiaryEntryCollection.
     */


    /**
     * Test of getCurrentDiaryEntry method, of class DiaryEntryCollection.
     */
    @Test
    public void testGetCurrentDiaryEntry() throws InterruptedException {
        System.out.println("getCurrentDiaryEntry");
        instance.addEntry("T1", "Testing");
        TimeUnit.SECONDS.sleep(1); 
        instance.addEntry("T2", "Testing2");
        DiaryEntry result = instance.getCurrentDiaryEntry();
        assertEquals("Testing2", result.getBodyText());
    
    }


    /**
     * Test of setCurrentEntryIndex method, of class DiaryEntryCollection.
     */
    @Test
    public void testSetCurrentEntryIndex() {
        System.out.println("setCurrentEntryIndex");
        instance.addEntry("T1", "Testing");
        int currentEntryIndex = 0;
        instance.setCurrentEntryIndex(currentEntryIndex);
        assertEquals(currentEntryIndex, instance.getCurrentEntryIndex());
    }

    /**
     * Test of addEntry method, of class DiaryEntryCollection.
     */
    @Test
    public void testAddEntry() {
        System.out.println("addEntry");
        String title = "";
        String bodyText = "";
        boolean expResult = false;
        boolean result = instance.addEntry(title, bodyText);
        assertEquals(expResult, result);
       
    }

    /**
     * Test of getSize method, of class DiaryEntryCollection.
     */
    @Test
    public void testGetSize() {
        System.out.println("getSize");
        int expResult = 0;
        int result = instance.getSize();
        assertEquals(expResult, result);   
    }
    
        @Test
    public void testDeletion() throws InterruptedException {
        System.out.println("deleteCurrentDiaryEntry");
        instance.addEntry("T1", "Testing");
        TimeUnit.SECONDS.sleep(1); 
        instance.addEntry("T2", "Testing2");
        DiaryEntry result = instance.getCurrentDiaryEntry();
        assertEquals("Testing2", result.getBodyText());
        instance.deleteEntry(instance.getCurrentEntryIndex());
        result = instance.getCurrentDiaryEntry();
        assertEquals("Testing", result.getBodyText());
    
    }
    
}
