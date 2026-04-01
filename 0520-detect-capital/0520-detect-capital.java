class Solution {
    public boolean detectCapitalUse(String w) {
        return w.equals(w.toUpperCase()) || w.equals(w.toLowerCase()) || (Character.isUpperCase(w.charAt(0)) && w.substring(1).equals(w.substring(1).toLowerCase()));
    }
}