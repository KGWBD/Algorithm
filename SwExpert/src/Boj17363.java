import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Boj17363 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	static int N,M;
	static char[][] input;
	static char[][] output;
	
	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		input = new char[N][M];
		output = new char[M][N];
		
		for(int i = 0 ; i < N ;i++) {
			input[i] = br.readLine().toCharArray();
			
		}
		for(int i = 0; i <M ;i++) {
			Arrays.fill(output[i], '.');
		}
		for(int i = 0 ; i < N ;i++) {
			for(int j = 0 ; j < M ; j++) {
				if(input[i][j]!='.') {
					switchChar(i,j);
				}
			}
		}
		
		for(int i = 0 ; i < M; i++) {
			for(int j = 0 ; j < N ; j++) {
				bw.write(output[i][j]);
			}
			bw.write("\n");
		}
		bw.close();
	}

	private static void switchChar(int i, int j) {
		char temp = input[i][j];
		switch(temp) {
		case '-':
			output[M-j-1][i] = '|';
			break;
		case '|':
			output[M-j-1][i] = '-';
			break;
		case '/':
			output[M-j-1][i] = '\\';
			break;
		case '\\':
		output[M-j-1][i] = '/';
		break;
		case '^':
			output[M-j-1][i] = '<';
			break;
		case '<':
			output[M-j-1][i] = 118;
			break;
		case 118:
			output[M-j-1][i] = '>';
			break;
		case '>':
			output[M-j-1][i] = '^';
			break;
			default:
				output[M-j-1][i] = 'O';
				break;
		}
	}
}
