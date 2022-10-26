package leetcode.practise;

class Solution1672 {
	
    public int maximumWealth(int[][] accounts) {
    	int richestPersonAmount = 0;
    	for (int i = 0; i < accounts.length; i++) {
        	int totalBankAmount = 0;
    		for (int j =0; j < accounts[i].length; j++) {
    			totalBankAmount += accounts[i][j];
    		}
    		if (i == 0) {
    			richestPersonAmount = totalBankAmount;
    		}
    		if (totalBankAmount > richestPersonAmount)
    			richestPersonAmount = totalBankAmount;
    		
    	}
    	return richestPersonAmount;
        
    }
};

public class Leetcode1672RichestCustomerWealth {
	public static void main(String[] args) {
		int[][] accountsInput1= new int[3][];
		
		
		int[][] accounts = {
				{1,2,3},
				{4,5,6}
		};
		
		Solution1672 solution = new Solution1672();
		System.out.println(  solution.maximumWealth(accounts));
	}
		

}
