package objects;

import java.util.ArrayList;
import java.util.List;

public class Configuration {

    protected List<Child> children;
    protected License license;
    private List<Child> childrenToBeAdded;

    private List<String> rejections;

    public List<String> getRejections() {
        if (rejections == null) {
            rejections = new ArrayList<>();
        }

        return rejections;
    }

    public void setRejections(List<String> rejections) {
        this.rejections = rejections;
    }

    public void addRejection(String string) {
        if (getRejections() == null) {
            setRejections(new ArrayList<>());
        }

        getRejections().add(string);
    }

    public List<Child> getChildren() {
        return children;
    }

    public void setChildren(List<Child> children) {
        this.children = children;
    }

    public License getLicense() {
        return license;
    }

    public void setLicense(License license) {
        this.license = license;
    }

    public List<Child> getChildrenToBeAdded() {
        return childrenToBeAdded;
    }

    public void setChildrenToBeAdded(List<Child> childrenToBeAdded) {
        this.childrenToBeAdded = childrenToBeAdded;
    }


}
