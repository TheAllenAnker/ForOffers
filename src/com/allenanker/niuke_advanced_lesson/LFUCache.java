package com.allenanker.niuke_advanced_lesson;

import java.util.HashMap;

/**
 * Implement the Least Frequent Used caching data structure
 */
public class LFUCache {
    private NodeList headList;
    private int capacity;
    private int size;
    /**
     * nodeMap maps key to corresponding node
     */
    private HashMap<Integer, Node> nodeMap;
    /**
     * maps node to its NodeList
     */
    private HashMap<Node, NodeList> nodeListMap;

    public LFUCache(int capacity) {
        this.capacity = capacity;
        nodeMap = new HashMap<>();
        nodeListMap = new HashMap<>();
    }

    public void put(int key, int value) {
        if (nodeMap.containsKey(key)) {
            Node node = nodeMap.get(key);
            node.value = value;
            node.times++;
            move(node, nodeListMap.get(node));
        } else {
            if (size == capacity) {
                removeLFU();
            }
            Node newNode = new Node(key, value);
            if (headList == null) {
                headList = new NodeList(newNode);
                nodeListMap.put(newNode, headList);
            } else {
                if (headList.head.times != newNode.times) {
                    NodeList newList = new NodeList(newNode);
                    newList.next = headList;
                    headList.prev = newList;
                    headList = newList;
                    nodeListMap.put(newNode, newList);
                } else {
                    add(newNode, headList);
                    nodeListMap.put(newNode, headList);
                }
            }
            nodeMap.put(key, newNode);
            size++;
        }
    }

    public int get(int key) {
        if (!nodeMap.containsKey(key)) {
            return -1;
        }

        Node resultNode = nodeMap.get(key);
        resultNode.times++;
        move(resultNode, nodeListMap.get(resultNode));

        return resultNode.value;
    }

    private void removeLFU() {
        Node removeTarget = headList.tail;
        headList.tail = removeTarget.up;
        deleteFromNodeList(removeTarget);
        checkNodeList(headList);
        nodeListMap.remove(removeTarget);
        nodeMap.remove(removeTarget.key);
        size--;
    }

    /**
     * Method for moving a node from a NodeList to another NodeList
     *
     * @param node
     */
    private void deleteFromNodeList(Node node) {
        if (nodeListMap.containsKey(node)) {
            NodeList nodeList = nodeListMap.get(node);
            if (nodeList.head == node) {
                nodeList.head = node.down;
                if (node.down != null) {
                    node.down.up = null;
                }
            } else {
                node.up.down = node.down;
                if (node.down != null) {
                    node.down.up = node.up;
                }
            }
        }
    }

    /**
     * Add the given node in the head of the given NodeList
     *
     * @param node
     * @param nodeList
     */
    private void add(Node node, NodeList nodeList) {
        node.down = nodeList.head;
        nodeList.head.up = node;
        nodeList.head = node;
    }

    /**
     * Moves node from current NodeList to next NodeList
     *
     * @param node
     * @param oldNodeList
     */
    private void move(Node node, NodeList oldNodeList) {
        deleteFromNodeList(node);
        if (node == oldNodeList.tail) {
            oldNodeList.tail = node.up;
        }
        if (oldNodeList.next == null) {
            NodeList newList = new NodeList(node);
            oldNodeList.next = newList;
            newList.prev = oldNodeList;
            nodeListMap.put(node, newList);
        } else {
            if (oldNodeList.next.head.times != node.times) {
                NodeList newList = new NodeList(node);
                newList.next = oldNodeList.next;
                oldNodeList.next.prev = newList;
                oldNodeList.next = newList;
                newList.prev = oldNodeList;
                nodeListMap.put(node, newList);
            } else {
                add(node, oldNodeList.next);
                nodeListMap.put(node, oldNodeList.next);
            }
        }

        checkNodeList(oldNodeList);
    }

    /**
     * Check if the given NodeList should be deleted from the linked list
     *
     * @param checkList
     * @return
     */
    private boolean checkNodeList(NodeList checkList) {
        if (checkList.isEmpty()) {
            if (checkList == headList) {
                headList = headList.next;
            } else {
                checkList.prev.next = checkList.next;
                checkList.next.prev = checkList.prev;
            }

            return true;
        }

        return false;
    }

    private class Node {
        int key;
        int value;
        int times;
        Node up;
        Node down;

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
            times = 1;
        }
    }

    private class NodeList {
        Node head;
        Node tail;
        NodeList prev;
        NodeList next;

        public NodeList(Node head) {
            this.head = head;
            this.tail = head;
        }

        public boolean isEmpty() {
            return head == null;
        }
    }

    public static void main(String[] args) {
        LFUCache lfuCache = new LFUCache(3);
        lfuCache.put(1, 1);
        lfuCache.put(2, 2);
        lfuCache.put(3, 3);
        lfuCache.get(1);
        lfuCache.put(4, 4); // 2 should be moved out
        lfuCache.put(5, 5); // 3 should be moved out
        lfuCache.put(6, 6); // 1 should be moved out
    }
}
