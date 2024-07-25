package MinHeap_MaxHeap;

import java.util.*;

public class DesignTwitter {

    public static void main(String[] args) {
        /*
        ["Twitter", "postTweet", "getNewsFeed", "follow", "postTweet", "getNewsFeed", "unfollow", "getNewsFeed"]
        [[], [1, 5], [1], [1, 2], [2, 6], [1], [1, 2], [1]]
         */

        Twitter twitter = new Twitter();
        twitter.postTweet(1, 5);
        twitter.postTweet(1, 6);
        System.out.println(twitter.getNewsFeed(1));
        twitter.follow(1, 2);
        twitter.postTweet(2, 7);
        twitter.follow(1, 3);
        twitter.postTweet(3, 8);
        twitter.postTweet(3, 9);
        System.out.println(twitter.getNewsFeed(1));
        twitter.unfollow(1, 2);
        System.out.println(twitter.getNewsFeed(1));
    }

}

class Twitter {

    Map<Integer, Set<Integer>> userFollowingMap;
    Map<Integer, List<TweetTime>> tweetTimeMap;
    int MAX_THRESHOLD = 10;
    int time = 0;

    public Twitter() {
        userFollowingMap = new HashMap<>();
        tweetTimeMap = new HashMap<>();
    }

    public void postTweet(int userId, int tweetId) {
        List<TweetTime> tweetTimes = tweetTimeMap.getOrDefault(userId, new ArrayList<>());
        tweetTimes.add(new TweetTime(tweetId, time));
        time += 1;
        tweetTimeMap.put(userId, tweetTimes);
    }

    public List<Integer> getNewsFeed(int userId) {
        Set<Integer> followings = userFollowingMap.getOrDefault(userId, new HashSet<>());
        followings.add(userId);
        Queue<TweetInfo> pq = new PriorityQueue<>(Comparator.comparing((TweetInfo tweetTime) -> tweetTime.time).reversed());
        for(int followeeId: followings) {
            if(tweetTimeMap.get(followeeId)!=null) {
                List<TweetTime> tweetTimes = tweetTimeMap.get(followeeId);
                int idx = tweetTimes.size() - 1;
                TweetTime tweetTime = tweetTimes.get(idx);
                pq.add(new TweetInfo(tweetTime.tweetId, tweetTime.time, idx - 1, followeeId));
            }
        }
        List<Integer> tweetFeed = new ArrayList<>();
        while(!pq.isEmpty() && tweetFeed.size() < MAX_THRESHOLD) {
            TweetInfo tweetInfo = pq.poll();
            tweetFeed.add(tweetInfo.tweetId);
            int idx = tweetInfo.idx;
            if(idx>=0) {
                int followeeId = tweetInfo.followee;
                TweetTime nextTweetTime = tweetTimeMap.get(followeeId).get(idx);
                pq.add(new TweetInfo(nextTweetTime.tweetId, nextTweetTime.time, idx - 1, followeeId));
            }
        }
        return tweetFeed;
    }

    public void follow(int followerId, int followeeId) {
        Set<Integer> followingSet = userFollowingMap.getOrDefault(followerId, new HashSet<>());
        followingSet.add(followeeId);
        userFollowingMap.put(followerId, followingSet);
    }

    public void unfollow(int followerId, int followeeId) {
        Set<Integer> followingSet = userFollowingMap.getOrDefault(followerId, new HashSet<>());
        followingSet.remove(followeeId);
        userFollowingMap.put(followerId, followingSet);
    }
}

class TweetTime {
    int tweetId;
    int time;
    public TweetTime(int tweetId, int time) {
        this.tweetId = tweetId;
        this.time = time;
    }
}

class TweetInfo {
    int tweetId;
    int time;
    int idx;
    int followee;
    public TweetInfo(int tweetId, int time, int idx, int followee) {
        this.tweetId = tweetId;
        this.time = time;
        this.idx = idx;
        this.followee = followee;
    }
}

/**
 * Your Twitter object will be instantiated and called as such:
 * Twitter obj = new Twitter();
 * obj.postTweet(userId,tweetId);
 * List<Integer> param_2 = obj.getNewsFeed(userId);
 * obj.follow(followerId,followeeId);
 * obj.unfollow(followerId,followeeId);
 */