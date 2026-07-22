class Solution {
    public boolean isPalindrome(String s) {
        char[] letters = s.toCharArray();
        int first = 0;
        int last = letters.length - 1;

        while(first < last){
            while((first < letters.length) && (!Character.isLetterOrDigit(letters[first]))) {
            first++;
            }
            while((last > 0) && (!Character.isLetterOrDigit(letters[last]))) {
            last--;
            }
            if(first > last) return true;
            if(Character.toLowerCase(letters[first]) != Character.toLowerCase(letters[last])){
                System.out.println(first + " " + last);
                return false;
            }
            first++;
            last--;
            
        }
        
        return true;
    }
}
