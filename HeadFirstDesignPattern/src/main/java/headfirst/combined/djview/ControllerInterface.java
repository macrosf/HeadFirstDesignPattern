package headfirst.combined.djview;

public interface ControllerInterface {
	void start();
	void stop();
	void increaseBPM();
	void decreaseBPM();
 	void setBPM(int bpm);
 	
    boolean isBPMButtonEnabled();
    boolean isIncreaseBPMButtonEnabled();
    boolean isDecreaseBPMButtonEnabled(); 	 	
}
