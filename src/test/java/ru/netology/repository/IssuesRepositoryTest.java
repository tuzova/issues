package ru.netology.repository;

import org.junit.jupiter.api.Test;
import ru.netology.domain.Issue;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

public class IssuesRepositoryTest {
    private IssuesRepository repository = new IssuesRepository();

    Issue first = new Issue(1, "hakanai", "David Saff", true);
    Issue second = new Issue(2, "quicksteve", "Benedikt Ritter", true);
    Issue third = new Issue(3, "staenker", "David Saff", false);
    Issue forth = new Issue(4, "hakanai", "Kevin Cooney", false);
    Issue fifth = new Issue(5, "eeverman", "Sam Brannen", true);

    @Test
    public void shouldGetIssue() {

        repository.add(first);

        List<Issue> expected = new ArrayList<>(List.of(first));
        List<Issue> actual = repository.getAll();
        assertEquals(expected, actual);
    }

    @Test
    public void shouldGetAllIssues() {

        repository.addAll(new ArrayList<>(List.of(first, second, third, forth, fifth)));

        List<Issue> expected = new ArrayList<>(List.of(first, second, third, forth, fifth));
        List<Issue> actual = repository.getAll();
        assertEquals(expected, actual);
    }

    @Test
    public void shouldRemoveIssue() {

        repository.addAll(new ArrayList<>(List.of(first, second, third, forth, fifth)));
        repository.remove(forth);

        List<Issue> expected = new ArrayList<>(List.of(first, second, third, fifth));
        List<Issue> actual = repository.getAll();
        assertEquals(expected, actual);
    }

    @Test
    public void shouldRemoveAll() {

        repository.addAll(new ArrayList<>(List.of(first, second, third, forth, fifth)));
        repository.removeAll(new ArrayList<>(List.of(first, second, third, forth, fifth)));

        List<Issue> expected = new ArrayList<>();
        List<Issue> actual = repository.getAll();
        assertEquals(expected, actual);
    }

    @Test
    public void shouldRemoveById() {

        repository.addAll(new ArrayList<>(List.of(first, second, third, forth, fifth)));
        repository.removeById(3);

        List<Issue> expected = new ArrayList<>(List.of(first, second, forth, fifth));
        List<Issue> actual = repository.getAll();
        assertEquals(expected, actual);
    }
}

