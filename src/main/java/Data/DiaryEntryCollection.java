/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data;

import UI.JournalReaderGUI;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Stiv
 */
public class DiaryEntryCollection {

    /**
     * @return the currentEntry
     */
    
    public DiaryEntryCollection()
    {
        listDiaryEntries = new ArrayList<DiaryEntry>();
    }
    
    public int getCurrentEntryIndex() {
        return currentEntryIndex;
    }
    
    public DiaryEntry getCurrentDiaryEntry()
    {
        if (currentEntryIndex>=0 && currentEntryIndex<listDiaryEntries.size())
        return listDiaryEntries.get(currentEntryIndex);
        return null;
    }
    
    public void goNext()
    {
        if (currentEntryIndex<getSize()-1) setCurrentEntryIndex(currentEntryIndex+1);
    }
    
    public void goPrev()
    {
        if (currentEntryIndex>0) setCurrentEntryIndex(currentEntryIndex-1);
    }

    /**
     * @param currentEntryIndex the currentEntry to set
     */
    public void setCurrentEntryIndex(int currentEntryIndex) {
        if (currentEntryIndex>=0 && currentEntryIndex<listDiaryEntries.size())
        this.currentEntryIndex = currentEntryIndex;
        pcl.propertyChange(new PropertyChangeEvent(this, "navigation", null, getCurrentDiaryEntry()));
    }

    private int currentEntryIndex = -1;
    ArrayList<DiaryEntry> listDiaryEntries;
    PropertyChangeListener pcl = null;
    
    
    public boolean addEntry(String title, String bodyText)
    {
        if (title.equals("") || bodyText.equals("")) return false;
        listDiaryEntries.add(new DiaryEntry(title,bodyText));
        currentEntryIndex = getSize()-1;
        //setChanged();
        //notifyObservers(getCurrentDiaryEntry());    
        pcl.propertyChange(new PropertyChangeEvent(this, "newentry", null, getCurrentDiaryEntry()));
        return true;
    }
    
        public void deleteEntry(int entryIndex)
    {
        if (getSize() > 0) {
        listDiaryEntries.remove(entryIndex );
        currentEntryIndex = getSize()-1;
        //setChanged();
        //notifyObservers(getCurrentDiaryEntry());    
        pcl.propertyChange(new PropertyChangeEvent(this, "delete", getCurrentDiaryEntry(), getCurrentDiaryEntry()));
        }
    }
    
    public int getSize()
    {
        return listDiaryEntries.size();
    }

    public void addPropertyChangeListener(PropertyChangeListener outsidePcl) {
        this.pcl = outsidePcl;
            }
    
    
    
}
