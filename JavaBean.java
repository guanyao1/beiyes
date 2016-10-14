package beiyes;

public class JavaBean {
	int age;
	String income;
	String student;
	String credit_rating;
	String buys_computer;

	public JavaBean(int age, String income, String student,
			String credit_rating, String buys_computer) {
		this.age = age;
		this.income = income;
		this.student = student;
		this.credit_rating = credit_rating;
		this.buys_computer = buys_computer;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getIncome() {
		return income;
	}

	public void setIncome(String income) {
		this.income = income;
	}

	public String getStudent() {
		return student;
	}

	public void setStudent(String student) {
		this.student = student;
	}

	public String getCredit_rating() {
		return credit_rating;
	}

	public void setCredit_rating(String credit_rating) {
		this.credit_rating = credit_rating;
	}

	public String getBuys_computer() {
		return buys_computer;
	}

	public void setBuys_computer(String buys_computer) {
		this.buys_computer = buys_computer;
	}

	@Override
	public String toString() {
		return "JavaBean [age=" + age + ", income=" + income + ", student="
				+ student + ", credit_rating=" + credit_rating
				+ ", buys_computer=" + buys_computer + "]";
	}

}
