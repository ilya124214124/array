import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        //************************************************************2
        System.out.println("Кількість рядків:");
        int n = scan.nextInt();
        System.out.println("Кількість стовпців:");
          int m = scan.nextInt();
        int a[][] = new int[n][m];
       int [] count = new int[a.length];
        int sum[] = new int[m];
        int c[] = new int[m];

        for (int i = 0; i < a.length; i++)
            for (int j = 0; j < a[i].length; j++)
                a[i][j] = (int) (Math.random() * 20 - 10);
        System.out.println("Вихідний двовимірний масив ");
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++)
                System.out.printf("%8d", a[i][j]);
            System.out.println();
        }

        System.out.println("Сума відємних елементів у рядку: ");
       for(int i=0;i<a.length;i++){
            count[i]=0;
            for(int j=0;j<a[i].length;j++)
                if (a[i][j]<0) count[i]++;
        }

        for(int i=0;i<a.length;i++) {
            sum[i] = 0;
            for (int j = 0; j < a[i].length; j++)
                if (a[i][j] < 0) sum[i] += a[i][j];
            //System.out.println();
            System.out.print(sum [i] + " ");
        }

        /*************************/
        int i,j;
        int x;
        for(i=0; i <n-1; i++) {
            for (j= i+1;j<n;j++) {
                if(sum[i]>sum[j]) {
                    x=sum[i]; sum[i]=sum[j]; sum[j]=x;
                    c=a[i]; a[i]=a[j]; a[j]=c;
                }
            }
        }

        System.out.println("Упорядоченый двумерный масив ");
        for( i=0;i<a.length;i++){
            for( j=0;j<a[i].length;j++){
                System.out.printf("%7d",a[i][j]);
            }
            System.out.printf("%16d%n",sum[i]);
        }
        //--
        System.out.print("\n Максимум каждого столбца");
        for(j=0;j<m;j++){
            double max = a[0][j];
            for (i=0;i<n;i++) {
                if(a[i][j]>max)
                    max=a[i][j];
            }
            System.out.printf("%10.2f",max);
        }

    }
}