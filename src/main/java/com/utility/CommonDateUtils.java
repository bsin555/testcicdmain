/*
 This contains common Date related Utilities which are useful for OverDrive project
 <p>
 Copyright (C) 2017 Clearstream.TV, Inc. All Rights Reserved.
 Proprietary and confidential.
 */

package com.utility;

import org.joda.time.DateTime;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class CommonDateUtils {

    public static String getDate(int noOfDays, String dateFormat) {
        Calendar date = Calendar.getInstance();
        date.add(Calendar.DATE, noOfDays);
        DateFormat formatDate = new SimpleDateFormat(dateFormat);
        return formatDate.format(date.getTime()).substring(5).replace("-", "_");
    }

    public static DateTime getCurrentTimeStamp(){
        return DateTime.now();
    }
}