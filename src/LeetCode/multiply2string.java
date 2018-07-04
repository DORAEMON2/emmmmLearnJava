/**
 * 
 */
package LeetCode;

import java.util.*;

/**
 * �����������ַ�����ʽ��ʾ�ķǸ����� num1 �� num2������ num1 �� num2 �ĳ˻������ǵĳ˻�Ҳ��ʾΪ�ַ�����ʽ��

ʾ�� 1:

����: num1 = "2", num2 = "3"
���: "6"

ʾ�� 2:

����: num1 = "123", num2 = "456"
���: "56088"

˵����

    num1 �� num2 �ĳ���С��110��
    num1 �� num2 ֻ�������� 0-9��
    num1 �� num2 �������㿪ͷ������������ 0 ����
    ����ʹ���κα�׼��Ĵ������ͣ����� BigInteger����ֱ�ӽ�����ת��Ϊ����������
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
