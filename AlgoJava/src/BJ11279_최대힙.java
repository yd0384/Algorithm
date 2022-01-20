import java.io.*;
import java.util.*;
//최소힙에서는 클래스 사용 안하고 풀었는데 코드 재사용 하면서 클래스 방식으로 변환
public class BJ11279_최대힙 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        MaxHeap heap = new MaxHeap();
        for (int i = 0; i < N; i++) {
            int x = Integer.parseInt(br.readLine());
            if(x==0){
                System.out.println(heap.delete());
            }
            else{
                heap.insert(x);
            }
        }
    }
    public static class MaxHeap{
        List<Integer> heap;
        public MaxHeap() {
            heap = new ArrayList<>();
            //index 0 채워넣기
            heap.add(0);
        }

        public void insert(int val){
            heap.add(val);
            int index = heap.size() - 1;
            while(true){
                int parentIndex = index / 2;
                if(parentIndex==0){
                    //루트노드라면 탈출
                    return;
                }
                int parentValue = heap.get(parentIndex);
                //2. 해당 노드와 부모 노드 힙 조건 비교
                if(val > parentValue){
                    //3. 만족하지 않으면 서로 스왑
                    heap.set(parentIndex, val);
                    heap.set(index, parentValue);
                    index = parentIndex;
                }
                else{
                    // 힙 조건을 만족하면 탈출
                    return;
                }
            }
        }

        public int delete(){
            if(heap.size()==1){
                return 0;
            }
            else{
                //1. 루트 노드 삭제(출력)
                int top = heap.remove(1);
                //2. 가장 마지막 노드 루트 자리로 삽입
                //단 트리가 비어있으면 안함
                if(heap.size()==1){
                    return top;
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
                        return top;
                    }
                    // leftChild만 존재할 때: 조건에 맞지 않으면 변경 후 둘 다 탈출
                    else if(heap.size() - 1 == leftChildIndex){
                        int leftChildValue = heap.get(leftChildIndex);
                        if(value < leftChildValue){
                            heap.set(index, leftChildValue);
                            heap.set(leftChildIndex, value);
                        }
                        return top;
                    }
                    //모든 자식이 존재할 때
                    else{
                        int leftChildValue = heap.get(leftChildIndex);
                        int rightChildValue = heap.get(rightChildIndex);
                        if(value < leftChildValue){
                            if(leftChildValue < rightChildValue){
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
                        //rightchild만 클때 rightchild와 스왑
                        else if(value < rightChildValue){
                            heap.set(index, rightChildValue);
                            heap.set(rightChildIndex, value);
                            index = rightChildIndex;
                        }
                        //힙 조건이 맞는 상태일 때 탈출
                        else{
                            return top;
                        }
                    } 
                }

            }
        }
    }
}
