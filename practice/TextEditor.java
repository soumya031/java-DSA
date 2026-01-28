package practice;

public class TextEditor {
    StringBuilder res;
    int pos = 0;

    public TextEditor() {
        res = new StringBuilder();
    }
    
    public void addText(String text) {
        res.insert(pos, text);
        pos += text.length();
    }
    
    public int deleteText(int k) {
        int tmp = pos;
        pos -= k;
        if (pos < 0) pos = 0;
        res.delete(pos, tmp);
        return tmp - pos;
    }
    
    public String cursorLeft(int k) {
        pos -= k;
        if (pos < 0) pos = 0;
        
        // Safe substring: determine start by taking max of 0 or pos-10
        int start = Math.max(0, pos - 10);
        return res.substring(start, pos);
    }
    
    public String cursorRight(int k) {
        pos += k;
        // FIX: Check if pos is GREATER than length, not LESS
        if (pos > res.length()) pos = res.length();
        
        // Safe substring: determine start by taking max of 0 or pos-10
        int start = Math.max(0, pos - 10);
        return res.substring(start, pos);
    }

    public static void main(String[] args) {
        TextEditor editor = new TextEditor();
        editor.addText("hello");
        System.out.println(editor.cursorLeft(2)); // Output: "he"
        editor.addText(" world");
        System.out.println(editor.cursorRight(5)); // Output: "hello wo"
        System.out.println(editor.deleteText(3)); // Output: 3
    }
}

