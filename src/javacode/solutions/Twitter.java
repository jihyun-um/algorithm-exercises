package javacode.solutions;

import java.util.*;

// [Problem] https://leetcode.com/problems/design-twitter
class Twitter {
    Map<Integer, List<Tweet>> tweets;
    Map<Integer, Set<Integer>> following;
    int timestamp;

    // O(n) space
    public Twitter() {
        tweets = new HashMap<>();
        following = new HashMap<>();
        timestamp = 0;
    }

    // O(1) time
    public void postTweet(int userId, int tweetId) {
        following.putIfAbsent(userId, new HashSet<>());
        following.get(userId).add(userId);
        tweets.putIfAbsent(userId, new LinkedList<>());
        tweets.get(userId).add(new Tweet(tweetId, timestamp++));
    }

    // O(nlogn) time
    public List<Integer> getNewsFeed(int userId) {
        Queue<Tweet> newsFeed = new PriorityQueue<>((a, b) -> b.timestamp - a.timestamp);
        Set<Integer> followees = following.getOrDefault(userId, new HashSet<>());
        for (int followee : followees) {
            if (tweets.containsKey(followee)) {
                newsFeed.addAll(tweets.get(followee));
            }
        }
        List<Integer> newsFeedTweetIds = new ArrayList<>();
        while (!newsFeed.isEmpty() && newsFeedTweetIds.size() < 10) {
            newsFeedTweetIds.add(newsFeed.poll().id);
        }
        return newsFeedTweetIds;
    }

    // O(1) time
    public void follow(int followerId, int followeeId) {
        following.putIfAbsent(followerId, new HashSet<>());
        following.get(followerId).add(followeeId);
    }

    // O(1) time
    public void unfollow(int followerId, int followeeId) {
        following.get(followerId).remove(followeeId);
    }

    public static void main(String[] args) {
        Twitter twitter = new Twitter();
        twitter.postTweet(1, 5); // User 1 posts a new tweet (id = 5).
        System.out.println(twitter.getNewsFeed(1));  // User 1's news feed should return a list with 1 tweet id -> [5]. return [5]
        twitter.follow(1, 2);    // User 1 follows user 2.
        twitter.postTweet(2, 6); // User 2 posts a new tweet (id = 6).
        System.out.println(twitter.getNewsFeed(1));  // User 1's news feed should return a list with 2 tweet ids -> [6, 5]. Tweet id 6 should precede tweet id 5 because it is posted after tweet id 5.
        twitter.unfollow(1, 2);  // User 1 unfollows user 2.
        System.out.println(twitter.getNewsFeed(1));  // User 1's news feed should return a list with 1 tweet id -> [5], since user 1 is no longer following user 2.
    }
}

class Tweet {
    int id;
    int timestamp;

    public Tweet(int id, int timestamp) {
        this.id = id;
        this.timestamp = timestamp;
    }
}