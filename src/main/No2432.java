public class No2432 {
    public static int hardestWorker(int n, int[][] logs) {
        //先计算出一个作为初始值
        int max = logs[logs.length - 1][1] - logs[logs.length - 2][1];
        int minId = logs.length - 1;

        for (int i = logs.length  - 2; i > 0; i--) {
            logs[i][1] = logs[i][1] - logs[i - 1][1];
            //System.out.println(logs[i][1]);
            if (logs[i][1] > max){
                max = logs[i][1];
                minId = i;
            }else if (logs[i][1] == max) {
                if (logs[i][0] < logs[minId][0])
                    minId = i;
            }
        }

        if (logs[0][1] > max){
            max = logs[0][1];
            minId = 0;
        }else if (logs[0][1] == max) {
            if (logs[0][0] < logs[minId][0])
                minId = 0;
        }
        return logs[minId][0];
    }

    public static void main(String[] args) {
        int[][] logs = {{0,10},{1,20}};
        //int[][] logs = {{1,3,2,7},{1,7,12,17}};
        //int[][] logs = {{0,3},{2,5},{0,9},{1,15}};
        System.out.println(hardestWorker(2, logs));
    }
}
