package ru.netology.repository;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Issue;

import java.util.ArrayList;
import java.util.List;

public class CRUDRepositoryTest {
    private IssuesRepository repository = new IssuesRepository();

    Issue first = new Issue(1, "hakanai", "David Saff", true);
    Issue second = new Issue(2, "quicksteve", "Benedikt Ritter", true);
    Issue third = new Issue(3, "staenker", "David Saff", false);
    Issue forth = new Issue(4, "hakanai", "Kevin Cooney", false);
    Issue fifth = new Issue(5, "eeverman", "Sam Brannen", true);

    List<Issue> issues = new ArrayList<>();

    @Nested
    public class Empty {
        List<Issue> issues = new ArrayList<>();

        @Test
        public void shouldGetAll() {
            repository.getAll();
        }

        @Test
        public void shouldRemoveIssue() {
            repository.remove(new Issue());
        }

        @Test
        public void shouldRemoveAll() {
            repository.removeAll(List.of(new Issue(), new Issue()));
        }
    }

    @Nested
    public class SingleItem {

        @Test
        public void shouldGetAll() {
            repository.getAll();
        }

        @Test
        public void shouldRemoveIssue() {
            repository.remove(new Issue());
        }

        @Test
        public void shouldRemoveAll() {
            repository.removeAll(List.of(new Issue(), new Issue()));
        }
    }


    @Nested
    public class MultipleItems {
        List<Issue> issues = new ArrayList<>(List.of(first, second, third, forth, fifth));

        @Test
        public void shouldGetAll() {
            repository.getAll();
        }

        @Test
        public void shouldRemoveIssue() {
            repository.remove(new Issue());
        }

        @Test
        public void shouldRemoveAll() {
            repository.removeAll(List.of(new Issue(), new Issue()));
        }
    }
}