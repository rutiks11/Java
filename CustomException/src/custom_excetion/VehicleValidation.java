package custom_excetion;

import vehiclemain.Color;

public class VehicleValidation {
	public static final Double triggerRate = 20.0;

	public static void ChkPollutionRate(Double Rate) throws PollutionLevExceedException {
		if (Rate > 20)
			throw new PollutionLevExceedException("Pollution Rate Exceed");
	}

	public static Color ChkColorAvailibility(String col) {
		// Try for ordinary Value
		// int ichoice = Integer.parseInt(col);

		// valueof method in enum
		return Color.valueOf(col.toUpperCase());
	}

	public static void ChkKilometers(Double km) throws PollutionLevExceedException {
		if (km > 5000)
			throw new PollutionLevExceedException("Need Maintainance");
	}
}
