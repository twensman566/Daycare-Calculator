package utils;

import edits.EditDriver;
import objects.Child;
import objects.License;
import objects.LicenseConstants;

import java.time.LocalDate;
import java.time.Period;
import java.util.*;

public class Utils {

    /*
     * Probably can just absolute the value... so we will do that.
     */
    public static Integer getAgeInYears(LocalDate date) {


        return Period.between(LocalDate.now(), date).getYears();
    }

    public static Integer getAgeInYears(LocalDate now, LocalDate date) {
        return Period.between(now, date).getYears();
    }

    public static LocalDate getPriorAgeCategory(License license, LocalDate dateToCompareAgainst) {

        LinkedList<LocalDate> list = LicenseConstants.getAgesForLicenseType(license.getLicenseKey());
        LocalDate thePriorAgeCategory = null;
        for (LocalDate date : list) {
            if (date.equals(dateToCompareAgainst)) {
                break;
            }
            thePriorAgeCategory = date;
        }

        return thePriorAgeCategory;
    }

    public static LocalDate getNextAgeCategory(License license, LocalDate dateToCompareAgainst) {

        LinkedList<LocalDate> list = LicenseConstants.getAgesForLicenseType(license.getLicenseKey());
        LocalDate theNextAgeCategory = null;

        Iterator<LocalDate> iterator = list.descendingIterator();
        while (iterator.hasNext()) {
            LocalDate date = iterator.next();
            if (date.equals(dateToCompareAgainst)) {
                break;
            }
            theNextAgeCategory = date;
        }

        return theNextAgeCategory;
    }

    public static boolean containsIgnoreCase(String str1, String str2) {
        if (str1 == null && str1 == null) {
            return true;
        }

        if (str1 == null || str2 == null) {
            return false;
        }

        return str1.toLowerCase().contains(str2.toLowerCase());
    }
}