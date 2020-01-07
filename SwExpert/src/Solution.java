import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution {
	static class File implements Comparable<File>{
		String file;
		String head;
		int number;
		File(String file){
			this.file = file;
		}
		public void split(int headIdx, int numberIdx) {
			this.head = file.substring(0, headIdx);
			if(this.head.contains(" ")) {
				this.head = this.head.split(" ")[0];
			}else if(this.head.contains("-")) {
				this.head = this.head.split("-")[0];
			}
			this.number = Integer.parseInt(file.substring(headIdx, numberIdx-1));
		}
		@Override
		public String toString() {
			return "File [file=" + file + ", head=" + head + ", number=" + number + "]";
		}
		@Override
		public int compareTo(File f) {
			if(this.head.equalsIgnoreCase(f.head)) {
				return this.number - f.number;
			} else {
				return this.head.compareToIgnoreCase(f.head);
			}
		}
		
	}
	public static void main(String[] args) {
		solution(new String[] {"img12.png", "img10.png", "img02.png", "img1.png", "IMG01.GIF", "img2.JPG"});
//		solution(new String[] {"F-5 Freedom Fighter", "B-50 Superfortress", "A-10 Thunderbolt II", "F-14 Tomcat"});
		
	}
	
	public static String[] solution(String[] files) {
		List<File> fileList = new ArrayList<File>();
		for(String str : files) {
			System.out.println(str);
			int headIdx = 0;
			int numberIdx = 0;
			int length = str.length();
			boolean flag = false;
			File file = new File(str);
			for(int i = 0 ; i < length; i++) {
				char temp = str.charAt(i);
				if(temp>='0' && temp<='9') {
					if(!flag) {
						headIdx =i;
						flag = true;
					}
					numberIdx = i+1;
					while(numberIdx<length) {
						temp = str.charAt(numberIdx++);
						if(temp<'0' || temp>'9') {
							break;
						}
					} // while
				}
			}
			file.split(headIdx, numberIdx);
			fileList.add(file);
		}
		for(File f : fileList) {
			System.out.println(f);
		}
		
		Collections.sort(fileList);

		System.out.println("-==----------");
		for(File f : fileList) {
			System.out.println(f);
		}
		String[] answer = new String[fileList.size()];
		for(int i = 0 ; i < fileList.size(); i++) {
			answer[i] = fileList.get(i).file;
		}
		return answer;
	}
}