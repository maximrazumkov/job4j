package ru.job4j.tracker;

public class Doctor extends Profession {

    public void examination(Pacient pacient) {

    }

    public Diagnose heal(Pacient pacient) {
        return new Diagnose();
    }

    public void treatment(Pacient pacient) {

    }

}
