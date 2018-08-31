package yahoo.sofiia.riazanova;

public class Main {

	public static void main(String[] args) {
		Network net = new Network();
		long mts[] = new long[] { 7837609, 3948030, 3788280, 1827323 };
		net.setName("MTS");
		net.setNetwork(mts);
		Phone phoneOne = new Phone();
		phoneOne.registerNumber(net);
		Phone phoneTwo = new Phone();
		phoneTwo.registerNumber(net);
		phoneTwo.call(net);

	}
}
