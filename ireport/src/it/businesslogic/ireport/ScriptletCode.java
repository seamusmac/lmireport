/*
 * Copyright (C) 2005 - 2008 JasperSoft Corporation.  All rights reserved. 
 * http://www.jaspersoft.com.
 *
 * Unless you have purchased a commercial license agreement from JasperSoft,
 * the following license terms apply:
 *
 * This program is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License version 2 as published by
 * the Free Software Foundation.
 *
 * This program is distributed WITHOUT ANY WARRANTY; and without the
 * implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.
 * See the GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, see http://www.gnu.org/licenses/gpl.txt
 * or write to:
 *
 * Free Software Foundation, Inc.,
 * 59 Temple Place - Suite 330,
 * Boston, MA  USA  02111-1307
 *
 *
 *
 *
 * ScriptletCode.java
 * 
 * Created on 11 marzo 2004, 18.03
 *
 */

package it.businesslogic.ireport;

import it.businesslogic.ireport.util.*;
import java.util.*;
import java.io.*;
/**
 *
 * @author  Administrator
 *
 */
public class ScriptletCode {
   
    public static final int GLOBAL_DECLARATIONS = 0;
    public static final int EVENT_AFTER_COLUMN_INIT = 1;
    public static final int EVENT_AFTER_DETAIL_EVAL = 2;
    public static final int EVENT_AFTER_GROUP_INIT = 3;
    public static final int EVENT_AFTER_PAGE_INIT = 4;
    public static final int EVENT_AFTER_REPORT_INIT = 5;
    public static final int EVENT_BEFORE_COLUMN_INIT = 6;
    public static final int EVENT_BEFORE_DETAIL_EVAL = 7;
    public static final int EVENT_BEFORE_GROUP_INIT = 8;
    public static final int EVENT_BEFORE_PAGE_INIT = 9;
    public static final int EVENT_BEFORE_REPORT_INIT = 10;
    
    public static final int LAST_PORTION = 10;
    public String[] portion_keywords = null;
    
    /** all code protions */
    protected HashMap code_portions;
    
    /** Creates a new instance of ScriptletCode */
    public ScriptletCode() {   
 
        code_portions = new HashMap();   
        portion_keywords = new String[LAST_PORTION+1];
        
        portion_keywords[GLOBAL_DECLARATIONS]     = "GLOBAL_DECLARATIONS";
        portion_keywords[EVENT_AFTER_COLUMN_INIT] = "EVENT_AFTER_COLUMN_INIT";
        portion_keywords[EVENT_AFTER_DETAIL_EVAL] = "EVENT_AFTER_DETAIL_EVAL";
        portion_keywords[EVENT_AFTER_GROUP_INIT]  = "EVENT_AFTER_GROUP_INIT";
        portion_keywords[EVENT_AFTER_PAGE_INIT]   = "EVENT_AFTER_PAGE_INIT";
        portion_keywords[EVENT_AFTER_REPORT_INIT] = "EVENT_AFTER_REPORT_INIT";
        portion_keywords[EVENT_BEFORE_COLUMN_INIT]= "EVENT_BEFORE_COLUMN_INIT";
        portion_keywords[EVENT_BEFORE_DETAIL_EVAL]= "EVENT_BEFORE_DETAIL_EVAL";
        portion_keywords[EVENT_BEFORE_GROUP_INIT] = "EVENT_BEFORE_GROUP_INIT";
        portion_keywords[EVENT_BEFORE_PAGE_INIT]  = "EVENT_BEFORE_PAGE_INIT";
        portion_keywords[EVENT_BEFORE_REPORT_INIT]= "EVENT_BEFORE_REPORT_INIT";
             
    }  
    
    /**
     *  Return the requested portion of class
     */
    public String getPortion(int portion)
    {

        if (code_portions.get(""+portion) == null)
        {
            return "";
        }        
        return (String)code_portions.get(""+portion);  
    }
    
    /**
     *  Return the requested portion of class
     */
    public void setPortionCode(int portion, String code)
    {

        code_portions.put(""+portion, code);
    }
    
    /**
     *  
     */
    public StringBuffer getAll()
    {
        StringBuffer s = new StringBuffer();
        
        String global_portion =  getPortion( GLOBAL_DECLARATIONS).trim();
        
        int i = global_portion.lastIndexOf("}");
        global_portion = global_portion.substring(0,i) + global_portion.substring(i+1);
                
        s.append( global_portion );
        s.append("\n");
        for ( int k=1; k<  LAST_PORTION+1 ; ++k)
        {
            s.append( "/** Begin " + portion_keywords[k] + " This line is generated by iReport. Don't modify or move please! */\n" );
            s.append( getPortion(k) );
            s.append( "/** End " + portion_keywords[k] + " This line is generated by iReport. Don't modify or move please! */\n" );
        }
        
        s.append("\n}");
        
        return s;
    }
    
    
    /** Load the scriptlet from a file... */
    public ScriptletCode(String filename) throws FileNotFoundException, IOException 
    {
        this( new FileReader(filename) );
    }
    
    
    /** Load the scriptlet from a file... */
    public ScriptletCode(java.io.InputStream is) throws  IOException 
    {
        this( new InputStreamReader(is) );
    }
    
    public ScriptletCode(Reader in) throws IOException 
    {           
        this();
        LineNumberReader lin = new LineNumberReader(in);
        String line = "";
        
        int actualPortion = GLOBAL_DECLARATIONS;
        
        while ( (line = lin.readLine()) != null)
        {
            if ( line.trim().startsWith("/** Begin EVENT_AFTER_COLUMN_INIT"))
            {
                actualPortion = EVENT_AFTER_COLUMN_INIT;
                continue;
            }
            else if ( line.trim().startsWith("/** Begin EVENT_AFTER_DETAIL_EVAL"))
            {
                actualPortion = EVENT_AFTER_DETAIL_EVAL;
                continue;
            }
            else if ( line.trim().startsWith("/** Begin EVENT_AFTER_GROUP_INIT"))
            {
                actualPortion = EVENT_AFTER_GROUP_INIT;
                continue;
            }
            else if ( line.trim().startsWith("/** Begin EVENT_AFTER_PAGE_INIT"))
            {
                actualPortion = EVENT_AFTER_PAGE_INIT;
                continue;
            }
            else if ( line.trim().startsWith("/** Begin EVENT_AFTER_REPORT_INIT"))
            {
                actualPortion = EVENT_AFTER_REPORT_INIT;
                continue;
            }
            else if ( line.trim().startsWith("/** Begin EVENT_BEFORE_COLUMN_INIT"))
            {
                actualPortion = EVENT_BEFORE_COLUMN_INIT;
                continue;
            }
            else if ( line.trim().startsWith("/** Begin EVENT_BEFORE_DETAIL_EVAL"))
            {
                actualPortion = EVENT_BEFORE_DETAIL_EVAL;
                continue;
            }
            else if ( line.trim().startsWith("/** Begin EVENT_BEFORE_GROUP_INIT"))
            {
                actualPortion = EVENT_BEFORE_GROUP_INIT;
                continue;
            }
            else if ( line.trim().startsWith("/** Begin EVENT_BEFORE_PAGE_INIT"))
            {
                actualPortion = EVENT_BEFORE_PAGE_INIT;
                continue;
            }
            else if ( line.trim().startsWith("/** Begin EVENT_BEFORE_REPORT_INIT"))
            {
                actualPortion = EVENT_BEFORE_REPORT_INIT;
                continue;
            }
            else if ( line.trim().startsWith("/** End EVENT_"))
            {
                actualPortion = GLOBAL_DECLARATIONS;
                continue;
            }
            
            append(line, actualPortion);
        }
    }  
    
    /** Append a line to the specified code portion */
    public void append(String line, int portion)
    {
        String str = Misc.nvl( this.code_portions.get(""+portion),""); 
        str += line + "\n";   
        this.code_portions.put(""+portion,str); 
        
    }
}
