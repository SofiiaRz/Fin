package yahoo.sofiia.riazanova;

import java.util.Scanner;

public class Phone {
	private long yourNumber;
	private String model;

	public Phone(long yourNumber, String model) {
		this.yourNumber = yourNumber;
		this.model = model;
	}

	public Phone() {
	}

	public long getYourNumber() {
		return yourNumber;
	}

	public void setYourNumber(long yourNumber) {
		this.yourNumber = yourNumber;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	@Override
	public String toString() {
		return "Phone [yourNumber=" + yourNumber + ", model=" + model + "]";
	}

	public void registerNumber(Network network) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Input your phone number for registration");
		yourNumber = sc.nextLong();
		if (yourNumber < 999_999 || yourNumber > 999_99_99) {
			System.out.println("Wrong number");
		} else {
			network.registerNumber(yourNumber);
		}
	}

	public void call(Network network) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Input  phone number  you are trying to call");
		long numYouCall = sc.nextLong();
		if (numYouCall < 999_999 || numYouCall > 999_99_99) {
			System.out.println("Wrong number");
		} else {
			network.compareNumber(yourNumber, numYouCall);
		}
		sc.close();
	}

	public void incomingCall(long numberWasCalled) {
		if (yourNumber == numberWasCalled) {
			System.out.println("You have a call");
		}
	}
}
