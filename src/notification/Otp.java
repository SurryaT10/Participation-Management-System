package notification;

import java.text.DecimalFormat;
import java.util.Random;

public class Otp {
	public String otp = "";
	
	public Otp() {
		System.out.println("adsdsadsadas");
		otp = new DecimalFormat("000000").format(new Random().nextInt(999999));
		System.out.println(otp);
	}
}
