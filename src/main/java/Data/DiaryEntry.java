/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Stiv
 */
public class DiaryEntry {
    /**
     * @return the title
     */
    
    
    SimpleDateFormat formatter;
    
    public String getTitle() {
        return title;
    }
    
    public DiaryEntry(String title, String bodyText)
    {
        formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        this.title = title;
        this.bodyText = bodyText;
        this.date = new Date();
    }

    /**
     * @param title the title to set
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * @return the date
     */
    public Date getDate() {
        return date;
    }

    /**
     * @param date the date to set
     */
    public void setDate(Date date) {
        this.date = date;
    }

    /**
     * @return the textbody
     */
    public String getBodyText() {
        return bodyText;
    }

    /**
     * @param bodyText the textbody to set
     */
    public void setBodyText(String bodyText) {
        this.bodyText = bodyText;
    }
    
    public String getDateAsString()
    {
        return formatter.format(date);
        
    }
    
    private String title;
    private Date date;
    private String bodyText;
}
