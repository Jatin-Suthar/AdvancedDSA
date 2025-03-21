package Caching;

import java.util.HashMap;
import java.util.Map;

public class LRUCacheExample {

    public static void main(String[] args) {
        LRUCache<Integer, String> lruCache = new LRUCache<>(3);
        lruCache.put(1, "A");
        lruCache.put(2, "B");
        lruCache.put(3, "C");
        lruCache.printList();

        lruCache.get(2);
        lruCache.printList();

        lruCache.put(4, "D");
        lruCache.printList();
    }

}

class LRUCache<K, V> {

    private final int capacity;
    private final Map<K, Node<K, V>> cache;
    private final DoublyLinkedList<K, V> list;

    LRUCache(int capacity) {
        this.capacity = capacity;
        this.cache = new HashMap<>();
        this.list = new DoublyLinkedList<>();
    }

    public V get(K key) {
        if(!cache.containsKey(key)) return null;
        Node<K, V> node = cache.get(key);
        list.moveToFront(node);
        return node.val;
    }

    public void put(K key, V val) {
        if(cache.containsKey(key)) {
            Node<K, V> node = cache.get(key);
            node.val = val;
            list.moveToFront(node);
        } else {
            if(cache.size() == capacity) {
                K removedKey = list.removeLast();
                cache.remove(removedKey);
            }
            Node<K, V> newNode = new Node<>(key, val);
            list.addToFront(newNode);
            cache.put(key, newNode);
        }
    }

    public void printList() {
        list.printList();
    }

    static class Node<K, V> {
        K key; V val;
        Node<K, V> next, prev;
        Node (K key, V val) {
            this.key = key;
            this.val = val;
            next = null;
            prev = null;
        }
    }

    static class DoublyLinkedList<K, V> {
        private Node<K, V> head, tail;
        DoublyLinkedList() {
            head = new Node<>(null, null);
            tail = new Node<>(null, null);
            head.next = tail;
            tail.prev = head;
        }
        void addToFront(Node<K, V> node) {
            node.next = head.next;
            node.prev = head;
            head.next.prev = node;
            head.next = node;
        }
        void moveToFront(Node<K, V> node) {
            remove(node);
            addToFront(node);
        }
        void remove(Node<K, V> node) {
            node.next.prev = node.prev;
            node.prev.next = node.next;
        }
        K removeLast() {
            if(tail.prev == head)
                return null;
            Node<K, V> last = tail.prev;
            remove(last);
            return last.key;
        }
        void printList() {
            Node<K, V> curr = head.next;
            while(curr!=tail) {
                System.out.println("Key: " + curr.key + " | Value: " + curr.val);
                curr = curr.next;
            }
        }
    }

}

