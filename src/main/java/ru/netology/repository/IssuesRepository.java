package ru.netology.repository;

import ru.netology.domain.Issue;

import java.util.*;
import java.util.function.Predicate;

public class IssuesRepository {

    // Внутри репозитория все issue в виде List
    public List<Issue> issues = new ArrayList<>();

    // Добавление элемента в лист
    public void add(Issue issue) {
        issues.add(issue);
    }

    // Добавить множество элементов в лист
    public void addAll(Collection<? extends Issue> issue) {
        this.issues.addAll(issue);
    }

    // Получить все элементы из листа
    public List<Issue> getAll() {
        return issues;
    }

    // Удаление элемента из листа
    public void remove(Issue issue) {
        issues.remove(issue);
    }

    // Удаление всех элементов
    public void removeAll(Collection<? extends Issue> issue) {
        this.issues.removeAll(issue);
    }

    // Удаление элементов по id
    public void removeById(int id) {
        issues.removeIf(o -> o.getId() == id);
    }
}
















