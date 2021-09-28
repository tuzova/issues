package ru.netology.util;

import ru.netology.domain.Issue;

import java.util.Comparator;

public class AuthorComparator implements Comparator<Issue> {

    @Override
    public int compare(Issue o1, Issue o2) {
        if (o1 == o2) {
            return 0;
        }
        if (o1 == null) {
            return -1;
        }
        if (o2 == null) {
            return 1;
        }
        return o1.compareTo(o2);
    }
}

