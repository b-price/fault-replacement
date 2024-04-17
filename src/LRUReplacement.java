public class LRUReplacement extends FaultReplacement{
    private int[] frameHistory;
    public LRUReplacement(int[] pageReference, int numFrames) {
        super(pageReference, numFrames);
        frameHistory = new int[numFrames];
    }

    @Override
    public int calculateFaults() {
        for (int j : pageReference) {
            if (!frames.contains(j)) {
                if (frames.size() >= numFrames) {
                    removeLRU();
                }
                frames.addFirst(j);
                faults++;
            }
            for (int i = 0; i < frameHistory.length; i++){
                frameHistory[i]++;
            }
        }
        return faults;
    }

    private void removeLRU(){
        int max = 0;
        for (int i = 0; i < frameHistory.length; i++){
            if (frameHistory[i] > max){
                max = i;
            }
        }
        Object[] array = frames.toArray();
        int toRemove = (int) array[max];
        frames.remove(toRemove);
        frameHistory[max] = 0;
    }
}
