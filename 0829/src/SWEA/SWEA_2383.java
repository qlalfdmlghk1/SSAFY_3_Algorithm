package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class SWEA_2383 {
	static int N, T, minTime;
    static Queue<Person>[] queues;
    static ArrayList<Person> people;
    static boolean[] visited;
    static Stair[] stairs;

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {
            N = Integer.parseInt(br.readLine());

            people = new ArrayList<>();
            queues = new LinkedList[2];
            queues[0] = new LinkedList<>();
            queues[1] = new LinkedList<>();
            stairs = new Stair[2];
            minTime = Integer.MAX_VALUE;

            int stairIndex = 0;

            for (int r = 1; r <= N; r++) {
                st = new StringTokenizer(br.readLine());
                for (int c = 1; c <= N; c++) {
                    int cellValue = Integer.parseInt(st.nextToken());

                    if (cellValue == 0) continue;
                    if (cellValue == 1) {
                        people.add(new Person(r, c));
                    } else {
                        stairs[stairIndex++] = new Stair(r, c, cellValue);
                    }
                }
            }
            assignStairs(0);
            System.out.println("#" + t + " " + minTime);
        }
    }

    private static void assignStairs(int index) {
        if (index == people.size()) {
            visited = new boolean[people.size()];
            int currentTime = simulate();
            minTime = Math.min(minTime, currentTime);
            return;
        }

        // Assign to first stair
        people.get(index).stairIndex = 0;
        people.get(index).calculateArrivalTime();
        assignStairs(index + 1);

        // Assign to second stair
        people.get(index).stairIndex = 1;
        people.get(index).calculateArrivalTime();
        assignStairs(index + 1);
    }

    static class Stair {
        int row, col, height;

        Stair(int row, int col, int height) {
            this.row = row;
            this.col = col;
            this.height = height;
        }
    }

    static class Person {
        int row, col;
        int stairIndex;
        int arrivalTime;
        int stairEntryTime;

        Person(int row, int col) {
            this.row = row;
            this.col = col;
        }

        private void calculateArrivalTime() {
            this.arrivalTime = Math.abs(row - stairs[stairIndex].row) + Math.abs(col - stairs[stairIndex].col);
        }
    }

    private static int simulate() {
        int exitedCount = 0;
        int time = 1;

        while (true) {
            // Move people down the stairs
            for (Queue<Person> queue : queues) {
                int size = queue.size();

                for (int i = 0; i < size; i++) {
                    Person p = queue.poll();
                    Stair s = stairs[p.stairIndex];

                    if (p.stairEntryTime + s.height > time) {
                        queue.offer(p);
                    }
                }
            }

            if (exitedCount == people.size() && queues[0].isEmpty() && queues[1].isEmpty()) {
                return time;
            }

            // Add people to the queue
            for (int i = 0; i < people.size(); i++) {
                if (visited[i]) continue;

                Person p = people.get(i);
                Queue<Person> queue = queues[p.stairIndex];

                if (p.arrivalTime + 1 <= time && queue.size() < 3) {
                    p.stairEntryTime = time;
                    visited[i] = true;
                    queue.offer(p);
                    exitedCount++;
                }
            }
            time++;
        }
    }
}
