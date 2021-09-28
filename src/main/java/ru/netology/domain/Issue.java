package ru.netology.domain;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Data;

import java.util.Comparator;

@NoArgsConstructor
@AllArgsConstructor
@Data

public class Issue implements Comparator<Issue> {
    private int id;
    private String author;
    private String assignee;

    public boolean isOpen() {
        return open;
    }

    public void setOpen(boolean open) {
        this.open = open;
    }

    private boolean open;

    @Override
    public String toString() {
        return "Issue{" +
                "id=" + id +
                ", author='" + author + '\'' +
                ", assignee='" + assignee + '\'' +
                ", open=" + open +
                '}';
    }      

    @Override
    public int compare(Issue o1, Issue o2) {
        return 0;
    }

    public int compareTo(Issue o) { // как сформулировать для String author в классе AuthorComparator ?
        return id - o.id;
    }
}

