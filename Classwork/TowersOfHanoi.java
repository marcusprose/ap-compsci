import java.util.ArrayList;

public class TowersOfHanoi {

  public static void main(String[] args) {
    ArrayList<Integer> one = new ArrayList<Integer>();
    ArrayList<Integer> two = new ArrayList<Integer>();
    ArrayList<Integer> three = new ArrayList<Integer>();
    for (int i = 0; i < 4; i++) {
      one.add(i);
      //Given 3 towers and four disks.
    }
    int count = moveTower(one.size(), two, one, three);
    System.out.println(count);
  }


  public static int moveTower(int disks, ArrayList<Integer> pegTo, ArrayList<Integer> pegFrom, ArrayList<Integer> pegOther) {
    if (disks == 1) {
      int i = pegFrom.remove(0);
      pegTo.add(0, i);
      System.out.println("Moved " + i + " from " + pegFrom + " " + "to " + pegTo + ".");
      return 1;
      //The top of peg is the start of the ArrayList; index 0 is smallest
    }
    int count = moveTower(disks - 1, pegOther, pegFrom, pegTo);
    count += moveTower(1, pegTo, pegFrom, pegOther);
    count += moveTower(disks - 1, pegTo, pegOther, pegFrom);
    return count;
  }



}
