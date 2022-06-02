package edits.general;

import edits.AbstractEdit;
import objects.Child;
import objects.License;
import objects.LicenseConstants;

import java.util.List;

public class RejectOverMaximumAmountOfChildren extends AbstractEdit {


    @Override
    public void execute() {
        List<Child> childList = getChildren();
        License license = getLicense();

        Integer limitOfChildren = LicenseConstants.getMaximumChildCountForLicenseKey(license.getLicenseKey());


        if (childList == null) {
            return;
        }

        if (childList.size() > limitOfChildren) {
            info("Number of children exceeds license limits for " + license.getLicenseType());
            getConfiguration().addRejection("Number of children exceeds license limits for " + license.getLicenseType());
        }
    }

}
