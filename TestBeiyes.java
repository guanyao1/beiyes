package beiyes;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;

public class TestBeiyes {
	/**
	 * 朴素贝叶斯算法 算法的思想
	 */
	public static ArrayList<JavaBean> list = new ArrayList<JavaBean>();;
	static int data_length = 0;

	public static void main(String[] args) {
		// 1.读取数据，放入list容器中
		File file = new File("C:\\Users\\wang4\\Desktop\\beiyes.txt");
		txt2String(file);
		// 数据测试样本
		testData(25, "Medium", "Yes", "Fair");
	}

	// 读取样本数据
	public static void txt2String(File file) {

		try {
			BufferedReader br = new BufferedReader(new FileReader(file));// 构造一个BufferedReader类来读取文件
			String s = null;
			while ((s = br.readLine()) != null) {// 使用readLine方法，一次读一行
				data_length++;
				splitt(s);
			}
			br.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	// 存入ArrayList中
	public static void splitt(String str) {

		String strr = str.trim();
		String[] abc = strr.split("[\\p{Space}]+");
		int age = Integer.parseInt(abc[0]);
		JavaBean bean = new JavaBean(age, abc[1], abc[2], abc[3], abc[4]);
		list.add(bean);

	}

	// 训练样本，测试
	public static void testData(int age, String a, String b, String c) {
		// 训练样本
		int number_yes = 0;
		int bumber_no = 0;

		// age情况 个数
		int num_age_yes = 0;
		int num_age_no = 0;
		// income
		int num_income_yes = 0;
		int num_income_no = 0;
		// student
		int num_student_yes = 0;
		int num_stdent_no = 0;
		// credit
		int num_credit_yes = 0;
		int num_credit_no = 0;

		// 遍历List 获得数据
		for (int i = 0; i < list.size(); i++) {
			JavaBean bb = list.get(i);
			if (bb.getBuys_computer().equals("Yes")) { // Yes
				number_yes++;
				if (bb.getIncome().equals(a)) {// income
					num_income_yes++;
				}
				if (bb.getStudent().equals(b)) {// student
					num_student_yes++;
				}
				if (bb.getCredit_rating().equals(c)) {// credit
					num_credit_yes++;
				}
				if (bb.getAge() == age) {// age
					num_age_yes++;
				}

			} else {// No
				bumber_no++;
				if (bb.getIncome().equals(a)) {// income
					num_income_no++;
				}
				if (bb.getStudent().equals(b)) {// student
					num_stdent_no++;
				}
				if (bb.getCredit_rating().equals(c)) {// credit
					num_credit_no++;
				}
				if (bb.getAge() == age) {// age
					num_age_no++;
				}

			}
		}

		System.out.println("购买的历史个数:" + number_yes);
		System.out.println("不买的历史个数:" + bumber_no);

		System.out.println("购买+age:" + num_age_yes);
		System.out.println("不买+age:" + num_age_no);

		System.out.println("购买+income:" + num_income_yes);
		System.out.println("不买+income:" + num_income_no);

		System.out.println("购买+stundent:" + num_student_yes);
		System.out.println("不买+student:" + num_stdent_no);

		System.out.println("购买+credit:" + num_credit_yes);
		System.out.println("不买+credit:" + num_credit_no);

		// // 概率判断
		double buy_yes = number_yes * 1.0 / data_length; // 买的概率
		double buy_no = bumber_no * 1.0 / data_length; // 不买的概率
		System.out.println("训练数据中买的概率:" + buy_yes);
		System.out.println("训练数据中不买的概率:" + buy_no);
		// / 未知用户的判断
		double nb_buy_yes = (1.0 * num_age_yes / number_yes)
				* (1.0 * num_income_yes / number_yes)
				* (1.0 * num_student_yes / number_yes)
				* (1.0 * num_credit_yes / number_yes) * buy_yes;
		double nb_buy_no = (1.0 * num_age_no / bumber_no)
				* (1.0 * num_income_no / bumber_no)
				* (1.0 * num_stdent_no / bumber_no)
				* (1.0 * num_credit_no / bumber_no) * buy_no;
		System.out.println("新用户买的概率:" + nb_buy_yes);
		System.out.println("新用户不买的概率:" + nb_buy_no);
		if (nb_buy_yes > nb_buy_no) {
			System.out.println("新用户买的概率大");
		} else {
			System.out.println("新用户不买的概率大");
		}
	}
}
