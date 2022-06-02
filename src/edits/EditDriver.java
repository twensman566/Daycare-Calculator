package edits;

import objects.Child;
import objects.Configuration;
import objects.License;
import objects.LicenseConstants;

import java.util.ArrayList;
import java.util.List;

public class EditDriver {


    public EditDriver() {

    }

    public void runGeneralEdits(Configuration configuration) {
        List<String> editsToRun = getEditsToRun();

        for (String editName : editsToRun) {

            try {
                Class editClass = Class.forName(editName);
                AbstractEdit edit = (AbstractEdit) editClass.newInstance();

                edit.init(configuration);
                edit.execute();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void runAdvancingEdits(Configuration configuration) {
        List<String> editsToRun = getAdvancingEditsToRun();

        for (String editName : editsToRun) {

            try {
                Class editClass = Class.forName(editName);
                AbstractEdit edit = (AbstractEdit) editClass.newInstance();

                edit.init(configuration);
                edit.execute();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public List<String> getAdvancingEditsToRun() {
        List<String> editsToRun = new ArrayList<>();
        editsToRun.add("edits.general.WhenCanChildBeAddedToDaycare");

        return editsToRun;
    }

    public List<String> getEditsToRun() {
        List<String> editsToRun = new ArrayList<>();
        editsToRun.add("edits.general.RejectOverMaximumAmountOfChildren");
        editsToRun.add("edits.general.RejectTooManyChildrenUnderSchoolAge");
        editsToRun.add("edits.general.RejectTooManyToddlers");
        editsToRun.add("edits.general.RejectTooManyInfantAndToddlers");
        editsToRun.add("edits.general.RejectTooManyInfants");

        return editsToRun;
    }
}
