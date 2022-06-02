package calculator;

import edits.EditDriver;
import objects.Child;
import objects.Configuration;
import objects.License;
import objects.LicenseConstants;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MinnesotaCalculator {

    public MinnesotaCalculator() {
    }

    public void execute() {
        initTest();

        License license = new License();
        license.setLicenseKey(LicenseConstants.Minnesota_2022.LICENSE_A.getLicenseKey());
        Configuration configuration = new Configuration();

        List<Child> childrenToBeAdded = new ArrayList<>();
        childrenToBeAdded.add(new Child(LocalDate.of(2021, 11, 01), "", ""));

        configuration.setChildrenToBeAdded(childrenToBeAdded);

        for (String test : testStuff.keySet()) {

            configuration.setChildren(testStuff.get(test));

            configuration.setLicense(license);

            System.out.println(":Checking " + test);

            EditDriver editDriver = new EditDriver();
            editDriver.runGeneralEdits(configuration);

            System.out.println("Running advancing edits");
            EditDriver editDriver1 = new EditDriver();
            editDriver1.runAdvancingEdits(configuration);
        }


    }

    HashMap<String, List<Child>> testStuff = new HashMap<String, List<Child>>();

    public void initTest() {


        List<Child> test1 = new ArrayList<>();

        test1.add(new Child(LocalDate.of(2021, 06, 04), "", ""));

        test1.add(new Child(LocalDate.of(2021, 10, 04), "", ""));



        test1.add(new Child(LocalDate.of(2015, 05, 30), "", ""));
        test1.add(new Child(LocalDate.of(2015, 05, 30), "", ""));
        test1.add(new Child(LocalDate.of(2015, 05, 30), "", ""));

        testStuff.put("test1", test1);

    }


    public static void main(String args[]) {
        MinnesotaCalculator calculator = new MinnesotaCalculator();

        calculator.execute();
    }
}
