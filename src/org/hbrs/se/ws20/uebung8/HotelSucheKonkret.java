package org.hbrs.se.ws20.uebung8;

import java.util.Vector;

public class HotelSucheKonkret implements HotelSuche<Hotel> {

    private String land = null;
    private String ort = null;
    private String Datum = null;
    private Integer Sterne = null;

    @Override
    public Vector<Hotel> sucheHotel(SuchAuftrag s) {
        return null;
    }

    @Override
    public Vector<Hotel> bewerteHotel(String hotelName) {
        return null;
    }
}
