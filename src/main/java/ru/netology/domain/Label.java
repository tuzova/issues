package ru.netology.domain;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Data;

import java.util.Objects;

@NoArgsConstructor
@AllArgsConstructor
@Data

public class Label extends Issue {
    private String label;

    public Label(int id, String author, String assignee, boolean open, String label) {
        super(id, author, assignee, open);
        this.label = label;
    }

    @Override
    public String toString() {
        return "Label{" +
                "label='" + label + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Label label1 = (Label) o;
        return Objects.equals(label, label1.label);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), label);
    }
}