package edits.general;

import edits.AbstractEdit;
import edits.EditDriver;
import objects.Child;
import objects.Configuration;
import utils.Utils;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class WhenCanChildBeAddedToDaycare extends AbstractEdit {

    @Override
    public void execute() {
        List<Child> currentChildren = getChildren();


        List<Child> allChildren = new ArrayList<Child>();

        allChildren.addAll(currentChildren);
        allChildren.addAll(getChildrenToBeAdded());


        Configuration configuration = getConfiguration();
        configuration.setNow(LocalDate.now());


        configuration.setChildren(allChildren);

        /*
         * Let's just run it for the next two years until we find a better way to do it.
         */
        for (int i = 0; i < 730; i++) {
            EditDriver editDriver = new EditDriver();
            info("Checking for day " + configuration.getNow().toString());
            editDriver.runGeneralEdits(configuration);

            if (configuration.getRejections().isEmpty()) {
                info("No rejections current children are valid.");
                info("Child can be accepted on " + configuration.getNow().toString());
                break;
            }

            // increment the date and clear the rejections from the last check...
            configuration.setNow(configuration.getNow().plusDays(1));
            configuration.clearRejections();
            info("");
        }


    }
}
