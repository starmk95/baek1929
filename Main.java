import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int sNum = sc.nextInt();
        int eNum = sc.nextInt();
        int[] prime = new int[eNum-sNum+1]; // 소수 저장
        int pn = 0; // 소수의 개수
        boolean[] check = new boolean[eNum+1]; // 에라토스체네스의 체 구현 (지워지면 true)
        // 소수의 개수를 파악하는데 에라토스체네스의 체를 사용
        // 에라토스체네스의 체는 2개의 단계를 반복 수행하는 것으로 이루어진다.
        // 1. 지워지지 않은 수 중에서 가장 작은 수 -> 소수이다.
        // 2. 1단계에서 구한 소수의 배수들을 모두 지원준다.
        // 해당과정 반복
        for (int i=2;i<eNum+1;i++) { // 들어온 정수들과 그 사이 정수들에 대해 소수 판별
            // 그 사이 정수들에 대한 것이라 하더라도 i=2부터 수행해주어야 소수들이 제대로 지워짐
            if (check[i] ==  false) { // 해당 수가 지워져 있는지 확인 (1단계)
                // 지워져 있지 않다면(false) 소수임
                if (i >= sNum) { // 시작 범위 보다 큰 정수만
                    prime[pn++] = i; // 구한 소수 배열에 넣어주고, 개수 갱신
                }
                for (int j=i+i;j<=eNum;j+=i) { // 구한 소수의 배수들을 모두 지워줌 (2단계)
                    // j 값은 i*2, ..., i(i+1), i(i+2), ...순으로 증가한다.
                    // j=i*i로 사용하면 시간을 더 단축할 수 있지만 
                    // 해당 문제의 입력의 범위에서 i는 최대 1,000,000까지 들어올 수 있다.
                    // 이 때 i*i는 java에서 int의 범위인 -2147483648 ~ 2147483647를 넘어가기 때문에 런타임에러가 발생하게 된다.
                    // 때문에 입력이 큰 수에 대해서는 j의 시작 값을 i+i 또는 i*2로 설정해주어야 한다.
                    
                    // j=i*i의 경우에 j 값이 i*2, ... 부터 시작하지 않는 이유는
                    // 예를 들어 i=6이라면 6보다 작은 수에 대한 배수들은 이미 지워졌기 때문이다. (i=2~5일 때 이미 각 배수들이 모두 지워졌으므로 이 과정을 스킵할 수 있음)
                    check[j] = true; // 해당 수 지우기
                }
            }
        }
        for (int i=0;i<pn;i++) {
            System.out.println(prime[i]);
        }
    }
}
