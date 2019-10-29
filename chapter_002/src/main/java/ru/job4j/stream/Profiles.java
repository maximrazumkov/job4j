package ru.job4j.stream;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Profiles {
    List<Address> collect(List<Profile> profiles) {
        return profiles.stream().map(profile -> profile.getAddress()).collect(Collectors.toList());
    }
    List<Address> distinct(List<Profile> profiles) {
        List<Address> addresses = profiles.stream().map(profile -> profile.getAddress()).collect(Collectors.toList());
        addresses = addresses.stream().distinct().collect(Collectors.toList());
        addresses.sort((addr1, addr2) -> addr1.getCity().compareTo(addr2.getCity()));
        return addresses;
    }
}
