import java.util.HashMap;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		HashMap<Integer, Data> map = new HashMap<Integer, Data>();
		int data; StringBuilder sb = new StringBuilder();
		for(int i = 0; i < n; i++) {
			data = sc.nextInt();
			if(map.containsKey(data)) map.get(data).add(i);
			else map.put(data, new Data(data, i));
			sb.append("A");
		}
		sc.close();
		
		int cnt = 0;
		boolean adjust = false;
		for(Data temp: map.values()) {
			if(temp.cnt == 1) cnt++;
			if(temp.cnt > 2) adjust = true;
		}
		if(cnt%2 == 1 && !adjust) {
			System.out.println("NO");
		}
		else if(cnt%2 == 1 && adjust){
			System.out.println("YES");
			int cnt2 = 0; Data adj = null;
			for(Data temp: map.values()) {
				if(temp.cnt == 1) {
					cnt2++;
					if(cnt2 <= cnt/2) {
						sb.replace(temp.loc[0], temp.loc[0]+1, "B");
					}
				}
				if(temp.cnt > 2) adj = temp;
			}
			sb.replace(adj.loc[0], adj.loc[0]+1, "B");
			System.out.println(sb.toString());
		}
		else {
			System.out.println("YES");
			int cnt2 = 0;
			for(Data temp: map.values()) {
				if(temp.cnt == 1) {
					cnt2++;
					if(cnt2 <= cnt/2) {
						sb.replace(temp.loc[0], temp.loc[0]+1, "B");
					}
				}
			}
			System.out.println(sb.toString());
		}
	}
}

class Data {
	int val;
	int cnt;
	int[] loc;
	
	public Data(int val, int lo) {
		this.val = val;
		loc = new int[101];
		loc[cnt++] = lo;
	}
	
	public void add(int lo) {
		loc[cnt++] = lo;
	}
}

