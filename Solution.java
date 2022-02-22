package algos.dp.LongestCommonSubSequence;

import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] a= new int[n];
        int[] b = new int[m];
        for(int i=0;i<n;i++)
            a[i]=sc.nextInt();
        for(int i=0;i<m;i++)
            b[i]=sc.nextInt();
        System.out.println(printLCS(a,b,n,m));
    }

    public static String printLCS(int[]a,int[]b,int n,int m){
        String response="";
        int[][] arr=new int[n+1][m+1];
        int i,j=0;
        for(i=0;i<n+1;i++){
            for(j =0;j<m+1;j++){
                if(i==0|| j==0){
                    arr[i][j]=0;
                    continue;
                }
                if(a[i-1]==b[j-1])
                    arr[i][j]=arr[i-1][j-1]+1;
                else
                    arr[i][j]= Math.max(arr[i][j-1], arr[i-1][j]);
            }
        }
        i--;
        j--;
        while(i>0 && j>0){
            if(a[i-1]==b[j-1]){
                response=a[i-1]+" "+response;
                i--;
                j--;
            }else{
                if(arr[i][j-1]>=arr[i-1][j])
                    j--;
                else
                    i--;
            }
        }
        return response.trim();
    }
}
