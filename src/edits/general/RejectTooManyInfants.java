package edits.general;

import edits.AbstractEdit;
import objects.Child;
import objects.License;
import objects.LicenseConstants;
import utils.Utils;

import java.time.LocalDate;
import java.util.List;

public class RejectTooManyInfants extends AbstractEdit {
    @Override
    public void execute() {
        List<Child> childList = getChildren();
        License license = getLicense();

        LocalDate ageCategoryAboveInfant = Utils.getNextAgeCategory(license, LicenseConstants.getInfantAgeForLicenseKey(license.getLicenseKey()));
        LocalDate infantAgeCategory = Utils.getPriorAgeCategory(license, LicenseConstants.getInfantAgeForLicenseKey(license.getLicenseKey()));
        Integer infantAge = Utils.getAgeInYears(infantAgeCategory);

        Integer aboveInfantAge = Utils.getAgeInYears(ageCategoryAboveInfant);

        if (childList == null) {
            return;
        }

        Integer infantLimit = LicenseConstants.getMaximumInfantAgeLimits(license.getLicenseKey());
        int counter = 0;
        for (Child child : childList) {
            Integer thisChildsAgeInYears = Utils.getAgeInYears(getNow(), child.getBirthDate());

            if (thisChildsAgeInYears >= infantAge && aboveInfantAge > thisChildsAgeInYears) {
                counter++;
            }
        }

        if (counter > infantLimit) {
            info("Number of infant children(" + counter + ") exceeds license limits(" + infantLimit + ") for " + license.getLicenseType());
            getConfiguration().addRejection("Number of infant children(" + counter + ") exceeds license limits(" + infantLimit + ") for " + license.getLicenseType());
        }
    }
}
