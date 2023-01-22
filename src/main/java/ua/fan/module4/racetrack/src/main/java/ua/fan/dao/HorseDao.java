package ua.fan.dao;

import ua.fan.entity.Horse;

public class HorseDao extends AbstractDao<Horse> {
    @Override
    protected void init() {
        aClass = Horse.class;
    }

    public int getTotalOfHorses(){
        return getAll().size();
    }
}
