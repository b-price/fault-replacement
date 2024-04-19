public class OptimalReplacement extends FaultReplacement{
    public OptimalReplacement(int[] pageReference, int numFrames) {
        super(pageReference, numFrames);
    }

    @Override
    public int calculateFaults() {
        for (int j : pageReference) {
            if (!frames.contains(j)) {
                if (frames.size() >= numFrames) {
                    removeOpt();
                }
                frames.add(j);
                faults++;
            }
        }
        return faults;
    }

    private void removeOpt(){
        int max = 0;
        int toRemove = 0;
        for (int i = 0; i < frames.size(); i++){
            for (int j = 0; j < pageReference.length; j++){
                if (pageReference[j] == frames.get(i)){
                    if (j > max){
                        max = j;
                        toRemove = i;
                    }
                    break;
                }
            }
        }
        frames.remove(toRemove);
    }
}
