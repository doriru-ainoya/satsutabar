package cs20models;

/**
 * A class to model the problem or situation your program solves
 *
 * @author cheng
 */
public class Backend {

    private int displayedNumber;

    public Backend() {
        this.displayedNumber = 0;
    }

    public int getDisplayedNum() {
        return this.displayedNumber;
    }

    public void setDisplayedNum(int num) {
        this.displayedNumber = num;
    }
    
    public String getDisplayedNumStr() {
        return String.valueOf(this.displayedNumber);
    }

}
