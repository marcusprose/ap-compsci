public class Unit5 {

  public static void main(String[] args) {
    System.out.println(isPalindrome("racecar"));
    System.out.println(isPalindrome("palindrome"));
    System.out.println(isPalindrome("dogeeseseegod"));
    collatzSequence(13);

  }
  public static boolean isPalindrome(String palindrome) {
    if (palindrome.length() < 2) {
      return true;
    }
    String first = palindrome.substring(0,1);
    String last = palindrome.substring(palindrome.length() - 1);
    if (first.equals(last)){
      return isPalindrome(palindrome.substring(1, palindrome.length() - 1));
    }
    else {
      return false;
    }
  }

  public static int triangleNumbers(int t) {
    if (t == 1){
      return t;
    }
    return t + triangleNumbers(t-1);
  }

  public static void collatzSequence(int n) {
    System.out.print(n + " ");
    if (n == 1) {
      return;
    }
    if (n % 2 == 0) {
      collatzSequence(n/2);
    }
    else {
      collatzSequence(3*n+1);
    }

  }
}
