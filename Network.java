package yahoo.sofiia.riazanova;

import java.util.Arrays;

public class Network {
	private long[] network;
	private String name;

	public Network(long[] network, String name) {
		this.network = network;
		this.name = name;
	}

	public Network() {
	}

	public long[] getNetwork() {
		return network;
	}

	public void setNetwork(long[] network) {
		this.network = network;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Network [network=" + Arrays.toString(network) + ", name=" + name + "]";
	}

	public void registerNumber(long yourNumber) {
		int k = 0;
		for (int i = 0; i < network.length; i++) {
			if (yourNumber != network[i]) {
				k = k + 1;
			}
		}
		if (k == network.length) {
			network = Arrays.copyOf(network, network.length + 1);
			Arrays.fill(network, network.length - 1, network.length, yourNumber);
			System.out.println("Your phone is registered");
		} else {
			System.out.println("This phone is already in system");
		}
	}

	public void compareNumber(long yourNumber, long numberYouCall) {
		Phone phoneYouCall = new Phone();
		int check = 0;
		for (int i = 0; i < network.length; i++) {
			if (numberYouCall == network[i] && numberYouCall != yourNumber) {
				System.out.println("Dialing");
				check = 1;
				phoneYouCall.incomingCall(numberYouCall);
				break;
			}
		}
		if (check == 0) {
			System.out.println("Can not connect. Wrong number");
		}
	}
}
