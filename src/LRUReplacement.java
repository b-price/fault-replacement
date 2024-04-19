import java.util.ArrayList;

public class LRUReplacement extends FaultReplacement{
    private ArrayList<Integer> frameHistory;

    public LRUReplacement(int[] pageReference, int numFrames) {
        super(pageReference, numFrames);
        frameHistory = new ArrayList<>(numFrames);
    }

    @Override
    public int calculateFaults() {
        for (int j : pageReference) {
            if (!frames.contains(j)) {
                if (frames.size() >= numFrames) {
                    removeLRU();
                } else {
                    frameHistory.add(0);
                }
                frames.add(j);
                faults++;
            }
            frameHistory.replaceAll(integer -> integer + 1);
        }
        return faults;
    }

    private void removeLRU(){
        int max = 0;
        for (int i = 0; i < frameHistory.size(); i++){
            if (frameHistory.get(i) > frameHistory.get(max)){
                max = i;
            }
        }
        frames.remove(max);
        frameHistory.set(max, 0);
    }
}
