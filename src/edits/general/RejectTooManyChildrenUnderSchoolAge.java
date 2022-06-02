package edits.general;

import edits.AbstractEdit;
import objects.Child;
import objects.License;
import objects.LicenseConstants;
import utils.Utils;

import java.time.LocalDate;
import java.util.List;

public class RejectTooManyChildrenUnderSchoolAge extends AbstractEdit {

    @Override
    public void execute() {
        List<Child> childList = getChildren();
        License license = getLicense();

        LocalDate schoolAge = Utils.getPriorAgeCategory(license, LicenseConstants.getSchoolAgeForLicenseKey(license.getLicenseKey()));

        Integer age = Utils.getAgeInYears(schoolAge);

        if (childList == null) {
            return;
        }

        Integer underSchoolAgeLimit = LicenseConstants.getMaximumUnderSchoolAgeLimits(license.getLicenseKey());
        int counter = 0;
        for (Child child : childList) {
            Integer thisChildsAgeInYears =  Utils.getAgeInYears(getNow(),child.getBirthDate());

            if (age > thisChildsAgeInYears) {
                counter++;
            }
        }

        if (counter > underSchoolAgeLimit) {
            info("Number of under school age children(" + counter + ") exceeds license limits(" + underSchoolAgeLimit + ") for " + license.getLicenseType());
            getConfiguration().addRejection("Number of under school age children(" + counter + ") exceeds license limits(" + underSchoolAgeLimit + ") for " + license.getLicenseType());
        }
    }
}
