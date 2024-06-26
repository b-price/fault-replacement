import java.util.ArrayList;

public abstract class FaultReplacement {
    protected int[] pageReference;
    protected int numFrames;
    protected ArrayList<Integer> frames;
    protected int faults;

    public FaultReplacement(int[] pageReference, int numFrames){
        this.pageReference = pageReference;
        this.numFrames = numFrames;
        frames = new ArrayList<>(numFrames);
        faults = 0;
    }

    public abstract int calculateFaults();
}
