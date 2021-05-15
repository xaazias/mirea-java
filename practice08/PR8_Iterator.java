package ru.mirea.java.practice08;

/*
    Признаки применения паттерна: Итератор легко определить по методам навигации
    (например, получения следующего/предыдущего элемента и т. д.).
    Код использующий итератор зачастую вообще не имеет ссылок на коллекцию,
    с которой работает итератор.
    Итератор либо принимает коллекцию в параметрах конструкторе при создании,
    либо возвращается самой коллекцией.
*/

class Notification {
    String notification;

    public Notification(String notification) {
        this.notification = notification;
    }

    public String getNotification() {
        return notification;
    }
}

interface Collection {
    Iterator createIterator();
}

class NotificationCollection implements Collection {
    static final int MAX_ITEMS = 6;
    int numberOfItems = 0;
    Notification[] notificationList;

    public NotificationCollection() {
        notificationList = new Notification[MAX_ITEMS];

        addItem("Уведомление #1");
        addItem("Уведомление #2");
        addItem("Уведомление #3");
    }

    public void addItem(String str) {
        Notification notification = new Notification(str);
        if (numberOfItems >= MAX_ITEMS)
            System.err.println("Full");
        else {
            notificationList[numberOfItems] = notification;
            numberOfItems = numberOfItems + 1;
        }
    }

    public Iterator createIterator() {
        return new NotificationIterator(notificationList);
    }
}

interface Iterator {
    boolean hasNext();

    Object next();
}

class NotificationIterator implements Iterator {
    Notification[] notificationList;

    int pos = 0;

    public NotificationIterator(Notification[] notificationList) {
        this.notificationList = notificationList;
    }

    public Object next() {
        Notification notification = notificationList[pos];
        pos += 1;
        return notification;
    }

    public boolean hasNext() {
        if (pos >= notificationList.length ||
                notificationList[pos] == null)
            return false;
        else
            return true;
    }
}

class NotificationBar {
    NotificationCollection notifications;

    public NotificationBar(NotificationCollection notifications) {
        this.notifications = notifications;
    }

    public void printNotifications() {
        Iterator iterator = notifications.createIterator();
        System.out.println("::: Уведомления :::");
        while (iterator.hasNext()) {
            Notification n = (Notification) iterator.next();
            System.out.println(n.getNotification());
        }
    }
}

class Main {
    public static void main(String args[]) {
        NotificationCollection nc = new NotificationCollection();
        NotificationBar nb = new NotificationBar(nc);
        nb.printNotifications();
    }
}