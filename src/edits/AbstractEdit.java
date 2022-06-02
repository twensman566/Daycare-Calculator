package edits;

import objects.Child;
import objects.Configuration;
import objects.License;

import java.util.List;

public abstract class AbstractEdit {

    /*
     * Main variables the will likely be used.
     */
    protected Configuration configuration;


    protected List<Child> children;
    protected License license;

    private List<Child> childrenToBeAdded;

    public abstract void execute();

    public void init(Configuration configuration) {
        init(true, configuration);
    }

    public void init(boolean init, Configuration configuration) {
        if (init) {
            children = configuration.getChildren();
            this.license = configuration.getLicense();
            this.childrenToBeAdded = configuration.getChildrenToBeAdded();
            this.configuration = configuration;
        }
    }


    public void init(List<Child> childList, License license) {
        init(true, childList, license);
    }

    public void init(List<Child> childList, License license, List<Child> childrenToBeAdded) {
        init(true, childList, license);
    }

    public void init(boolean init, List<Child> childList, License licenseType) {
        if (init) {
            children = childList;
            this.license = licenseType;
        }
    }

    public void init(boolean init, List<Child> childList, License licenseType, List<Child> childrenToBeAdded) {
        if (init) {
            children = childList;
            this.license = licenseType;
            this.childrenToBeAdded = childrenToBeAdded;
        }
    }

    public List<Child> getChildren() {
        return this.children;
    }

    public License getLicense() {
        return this.license;
    }


    public List<Child> getChildrenToBeAdded() {
        return childrenToBeAdded;
    }

    public void setChildrenToBeAdded(List<Child> childrenToBeAdded) {
        this.childrenToBeAdded = childrenToBeAdded;
    }

    public void info(String string) {
        info(string, true);
    }

    public void info(String string, boolean print) {
        if (print) {
            System.out.println("\t[INFO] " + string);
        }
    }

    public Configuration getConfiguration() {
        return configuration;
    }

    public void setConfiguration(Configuration configuration) {
        this.configuration = configuration;
    }

}
