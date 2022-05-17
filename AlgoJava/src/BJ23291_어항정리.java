import java.util.*;
import java.io.*;

public class BJ23291_어항정리 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int k = 0;
        Deque<Deque<Integer>> fishBowl = new ArrayDeque<>();
        st = new StringTokenizer(br.readLine());
        // 어항 채우기
        for (int i = 0; i < N; i++) {
            Deque<Integer> tmp = new ArrayDeque<>();
            tmp.addFirst(Integer.parseInt(st.nextToken()));
            fishBowl.addLast(tmp);
        }
        while (true) {
            k++;
            // 모든 가장 적은 어항 + 1
            int minFish = Integer.MAX_VALUE;
            int currentInt = 0;
            for (Iterator<Deque<Integer>> it = fishBowl.iterator(); it.hasNext();) {
                currentInt = it.next().getFirst();
                if (currentInt < minFish) {
                    minFish = currentInt;
                }
            }
            Deque<Integer> currentDq = null;
            for (Iterator<Deque<Integer>> it = fishBowl.iterator(); it.hasNext();) {
                currentDq = it.next();
                if (currentDq.getFirst() == minFish) {
                    currentDq.addFirst(currentDq.removeLast() + 1);
                }
            }
            // 맨 왼쪽 어항 쌓기
            int leftFish = fishBowl.removeFirst().removeFirst();
            fishBowl.getFirst().add(leftFish);

            // 공중부양작업
            int length1, length2;
            while (true) {
                length1 = fishBowl.getFirst().size();
                length2 = 0;
                for (Iterator<Deque<Integer>> it = fishBowl.iterator(); it.hasNext();) {
                    if (it.next().size() < 2) {
                        length2++;
                    }
                }
                if (length1 > length2) {
                    break;
                }
                List<Deque<Integer>> skyBowl = new ArrayList<>();
                for (int i = 0; i < length1; i++) {
                    skyBowl.add(new ArrayDeque<>());
                }
                for (Iterator<Deque<Integer>> it = fishBowl.iterator(); it.hasNext();) {
                    currentDq = it.next();
                    if (currentDq.size() >= 2) {
                        for (int i = 0; !currentDq.isEmpty(); i++) {
                            skyBowl.get(i).addFirst(currentDq.removeFirst());
                        }
                    } else
                        break;
                }
                while (true) {
                    if (fishBowl.getFirst().isEmpty()) {
                        fishBowl.removeFirst();
                    } else {
                        break;
                    }
                }
                int index = 0;
                for (Iterator<Deque<Integer>> it = fishBowl.iterator();; index++) {
                    if (index == length1) {
                        break;
                    }
                    currentDq = it.next();
                    while (!skyBowl.get(index).isEmpty()) {
                        currentDq.addLast(skyBowl.get(index).removeFirst());
                    }
                }
            }
            // 어항 속 물고기 수 조절
            int width = fishBowl.size();
            int height = fishBowl.getFirst().size();
            int[] beforeArr = new int[height];
            int[][] variation = new int[height][width];
            int beforeInt = 0;
            int x = 0;
            int y = 0;
            for (Iterator<Deque<Integer>> it = fishBowl.iterator(); it.hasNext(); x++) {
                currentDq = it.next();
                y = 0;
                for (Iterator<Integer> it2 = currentDq.iterator(); it2.hasNext(); y++) {
                    currentInt = it2.next();
                    if (y != 0) {
                        int diff = Math.abs(beforeInt - currentInt) / 5;
                        if (diff > 0) {
                            if (beforeInt > currentInt) {
                                variation[y - 1][x] -= diff;
                                variation[y][x] += diff;
                            } else {
                                variation[y - 1][x] += diff;
                                variation[y][x] -= diff;
                            }
                        }
                    }
                    if (x != 0) {
                        int diff = Math.abs(beforeArr[y] - currentInt) / 5;
                        if (diff > 0) {
                            if (beforeArr[y] > currentInt) {
                                variation[y][x - 1] -= diff;
                                variation[y][x] += diff;
                            } else {
                                variation[y][x - 1] += diff;
                                variation[y][x] -= diff;
                            }
                        }
                    }
                    beforeInt = currentInt;
                    beforeArr[y] = currentInt;
                }
            }
            x = 0;
            y = 0;
            for (Iterator<Deque<Integer>> it = fishBowl.iterator(); it.hasNext(); x++) {
                currentDq = it.next();
                height = currentDq.size();
                for (y = 0; y < height; y++) {
                    currentDq.addLast(currentDq.removeFirst() + variation[y][x]);
                }
            }
            // 어항 다시 일렬로 놓기
            x = 0;
            y = 0;
            width = fishBowl.size();
            for (x = 0; x < width; x++) {
                currentDq = fishBowl.getFirst();
                height = currentDq.size();
                for (y = 0; y < height; y++) {
                    Deque<Integer> tmp = new ArrayDeque<>();
                    tmp.addFirst(currentDq.removeFirst());
                    fishBowl.addLast(tmp);
                }
                fishBowl.removeFirst();
            }
            // 두번째 공중부양
            width = fishBowl.size();
            int targetWidth = width / 2;
            List<Integer> arr = new ArrayList<>();
            x = 0;
            for (x = 0; x < targetWidth; x++) {
                arr.add(fishBowl.removeFirst().removeFirst());
            }
            x = 0;
            for (Iterator<Deque<Integer>> it = fishBowl.iterator(); it.hasNext(); x++) {
                it.next().addLast(arr.get(targetWidth - x - 1));
            }
            arr.clear();
            for (x = 0; x < targetWidth / 2; x++) {
                currentDq = fishBowl.removeFirst();
                arr.add(currentDq.removeFirst());
                arr.add(currentDq.removeFirst());
            }
            x = 0;
            for (Iterator<Deque<Integer>> it = fishBowl.iterator(); it.hasNext(); x++) {
                currentDq = it.next();
                currentDq.addLast(arr.get(targetWidth - (x * 2) - 1));
                currentDq.addLast(arr.get(targetWidth - (x * 2) - 2));
            }
            // 물고기 조절 작업
            width = fishBowl.size();
            height = fishBowl.getFirst().size();
            beforeArr = new int[height];
            variation = new int[height][width];
            beforeInt = 0;
            x = 0;
            y = 0;
            for (Iterator<Deque<Integer>> it = fishBowl.iterator(); it.hasNext(); x++) {
                currentDq = it.next();
                y = 0;
                for (Iterator<Integer> it2 = currentDq.iterator(); it2.hasNext(); y++) {
                    currentInt = it2.next();
                    if (y != 0) {
                        int diff = Math.abs(beforeInt - currentInt) / 5;
                        if (diff > 0) {
                            if (beforeInt > currentInt) {
                                variation[y - 1][x] -= diff;
                                variation[y][x] += diff;
                            } else {
                                variation[y - 1][x] += diff;
                                variation[y][x] -= diff;
                            }
                        }
                    }
                    if (x != 0) {
                        int diff = Math.abs(beforeArr[y] - currentInt) / 5;
                        if (diff > 0) {
                            if (beforeArr[y] > currentInt) {
                                variation[y][x - 1] -= diff;
                                variation[y][x] += diff;
                            } else {
                                variation[y][x - 1] += diff;
                                variation[y][x] -= diff;
                            }
                        }
                    }
                    beforeInt = currentInt;
                    beforeArr[y] = currentInt;
                }
            }
            x = 0;
            y = 0;
            for (Iterator<Deque<Integer>> it = fishBowl.iterator(); it.hasNext(); x++) {
                currentDq = it.next();
                height = currentDq.size();
                for (y = 0; y < height; y++) {
                    currentDq.addLast(currentDq.removeFirst() + variation[y][x]);
                }
            }
            // 바닥에 일렬로 놓기
            x = 0;
            y = 0;
            width = fishBowl.size();
            for (x = 0; x < width; x++) {
                currentDq = fishBowl.getFirst();
                height = currentDq.size();
                for (y = 0; y < height; y++) {
                    Deque<Integer> tmp = new ArrayDeque<>();
                    tmp.addFirst(currentDq.removeFirst());
                    fishBowl.addLast(tmp);
                }
                fishBowl.removeFirst();
            }
            // 종료조건확인
            int max = 0;
            int min = Integer.MAX_VALUE;
            for (Iterator<Deque<Integer>> it = fishBowl.iterator(); it.hasNext();) {
                int fish = it.next().getFirst();
                if (fish > max) {
                    max = fish;
                }
                if (fish < min) {
                    min = fish;
                }
            }
            if (max - min <= K) {
                break;
            }
        }
        System.out.println(k);
    }
}
