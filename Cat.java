package yahoo.sofiia.riazanova;

public class Cat {
	private String name;
	private String gender;
	private String breed;
	private String health;
	private int age;
	private double weight;

	public Cat(String name, String gender, String breed, int age, double weight) {
		this.name = name;
		this.gender = gender;
		this.breed = breed;
		this.age = age;
		this.weight = weight;
	}

	public Cat() {
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getBreed() {
		return breed;
	}

	public void setBreed(String breed) {
		this.breed = breed;
	}

	public String getHealth() {
		return health;
	}

	public void setHealth(String health) {
		this.health = health;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	@Override
	public String toString() {
		return "Cat [name=" + name + ", gender=" + gender + ", breed=" + breed + ", health=" + health + ", age=" + age
				+ ", weight=" + weight + "]";
	}

	public void breedingCat(Cat firstCat, Cat secondCat) {
		if (firstCat.breed == secondCat.breed && firstCat.gender != secondCat.gender && firstCat.age > 3
				&& secondCat.age > 3 && firstCat.health == "healthy" && secondCat.health == "healthy") {
			System.out.println("This cats match.");
		} else if (firstCat.health != "healthy") {
			System.out.println("Check health of a cat " + firstCat.name);
			System.out.println("This cats do not match.");
		} else if (secondCat.health != "healthy") {
			System.out.println("Check health of a cat " + secondCat.name);
			System.out.println("This cats do not match.");
		} else {
			System.out.println("This cats do not match.");
		}
	}

	public String checkWeight(Cat cat) {
		if (cat.weight >= 3.5 && cat.weight <= 5.5) {
			return cat.health = "healthy";
		} else {
			return cat.health = "unhealthy";
		}
	}
}
