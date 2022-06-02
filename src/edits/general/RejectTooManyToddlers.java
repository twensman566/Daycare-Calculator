package edits.general;

import edits.AbstractEdit;
import objects.Child;
import objects.License;
import objects.LicenseConstants;
import utils.Utils;

import java.time.LocalDate;
import java.util.List;

public class RejectTooManyToddlers extends AbstractEdit {
    @Override
    public void execute() {
        List<Child> childList = getChildren();
        License license = getLicense();

        LocalDate ageCategoryAboveToddler = Utils.getNextAgeCategory(license, LicenseConstants.getToddlerAgeForLicenseKey(license.getLicenseKey()));
        LocalDate toddlerAgeCategory = Utils.getPriorAgeCategory(license, LicenseConstants.getToddlerAgeForLicenseKey(license.getLicenseKey()));
        Integer toddlerAge = Utils.getAgeInYears(toddlerAgeCategory);
        Integer aboveToddlerAge = Utils.getAgeInYears(ageCategoryAboveToddler);

        if (childList == null) {
            return;
        }

        Integer toddlerLimit = LicenseConstants.getMaximumToddlerLimits(license.getLicenseKey());
        int counter = 0;
        for (Child child : childList) {
            Integer thisChildsAgeInYears = Utils.getAgeInYears(getNow(), child.getBirthDate());

            if (thisChildsAgeInYears >= toddlerAge && aboveToddlerAge > thisChildsAgeInYears) {
                counter++;
            }
        }

        if (counter > toddlerLimit) {
            info("Number of toddler children(" + counter + ") exceeds license limits(" + toddlerLimit + ") for " + license.getLicenseType());
            getConfiguration().addRejection("Number of toddler children(" + counter + ") exceeds license limits(" + toddlerLimit + ") for " + license.getLicenseType());
        }
    }
}
