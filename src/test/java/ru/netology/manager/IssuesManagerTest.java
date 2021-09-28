package ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.netology.domain.Issue;
import ru.netology.domain.Label;
import ru.netology.repository.IssuesRepository;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class IssuesManagerTest {

    @Mock
    private IssuesRepository repository;
    @InjectMocks
    private IssuesManager manager;
    Issue first = new Issue(1, "hakanai", "David Saff", true);
    Issue second = new Issue(2, "quicksteve", "Benedikt Ritter", true);
    Issue third = new Issue(3, "staenker", "David Saff", false);
    Issue forth = new Issue(4, "hakanai", "Kevin Cooney", false);
    Issue fifth = new Issue(5, "eeverman", "Sam Brannen", true);

    @BeforeEach
    public void setUp() {
        manager.add(first);
        manager.add(second);
        manager.add(third);
        manager.add(forth);
        manager.add(fifth);
    }

    @Test
    public void shouldGetOpen() {

        List<Issue> returned = new ArrayList<>(List.of(first, second, third, forth, fifth));
        doReturn(returned).when(repository).getAll();

        manager.getOpen(true);

        List<Issue> expected = new ArrayList<>(List.of(first, second, fifth));
        List<Issue> actual = manager.getAll();
        assertEquals(expected, actual);

        verify(repository).getAll();
    }

    @Test
    public void shouldGetClosed() {

        List<Issue> returned = new ArrayList<>(List.of(first, second, third, forth, fifth));
        doReturn(returned).when(repository).getAll();

        manager.getClosed(true);

        List<Issue> expected = new ArrayList<>(List.of(third, forth));
        List<Issue> actual = manager.getAll();
        assertEquals(expected, actual);

        verify(repository).getAll();
    }

    @Test
    public void shouldFilterByAuthor() {

        List<Issue> returned = new ArrayList<>(List.of(first, second, third, forth, fifth));
        doReturn(returned).when(repository).getAll();

        manager.filterByAuthor("hakanai");

        List<Issue> expected = new ArrayList<>(List.of(first, forth));
        List<Issue> actual = manager.getAll();
        assertEquals(expected, actual);

        verify(repository).getAll();
    }

    @Test
    public void shouldFilterByAssignee() {

        List<Issue> returned = new ArrayList<>(List.of(first, second, third, forth, fifth));
        doReturn(returned).when(repository).getAll();

        manager.filterByAssignee("David Saff");

        List<Issue> expected = new ArrayList<>(List.of(first, third));
        List<Issue> actual = manager.getAll();
        assertEquals(expected, actual);

        verify(repository).getAll();
    }
}
