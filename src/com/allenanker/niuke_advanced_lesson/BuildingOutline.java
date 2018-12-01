package com.allenanker.niuke_advanced_lesson;

import java.util.*;

public class BuildingOutline {
    private class Node {
        int pos;
        int height;
        boolean isUp;

        public Node(int pos, int height, boolean isUp) {
            this.pos = pos;
            this.height = height;
            this.isUp = isUp;
        }
    }

    private class BuildingPosComparator implements Comparator<Node> {

        @Override
        public int compare(Node o1, Node o2) {
            return o1.pos - o2.pos;
        }
    }

    public List<int[]> getOutline(int[][] buildings) {
        if (buildings == null || buildings.length == 0) {
            return null;
        }

        Node[] buildingNodes = new Node[buildings.length * 2];
        for (int i = 0; i < buildings.length; i++) {
            buildingNodes[2 * i] = new Node(buildings[i][0], buildings[i][2], true);
            buildingNodes[2 * i + 1] = new Node(buildings[i][1], buildings[i][2], false);
        }
        Arrays.sort(buildingNodes, new BuildingPosComparator());

        // hcMap stores each height's frequency, pmMap stores the max height in each position
        TreeMap<Integer, Integer> hcMap = new TreeMap<>();
        TreeMap<Integer, Integer> pmMap = new TreeMap<>();
        for (int i = 0; i < buildingNodes.length; i++) {
            Node curr = buildingNodes[i];
            if (curr.isUp) {
                if (!hcMap.containsKey(curr.height)) {
                    hcMap.put(curr.height, 1);
                } else {
                    hcMap.put(curr.height, hcMap.get(curr.height) + 1);
                }
            } else {
                if (hcMap.containsKey(curr.height)) {
                    if (hcMap.get(curr.height) == 1) {
                        hcMap.remove(curr.height);
                    } else {
                        hcMap.put(curr.height, hcMap.get(curr.height) - 1);
                    }
                }
            }

            if (hcMap.isEmpty()) {
                pmMap.put(curr.pos, 0);
            } else {
                pmMap.put(curr.pos, hcMap.lastKey());
            }
        }

        List<int[]> res = new ArrayList<>();
        // each outline's start and height, the end will be known when the max height changes
        int start = 0;
        int height = 0;
        for (Map.Entry<Integer, Integer> entry : pmMap.entrySet()) {
            int currPos = entry.getKey();
            int currMaxHeight = entry.getValue();
            if (height != currMaxHeight) {
                if (height != 0) {
                    int[] newRecord = new int[3];
                    newRecord[0] = start;
                    newRecord[1] = currPos;
                    newRecord[2] = height;
                    res.add(newRecord);
                }
                start = currPos;
                height = currMaxHeight;
            }
        }

        return res;
    }

    public static void main(String[] args) {
        int[][] buildings = {
                {1, 3, 4},
                {2, 6, 2}
        };
        List<int[]> res = new BuildingOutline().getOutline(buildings);
        for (int i = 0; i < res.size(); i++) {
            System.out.println(Arrays.toString(res.get(i)));
        }
    }
}