public class FIFOFaultReplacement extends FaultReplacement{
    public FIFOFaultReplacement(int[] pageReference, int numFrames){
        super(pageReference, numFrames);
    }

    @Override
    public int calculateFaults() {
        for (int j : pageReference) {
            if (!frames.contains(j)) {
                if (frames.size() >= numFrames) {
                    frames.removeLast();
                }
                frames.addFirst(j);
                faults++;
            }
        }
        return faults;
    }

//    private boolean contains(int ref){
//        for (int i = 0; i < numFrames; i++){
//            if (frames[i] == ref){
//                return true;
//            }
//        }
//        return false;
//    }


}
