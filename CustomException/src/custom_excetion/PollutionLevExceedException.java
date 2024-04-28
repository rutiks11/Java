package custom_excetion;

@SuppressWarnings("serial")
public class PollutionLevExceedException extends Exception {
	public PollutionLevExceedException(String msg) {
		super(msg);
	}
}
