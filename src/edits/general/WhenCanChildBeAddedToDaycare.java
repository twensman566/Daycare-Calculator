package edits.general;

import edits.AbstractEdit;
import edits.EditDriver;
import objects.Child;
import objects.Configuration;
import utils.Utils;

import java.util.ArrayList;
import java.util.List;

public class WhenCanChildBeAddedToDaycare extends AbstractEdit {

    @Override
    public void execute() {
        List<Child> currentChildren = getChildren();


        List<Child> childrenWantingToAdd = getChildrenToBeAdded();


        List<Child> allChildren = new ArrayList<Child>();

        allChildren.addAll(currentChildren);
        allChildren.addAll(childrenWantingToAdd);


        Configuration configuration = getConfiguration();

        /*
         * Let's just run it for the next two years until we find a better way to do it.
         */
        for (int i = 0; i < 24; i++) {
            EditDriver editDriver = new EditDriver();
            editDriver.runGeneralEdits(configuration);

            if (configuration.getRejections().isEmpty()) {
                info("No rejections current children are valid.");
                break;
            }

            Utils.advanceChildrenOneMonth(childrenWantingToAdd);

        }


    }


}
