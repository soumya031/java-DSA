package ratingSystem;

import java.util.*;

class Spreadsheet {
    HashMap<String, Integer> map;

    public Spreadsheet(int rows) {
        map = new HashMap<>();
    }
    
    public void setCell(String cell, int value) {
        map.put(cell, value);
    }
    
    public void resetCell(String cell) {
        map.put(cell,0);
    }
    
    public int getValue(String formula) {
        String arr[] = formula.substring(1).split("\\+");
        return getCell(arr[0]) + getCell(arr[1]);
    }
    public int getCell(String cell){
        //"=x+y"
        if(cell.charAt(0) >= '0' && cell.charAt(0) <='9'){
            return Integer.parseInt(cell);
        }
        else return map.getOrDefault(cell,0);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of rows: ");
        int rows = sc.nextInt();
        sc.nextLine(); // consume newline
        Spreadsheet sheet = new Spreadsheet(rows);
        System.out.println("Commands:");
        System.out.println("1. set <cell> <value>");
        System.out.println("2. reset <cell>");
        System.out.println("3. get <formula> (e.g., =A1+B2 or =5+10)");
        System.out.println("4. exit");
        while(true) {
            System.out.print(">> ");
            String input = sc.nextLine().trim();
            if(input.equalsIgnoreCase("exit")) break;

            String[] parts = input.split(" ");
            if(parts[0].equalsIgnoreCase("set")) {
                sheet.setCell(parts[1], Integer.parseInt(parts[2]));
                System.out.println("Cell " + parts[1] + " set to " + parts[2]);
            } 
            else if(parts[0].equalsIgnoreCase("reset")) {
                sheet.resetCell(parts[1]);
                System.out.println("Cell " + parts[1] + " reset to 0");
            } 
            else if(parts[0].equalsIgnoreCase("get")) {
                int result = sheet.getValue(parts[1]);
                System.out.println("Value = " + result);
            } 
            else {
                System.out.println("Invalid command.");
            }
        }
    }
}

/**
 * Your Spreadsheet object will be instantiated and called as such:
 * Spreadsheet obj = new Spreadsheet(rows);
 * obj.setCell(cell,value);
 * obj.resetCell(cell);
 * int param_3 = obj.getValue(formula);
 */