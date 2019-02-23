import java.util.ArrayList;

public class Homework11A extends Homework11 {

private ArrayList<Integer> list2;

	public Homework11A() {
		list2 = new ArrayList<Integer>();
	}

//Creation of list2 not necessary, but it's there.

  public int problem4() {
    int sum = 0;
    for (int i : list) {
      sum += i;
    }
    return sum;
  }

	@Override
  public void problem2(int n) {
    int i = 0;
    while (i < list.size()) {
        int num = list.get(i);
  			if ((n % num) != 0) {
  				list.remove(i);
  			} else {
  				i += 1;
  		}
  	}
  }
}
