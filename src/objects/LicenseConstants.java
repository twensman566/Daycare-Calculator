package objects;

import utils.Utils;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.LinkedList;

public class LicenseConstants {

    public static final String MINNESOTA_2022 = LicenseConstants.Minnesota_2022.class.getSimpleName();

    public enum Minnesota_2022 {
        LICENSE_A("A"),
        LICENSE_B("B");

        Minnesota_2022(String licenseType) {
            this.licenseType = licenseType;
        }

        public String getLicenseType() {
            return licenseType;
        }

        public String getLicenseKey() {
            return Minnesota_2022.class.getName() + "|" + Minnesota_2022.this.getLicenseType();
        }


        public void setLicenseType(String licenseType) {
            this.licenseType = licenseType;
        }

        private String licenseType;


    }

    public static HashMap<String, LinkedList<LocalDate>> ageCategories = null;

    public static LinkedList getAgesForLicenseType(String licenseType) {
        initializeAgeCategories(false);
        LinkedList linkedList = ageCategories.get(licenseType);
        if (linkedList != null || !linkedList.isEmpty()) {
            return linkedList;
        }

        initializeAgeCategories(true);
        return ageCategories.get(licenseType);
    }

    public static void initializeAgeCategories(boolean force) {
        if (ageCategories == null || ageCategories.isEmpty() || force) {
            ageCategories = new HashMap<>();

            LinkedList ages = new LinkedList<>();


            ages.add(getNewBornAgeForLicenseKey(Minnesota_2022.LICENSE_A.getLicenseKey()));
            ages.add(getInfantAgeForLicenseKey(Minnesota_2022.LICENSE_A.getLicenseKey()));
            ages.add(getToddlerAgeForLicenseKey(Minnesota_2022.LICENSE_A.getLicenseKey()));
            ages.add(getPreSchoolAgeForLicenseKey(Minnesota_2022.LICENSE_A.getLicenseKey()));
            ages.add(getSchoolAgeForLicenseKey(Minnesota_2022.LICENSE_A.getLicenseKey()));
            ageCategories.put(Minnesota_2022.LICENSE_A.getLicenseKey(), ages);

            ages = new LinkedList<>();
            ages.add(getNewBornAgeForLicenseKey(Minnesota_2022.LICENSE_B.getLicenseKey()));
            ages.add(getInfantAgeForLicenseKey(Minnesota_2022.LICENSE_B.getLicenseKey()));
            ages.add(getToddlerAgeForLicenseKey(Minnesota_2022.LICENSE_B.getLicenseKey()));
            ages.add(getPreSchoolAgeForLicenseKey(Minnesota_2022.LICENSE_B.getLicenseKey()));
            ages.add(getSchoolAgeForLicenseKey(Minnesota_2022.LICENSE_B.getLicenseKey()));
            ageCategories.put(Minnesota_2022.LICENSE_B.getLicenseKey(), ages);
        }

    }

    // if (Minnesota_2022.LICENSE_A.getLicenseKey().equals(licenseKey)) {
    public static LocalDate getPreSchoolAgeForLicenseKey(String licenseKey) {
        if (Utils.containsIgnoreCase(licenseKey, MINNESOTA_2022)) {
            return LocalDate.now().plusYears(5);
        }


        return LocalDate.now();
    }

    public static LocalDate getSchoolAgeForLicenseKey(String licenseKey) {
        if (Utils.containsIgnoreCase(licenseKey, MINNESOTA_2022)) {
            return LocalDate.now().plusYears(11);
        }

        return LocalDate.now();
    }


    public static LocalDate getToddlerAgeForLicenseKey(String licenseKey) {
        if (Utils.containsIgnoreCase(licenseKey, MINNESOTA_2022)) {
            return LocalDate.now().plusMonths(24);
        }

        return LocalDate.now();
    }

    public static LocalDate getInfantAgeForLicenseKey(String licenseKey) {
        if (Utils.containsIgnoreCase(licenseKey, MINNESOTA_2022)) {
            return LocalDate.now().plusMonths(12);
        }

        return LocalDate.now();
    }

    public static LocalDate getNewBornAgeForLicenseKey(String licenseKey) {
        if (Utils.containsIgnoreCase(licenseKey, MINNESOTA_2022)) {
            return LocalDate.now().plusWeeks(6);
        }

        return LocalDate.now();
    }

    public static HashMap<String, Integer> childrenLimits = null;

    public static void initializeChildrenLimits(boolean force) {
        if (childrenLimits == null || childrenLimits.isEmpty() || force) {
            childrenLimits = new HashMap<>();
            childrenLimits.put(Minnesota_2022.LICENSE_A.getLicenseKey(), 10);
        }
    }

    public static Integer getMaximumUnderSchoolAgeLimits(String licenseKey) {

        if (Minnesota_2022.LICENSE_A.getLicenseKey().equals(licenseKey)) {
            return 6;
        }

        return 0;
    }

    public static Integer getMaximumInfantAgeLimits(String licenseKey) {

        if (Minnesota_2022.LICENSE_A.getLicenseKey().equals(licenseKey)) {
            return 2;
        }

        return 0;
    }

    public static Integer getMaximumToddlerLimits(String licenseKey) {

        if (Minnesota_2022.LICENSE_A.getLicenseKey().equals(licenseKey)) {
            return 3;
        }

        return 0;
    }

    public static Integer getMaximumToddlerInfantLimit(String licenseKey) {

        if (Minnesota_2022.LICENSE_A.getLicenseKey().equals(licenseKey)) {
            return 3;
        }

        return 0;
    }

    public static Integer getMaximumChildCountForLicenseKey(String licenseType) {
        initializeChildrenLimits(false);
        Integer limit = childrenLimits.get(licenseType);
        if (limit != null) {
            return limit;
        }

        initializeChildrenLimits(true);
        return childrenLimits.get(licenseType);
    }

}
