package com.horus.algorithms.searching;

public class BinarySearchTree<Key extends Comparable<Key>, Value> {
    private Node root;

    private class Node {
        private Key key;
        private Value value;
        private Node left, right;
        private int subtreeSize;

        public Node(Key key, Value value, int subtreeSize) {
            this.key = key;
            this.value = value;
            this.subtreeSize = subtreeSize;
        }
    }

    public void put(Key key, Value val) {
        root = put(root, key, val);
    }

    private Node put(Node node, Key key, Value val) {
        if (node == null) return new Node(key, val, 1);
        int cmp = key.compareTo(node.key);
        if (cmp > 0) node.right = put(node.right, key, val);
        else if (cmp < 0) node.left = put(node.left, key, val);
        else node.value = val;
        node.subtreeSize = size(node.left) + size(node.right) + 1;
        return node;
    }

    public Value get(Key key) {
        return get(root, key);
    }

    private Value get(Node node, Key key) {
        if (node == null) return null;
        int cmp = key.compareTo(node.key);
        if (cmp > 0) return get(node.right, key);
        else if (cmp < 0) return get(node.left, key);
        else return node.value;
    }

    public Key min() {
        return min(root).key;
    }

    private Node min(Node node) {
        return node.left == null ? node : min(node.left);
    }

    public Key max() {
        return max(root).key;
    }

    private Node max(Node node) {
        if (node.right == null) return node;
        else return max(node.right);
    }

    public Key floor(Key key) {
        Node result = floor(root, key);
        if (result != null) return result.key;
        else return null;
    }

    private Node floor(Node node, Key key) {
        if (node == null) return null;
        int cmp = key.compareTo(node.key);
        if (cmp == 0) return node;
        else if (cmp < 0) return floor(node.left, key);
        Node r = floor(node.right, key);
        return r != null ? r : node;
    }

    public Key ceiling(Key key) {
        Node r = ceiling(root, key);
        return r != null ? r.key : null;
    }

    private Node ceiling(Node node, Key key) {
        if (node == null) return null;
        int cmp = key.compareTo(node.key);
        if (cmp == 0) return node;
        else if (cmp > 0) return ceiling(node.right, key);
        Node r = ceiling(node.left, key);
        return r != null ? r : node;
    }

    public Key select(int k) {
        Node r = select(root, k);
        return r != null ? r.key : null;
    }

    private Node select(Node x, int k) {
        if (x == null) return null;
        int t = size(x.left);
        if (t > k) return select(x.left, k);
        else if (t < k) return select(x.right, k - t - 1);
        else return x;
    }

    public int rank(Key key) {
        return rank(key, root);
    }

    private int rank(Key key, Node x) {
        if (x == null) return 0;
        int cmp = key.compareTo(x.key);
        if (cmp < 0) return rank(key, x.left);
        else if (cmp > 0) return 1 + size(x.left) + rank(key, x.right);
        else return size(x.left);
    }

    public int size() {
        return size(root);
    }

    private int size(Node node) {
        if (node == null) return 0;
        else return node.subtreeSize;
    }

}
