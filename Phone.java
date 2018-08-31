package yahoo.sofiia.riazanova;

import java.util.Scanner;

public class Phone {
	private long yourNumber;

	public Phone(long yourNumber) {
		this.yourNumber = yourNumber;
	}

	public Phone() {
	}

	public long getYourNumber() {
		return yourNumber;
	}

	public void setYourNumber(long yourNumber) {
		this.yourNumber = yourNumber;
	}

	@Override
	public String toString() {
		return "Phone [yourNumber=" + yourNumber + "]";
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
		long numYouCall = 0L;
		Scanner sc = new Scanner(System.in);
		System.out.println("Input  phone number  you are trying to call");
		numYouCall = sc.nextLong();
		if (numYouCall < 999_999 || numYouCall > 999_99_99) {
			System.out.println("Wrong number");
		} else {
			network.compareNumber(yourNumber, numYouCall);
		}
		sc.close();
	}

}
