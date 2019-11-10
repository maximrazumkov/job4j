package ru.job4j.sort;

import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class Departure {
    private List<String> orgs;

    public Departure() {
    }

    public Departure(List<String> orgs) {
        this.orgs = orgs;
    }

    public List<String> getOrgs() {
        return orgs;
    }

    public void setOrgs(List<String> orgs) {
        this.orgs = orgs;
    }

    public void abs() {
        Collections.sort(this.orgs, (str1, str2) -> str1.compareTo(str2));
    }

    public void desc() {
        Collections.sort(this.orgs, (str1, str2) -> {
            int result = 0;
            int size = Math.min(str1.length(), str2.length());
            for (int i = 0; (i < size) && (result == 0); ++i) {
                char leftSimbol = str1.charAt(i);
                char rightSimbol = str2.charAt(i);
                result = Character.compare(rightSimbol, leftSimbol);
            }
            if (result == 0) {
                result = str1.compareTo(str2);
            }
            return result;
        });
    }

    public List<String> fillGaps(List<String> orgs) {
        this.orgs.addAll(0, orgs);
        return this.orgs;
    }

    @Override
    public String toString() {
        return "Departure{"
                + "orgs=" + orgs
                + '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Departure departure = (Departure) o;
        return Objects.equals(orgs, departure.orgs);
    }

    @Override
    public int hashCode() {
        return Objects.hash(orgs);
    }
}
