public class FIFOFaultReplacement extends FaultReplacement{
    public FIFOFaultReplacement(int[] pageReference, int numFrames){
        super(pageReference, numFrames);
    }

    @Override
    public int calculateFaults() {
        for (int j : pageReference) {
            if (!frames.contains(j)) {
                if (frames.size() >= numFrames) {
                    frames.remove(0);
                }
                frames.add(j);
                faults++;
            }
        }
        return faults;
    }
}
