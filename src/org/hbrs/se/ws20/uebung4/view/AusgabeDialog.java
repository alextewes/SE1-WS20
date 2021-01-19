package org.hbrs.se.ws20.uebung4.view;

import org.hbrs.se.ws20.uebung4.model.entity.UserStory;
import org.hbrs.se.ws20.uebung4.model.Container;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class AusgabeDialog {

    public void startAusgabe(Container container, int aufwand) {

        List<UserStory> list = container.getCurrentList();
        list.sort(Comparator.comparingDouble(UserStory::getPrio));
        Collections.reverse(list);

        List<String> newList = list.stream()
                .filter( userStory -> userStory.getAufwand() > aufwand )
                .map(UserStory::toString)
                .collect(Collectors.toList());

        newList.forEach(System.out::println);

    }

    public void startAusgabe(Container container) {
        startAusgabe(container, 0);
    }

}
