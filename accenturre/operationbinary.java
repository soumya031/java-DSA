public class operationbinary {
    public int binaryToDecimal(String str) {
        if(str == null){
            return -1;
        }
        int res = str.charAt(0) - '0';
        for(int i = 1; i < str.length(); i++){
            char ch = str.charAt(i);
            if(ch == '0' || ch == '1'){
                res = res * 2 + (ch - '0');
            } else {
                res = res | (str.charAt(i) - '0');
            }    
        }
        return res;
    }
    public static void main(String[] args) {
        operationbinary ob = new operationbinary();
        String binaryString = "1101"; 
        int decimalValue = ob.binaryToDecimal(binaryString);
        System.out.println("Binary: " + binaryString + " -> Decimal: " + decimalValue);
    }
}
