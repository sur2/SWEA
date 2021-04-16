import java.io.*;
 
// 11688. Calkin-Wilf tree 1 D3
public class Solution {
 
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
 
        int T = Integer.parseInt(br.readLine());
 
        for (int t = 1; t <= T; t++) {
            String input = br.readLine();
            int a = 1, b = 1;
            int[] pair = null;
            for (int i = 0; i < input.length(); i++) {
                pair = Calculate(a, b, input.charAt(i));
                a = pair[0];
                b = pair[1];
            }
            bw.write("#" + t + " " + a + " " + b + "\n");
            bw.flush();
        }
        bw.close();
        br.close();
    }
 
    // [0] = a, [1] = b
    public static int[] Calculate(int a, int b, char Dir) {
        if (Dir == 'L') {
            b += a;
        } else {
            a += b;
        }
        int[] result = {a, b};
        return result;
    }
 
}