package org.hbrs.se.ws20.uebung8;

public class ReiseAnbieterAdapter {

    SuchErgebnis suche(SuchAuftrag s) {
        return new SuchErgebnis();
    }

    private QueryObject transformINPUT(SuchAuftrag s) {
        return new QueryObject();
    }

    private SuchErgebnis transformOUTPUT(QueryObject q) {
        return new SuchErgebnis();
    }

}
