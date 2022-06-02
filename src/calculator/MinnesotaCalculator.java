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

        for (String test : testStuff.keySet()) {
            Configuration configuration = new Configuration();
            configuration.setChildren(testStuff.get(test));
            configuration.setLicense(license);

            System.out.println(":Checking " + test);

            EditDriver editDriver = new EditDriver();
            editDriver.runGeneralEdits(configuration);


            EditDriver editDriver1 = new EditDriver();
            editDriver1.runAdvancingEdits(configuration);
        }


    }

    HashMap<String, List<Child>> testStuff = new HashMap<String, List<Child>>();

    public void initTest() {

        List<Child> test1 = new ArrayList<>();
        Child child = new Child(LocalDate.of(2022, 02, 01), "Child", "One");
        test1.add(child);
        child = new Child(LocalDate.of(2021, 02, 01), "Child", "One");
        test1.add(child);
        child = new Child(LocalDate.of(2020, 02, 01), "Child", "One");
        test1.add(child);
        child = new Child(LocalDate.of(2019, 02, 01), "Child", "One");
        test1.add(child);
        child = new Child(LocalDate.of(2018, 02, 01), "Child", "One");
        test1.add(child);
        child = new Child(LocalDate.of(2017, 02, 01), "Child", "One");
        test1.add(child);
        child = new Child(LocalDate.of(2016, 02, 01), "Child", "One");
        test1.add(child);

        testStuff.put("test1", test1);

        test1 = new ArrayList<>();
        child = new Child(LocalDate.of(2022, 02, 01), "Child", "One");
        test1.add(child);
        child = new Child(LocalDate.of(2022, 02, 01), "Child", "One");
        test1.add(child);
        child = new Child(LocalDate.of(2022, 02, 01), "Child", "One");
        test1.add(child);
        child = new Child(LocalDate.of(2022, 02, 01), "Child", "One");
        test1.add(child);
        child = new Child(LocalDate.of(2022, 02, 01), "Child", "One");
        test1.add(child);
        child = new Child(LocalDate.of(2022, 02, 01), "Child", "One");
        test1.add(child);
        child = new Child(LocalDate.of(2021, 02, 01), "Child", "One");
        test1.add(child);
        child = new Child(LocalDate.of(2020, 02, 01), "Child", "One");
        test1.add(child);
        child = new Child(LocalDate.of(2019, 02, 01), "Child", "One");
        test1.add(child);
        child = new Child(LocalDate.of(2019, 02, 01), "Child", "One");
        test1.add(child);
        child = new Child(LocalDate.of(2019, 02, 01), "Child", "One");
        test1.add(child);
        child = new Child(LocalDate.of(2019, 02, 01), "Child", "One");
        test1.add(child);
        child = new Child(LocalDate.of(2019, 02, 01), "Child", "One");
        test1.add(child);
        child = new Child(LocalDate.of(2019, 02, 01), "Child", "One");
        test1.add(child);
        child = new Child(LocalDate.of(2019, 02, 01), "Child", "One");
        test1.add(child);
        child = new Child(LocalDate.of(2018, 02, 01), "Child", "One");
        test1.add(child);
        child = new Child(LocalDate.of(2017, 02, 01), "Child", "One");
        test1.add(child);
        child = new Child(LocalDate.of(2016, 02, 01), "Child", "One");
        test1.add(child);
        child = new Child(LocalDate.of(2016, 02, 01), "Child", "One");
        test1.add(child);
        child = new Child(LocalDate.of(2016, 02, 01), "Child", "One");
        test1.add(child);
        child = new Child(LocalDate.of(2016, 02, 01), "Child", "One");
        test1.add(child);
        child = new Child(LocalDate.of(2016, 02, 01), "Child", "One");
        test1.add(child);
        child = new Child(LocalDate.of(2016, 02, 01), "Child", "One");
        test1.add(child);

        testStuff.put("test2", test1);
    }

    public static void main(String args[]) {
        MinnesotaCalculator calculator = new MinnesotaCalculator();

        calculator.execute();
    }
}
