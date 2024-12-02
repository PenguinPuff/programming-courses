package de.tum.cit.ase;

public class Door {
    private boolean isOpened;

    public Door() {
        this.isOpened = false;
    }

    public boolean isOpened() {
        return isOpened;
    }

    public void setOpened(boolean opened) {
        isOpened = opened;
    }

    @Override
    public String toString() {
        return "Door{" +
                "isOpened=" + isOpened +
                '}';
    }
}
