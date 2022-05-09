package solutions;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

// [Problem] https://leetcode.com/problems/design-browser-history

// List and current page index
class BrowserHistoryList {
    List<String> history;
    int currentPage;

    public BrowserHistoryList(String homepage) {
        super();
        this.history = new ArrayList<>();
        this.history.add(homepage);
        this.currentPage = 0;
    }

    // O(1) time, O(1) space
    public void visit(String url) {
        history.subList(currentPage + 1, history.size()).clear();
        history.add(url);
        currentPage++;
    }

    // O(1) time, O(1) space
    public String back(int steps) {
        currentPage = Math.max(currentPage - steps, 0);
        return history.get(currentPage);
    }

    // O(1) time, O(1) space
    public String forward(int steps) {
        currentPage = Math.min(currentPage + steps, history.size() - 1);
        return history.get(currentPage);
    }
}

// Two stacks
class BrowserHistoryStack {
    Stack<String> backwardHistory;
    Stack<String> forwardHistory;

    public BrowserHistoryStack(String homepage) {
        super();
        this.forwardHistory = new Stack<>();
        this.backwardHistory = new Stack<>();
        this.backwardHistory.add(homepage);
    }

    // O(1) time, O(1) space
    public void visit(String url) {
        backwardHistory.add(url);
        forwardHistory = new Stack<>();
    }

    // O(n) time, O(1) space
    public String back(int steps) {
        while (steps-- > 0 && backwardHistory.size() > 1) {
            forwardHistory.add(backwardHistory.pop());
        }
        return backwardHistory.peek();
    }

    // O(n) time, O(1) space
    public String forward(int steps) {
        while (steps-- > 0 && !forwardHistory.isEmpty()) {
            backwardHistory.add(forwardHistory.pop());
        }
        return backwardHistory.peek();
    }
}

// Doubly-Linked List
class BrowserHistoryDoublyLinkedList {
    class Page {
        String url;
        Page next;
        Page prev;

        public Page(String url) {
            this.url = url;
            next = null;
            prev = null;
        }
    }

    Page homepage;
    Page currentPage;

    public BrowserHistoryDoublyLinkedList(String homepage) {
        super();
        this.homepage = new Page(homepage);
        currentPage = this.homepage;
    }

    // O(1) time, O(1) space
    public void visit(String url) {
        Page newPage = new Page(url);
        currentPage.next = newPage;
        newPage.prev = currentPage;
        currentPage = newPage;
    }

    // O(n) time, O(1) space
    public String back(int steps) {
        while (steps-- > 0 && currentPage.prev != null) {
            currentPage = currentPage.prev;
        }
        return currentPage.url;
    }

    // O(n) time, O(1) space
    public String forward(int steps) {
        while (steps-- > 0 && currentPage.next != null) {
            currentPage = currentPage.next;
        }
        return currentPage.url;
    }
}