import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Set;

public class Problem5658 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static LinkedList<String> list;
	static LinkedList<String> ans;
	static Set<String> set;
	
    public static void main(String[] args) throws NumberFormatException, IOException {   
    	
    	int tc = Integer.parseInt(br.readLine());
//    	int tc = 1;
    	for(int t = 1; t<=tc;t++) {
    		String in = br.readLine();
    		
    		int N = Integer.parseInt(in.split(" ")[0]);
    		int K = Integer.parseInt(in.split(" ")[1]);
    		list = new LinkedList<String>();
    		ans = new LinkedList<String>();
    		String[] ins = br.readLine().split("");
    		
    		for(int i =0; i < ins.length;i++) {
    			list.add(ins[i]);
    		}
    		int len = N / 4;
    		int rota = len+1;
    		set = new HashSet<String>();
    		for(int r = 0; r<rota;r++) {
    			String tmp = "";
    			
    			for(int i =0;i<list.size();i++) {
    				tmp += list.get(i);
    				if(tmp.length()%len==0) {
    					set.add(tmp);
    					tmp = "";
    				}
    			}
    			list.add(list.poll());
    		}
    		
    		
    		Iterator<String> it = set.iterator();
    		while(it.hasNext()) {
    			ans.add(it.next());
    		}
    		
    		Collections.sort(ans);
    		System.out.format("#%d %d\n",t,Long.parseLong(ans.get(ans.size()-K),16));
    		
    		
    		
    	} //testCase
    	
    	
    	
    	
    	
    }
}