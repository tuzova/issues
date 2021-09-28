package ru.netology.manager;

import ru.netology.domain.Issue;
import ru.netology.domain.Label;
import ru.netology.repository.IssuesRepository;

import java.util.*;
import java.util.function.Predicate;

public class IssuesManager {
    private IssuesRepository repository;

    public IssuesManager(IssuesRepository repository) {
        this.repository = repository;
    }

    public IssuesRepository getRepository() {
        return repository;
    }

    public void setRepository(IssuesRepository repository) {
        this.repository = repository;
    }

    // issue хранятся в List
    public List<Issue> issues = new ArrayList<>();

    // labels хранятся в Set
    public Set<Label> labels = new HashSet<>();

    public void add(Issue issue) {
        repository.add(issue);
    }

    public void addAll(Collection<? extends Issue> issue) {
        repository.addAll(issue);
    }

    public List<Issue> getAll() {
        //repository.getAll(List<Issue> issues);
        return issues;
    }

    // Отображение списка открытых Issue
    public void getOpen(boolean open) {
        issues.removeIf(o -> o.isOpen() != open);
    }

    // Отображение списка закрытых Issue
    public void getClosed(boolean open) {
        issues.removeIf(o -> o.isOpen() == open);
    }

    // Фильтрация по имени автора
    public void filterByAuthor(String author) {
        issues.removeIf(a -> !a.getAuthor().equals(author));
    }

    // Фильтрация по assignee
    public void filterByAssignee(String assignee) {
        issues.removeIf(a -> !a.getAssignee().equals(assignee));
    }

    // Фильтрация по label
    public void filterByLabel(String label) {
        labels.removeIf(a -> !a.getLabel().equals(label));
    }

    // Сортировка по автору в алфавитном порядке
    public List<Issue> sortedByAuthor(Comparator<Issue> AuthorComparator) {
        List<Issue> result = new LinkedList<>(issues);
        result.sort(AuthorComparator);
        return result;
    }

    // Сортировка по id
    public List<Issue> sortedById(Comparator<Issue> IdComparator) {
        List<Issue> result = new LinkedList<>(issues);
        result.sort(IdComparator);
        return result;
    }
}