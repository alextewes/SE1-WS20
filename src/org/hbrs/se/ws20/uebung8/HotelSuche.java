package org.hbrs.se.ws20.uebung8;

import java.util.Vector;

public interface HotelSuche<E> {

    Vector<E> sucheHotel(SuchAuftrag s);
    Vector<E> bewerteHotel(String hotelName);


}
