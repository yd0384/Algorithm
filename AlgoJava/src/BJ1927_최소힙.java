import java.io.*;
import java.util.*;

public class BJ1927_최소힙 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        List<Integer> heap = new ArrayList<>();
        //index 0 채워넣기
        heap.add(0);
        for (int i = 0; i < N; i++) {
            int x = Integer.parseInt(br.readLine());
            if(x==0){
                //delete
                //힙이 비어있는 경우
                if(heap.size()==1){
                    System.out.println(0);
                }
                else{
                    //1. 루트 노드 삭제(출력)
                    System.out.println(heap.remove(1));
                    //2. 가장 마지막 노드 루트 자리로 삽입
                    //단 트리가 비어있으면 안함
                    if(heap.size()==1){
                        continue;
                    }
                    heap.add(1, heap.remove(heap.size()-1));
                    //바꾼 위치의 노드가 힙 조건을 만족하는지 확인
                    int index = 1;
                    while(true){
                        int leftChildIndex = index * 2;
                        int rightChildIndex = index * 2 + 1;
                        int value = heap.get(index);
                        //leftchild가 존재하지 않을 때: 탈출
                        if(heap.size() - 1 < leftChildIndex){
                            break;
                        }
                        // leftChild만 존재할 때: 조건에 맞지 않으면 변경 후 둘 다 탈출
                        else if(heap.size() - 1 == leftChildIndex){
                            int leftChildValue = heap.get(leftChildIndex);
                            if(value > leftChildValue){
                                heap.set(index, leftChildValue);
                                heap.set(leftChildIndex, value);
                            }
                            break;
                        }
                        //모든 자식이 존재할 때
                        else{
                            int leftChildValue = heap.get(leftChildIndex);
                            int rightChildValue = heap.get(rightChildIndex);
                            if(value > leftChildValue){
                                if(leftChildValue > rightChildValue){
                                    //rightchild랑 현재 값 스왑
                                    heap.set(index, rightChildValue);
                                    heap.set(rightChildIndex, value);
                                    index = rightChildIndex;
                                }
                                else{
                                    //leftchild랑 현재 값 스왑
                                    heap.set(index, leftChildValue);
                                    heap.set(leftChildIndex, value);
                                    index = leftChildIndex;
                                }
                            }
                            //rightchild만 작을 때 rightchild와 스왑
                            else if(value > rightChildValue){
                                heap.set(index, rightChildValue);
                                heap.set(rightChildIndex, value);
                                index = rightChildIndex;
                            }
                            //힙 조건이 맞는 상태일 때 탈출
                            else{
                                break;
                            }
                        } 
                    }

                }

            }
            else{
                //insert
                //1. 마지막 위치에 노드 삽입
                heap.add(x);
                int index = heap.size() - 1;
                while(true){
                    int parentIndex = index / 2;
                    if(parentIndex==0){
                        //루트노드라면 탈출
                        break;
                    }
                    int parentValue = heap.get(parentIndex);
                    //2. 해당 노드와 부모 노드 힙 조건 비교
                    if(x < parentValue){
                        //3. 만족하지 않으면 서로 스왑
                        heap.set(parentIndex, x);
                        heap.set(index, parentValue);
                        index = parentIndex;
                    }
                    else{
                        // 힙 조건을 만족하면 탈출
                        break;
                    }
                }                                
            }
        }
    }
}
