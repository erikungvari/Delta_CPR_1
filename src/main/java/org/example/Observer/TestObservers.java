package org.example.Observer;

public class TestObservers {
    public static void main(String[] a){
        MyTopic myTopic = new MyTopic();

        Observer myTopicSubscriber1 = new MyTopicSubscriber("Obs1");
        Observer myTopicSubscriber2 = new MyTopicSubscriber("Obs2");
        Observer myTopicSubscriber3 = new MyTopicSubscriber("Obs3");

        myTopic.register(myTopicSubscriber1);
        myTopic.register(myTopicSubscriber2);
        myTopic.register(myTopicSubscriber3);

        myTopic.postMessage("Baha");
    }
}
