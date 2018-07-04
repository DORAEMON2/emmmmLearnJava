/**
 * 
 */
package LeetCode;

import java.util.*;

/**
 * 给定两个以字符串形式表示的非负整数 num1 和 num2，返回 num1 和 num2 的乘积，它们的乘积也表示为字符串形式。

示例 1:

输入: num1 = "2", num2 = "3"
输出: "6"

示例 2:

输入: num1 = "123", num2 = "456"
输出: "56088"

说明：

    num1 和 num2 的长度小于110。
    num1 和 num2 只包含数字 0-9。
    num1 和 num2 均不以零开头，除非是数字 0 本身。
    不能使用任何标准库的大数类型（比如 BigInteger）或直接将输入转换为整数来处理
 * @author guo
 *
 */
public class multiply2string {
	public String multiply(String num1, String num2) {
		List<Character> sum = new ArrayList<>(num1.length()+num2.length()-1);
		for(int i = 0;i<sum.size();i++) {sum.set(i,'0');}
		
		int ix = 0;
		char tp;
		for (int i = num1.length()-1; i>=0;i--) {
			for (int j = num2.length()-1; j>=0; j--) {
				ix = (num1.length()-i)+(num2.length()-j);
				tp = (char)(sum.get(ix)-'0'+(num1.charAt(i)-'0')*(num2.charAt(j)-'0'));
				sum.set(ix,tp);
			}
		}
		
		
		int carry = 0;
		for(int i = 0;i<sum.size();i++) {
			int s = sum.get(i).charValue();
			int value = (s+carry)%10;
			carry = (s - value)/10;
			sum.set(i, (char)value);
		}
		Collections.reverse(sum);
		return sum.toString();
	}
	
	public char multipy2char(char a,char b, int carry) {
		int prod = (a-'0')*(b-'0')+carry;
		carry = prod/10;
		return (char) (prod%10+'0');
		
	}
	
	public static void main(String args[]) {
		System.out.println(new multiply2string().multiply("123", "456"));
	}


}
