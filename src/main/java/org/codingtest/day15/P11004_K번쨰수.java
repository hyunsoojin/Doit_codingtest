package org.codingtest.day15;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P11004_K번쨰수 {

  public static void main(String[] args) throws IOException {
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(in.readLine());
    int N = Integer.parseInt(st.nextToken());
    int K = Integer.parseInt(st.nextToken());
    st = new StringTokenizer(in.readLine());
    int[] A = new int[N];
    for (int i = 0; i < N; i++){
      A[i] = Integer.parseInt(st.nextToken());
    }
    quickSort(A, 0, N-1, K-1);
    System.out.println(A[K - 1]);
  }

  private static void quickSort(int[] A, int S, int E, int K) {
    if (S < E){
      int pivot = partition(A, S, E);
      if (pivot == K)
        return;
      else if(K < pivot)
        quickSort(A, S, pivot - 1, K);
      else
        quickSort(A,pivot + 1, E, K);
    }
  }

  private static int partition(int[] A, int S, int E) {
    if(S+1 == E) {
      if (A[S] > A[E])
        swap(A, S, E);
      return E;
    }
    int M = (S + E) / 2;
    swap(A, S, M);
    int pivot = A[S];
    int i = S+1, j = E;
    while(i <= j){
      while(j >= S + 1 && pivot < A[j]){
        j--;
      }
      while(i <= E && pivot > A[i]){
        i++;
      }
      if(i <= j){
        swap(A, i++, j--);
      }
    }
    A[S] = A[j];
    A[j] = pivot;
    return j;
  }

  private static void swap(int[] A, int i, int j) {
    int temp = A[i];
    A[i] = A[j];
    A[j] = temp;
  }

}
