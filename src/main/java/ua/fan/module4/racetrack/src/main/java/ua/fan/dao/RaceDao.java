package ua.fan.dao;

import ua.fan.config.HibernateFactoryUtil;
import ua.fan.entity.Race;

import javax.persistence.EntityManager;
import java.util.List;

public class RaceDao extends AbstractDao<Race> {
    protected final static EntityManager ENTITY_MANAGER = HibernateFactoryUtil.getEntityManager();
    private static RaceDao instance;

    public synchronized static RaceDao getInstance() {
        if (instance == null) {
            instance = new RaceDao();
        }
        return instance;
    }

    @Override
    protected void init() {
        aClass = Race.class;
    }

    public int getCountOfRaces() {
        return getAll().size();
    }

    public List<Object[]> getBetHorsePlaces() {
        return (List<Object[]>) ENTITY_MANAGER.createNativeQuery(
                "SELECT race_id, place FROM horse \n" +
                        "INNER JOIN race ON race.id = horse.race_id \n" +
                        "WHERE horse.id = race.betHorseNumber;");
    }

    public Number getBetHorsePlace(int race_id) {
        return (Number) ENTITY_MANAGER.createNativeQuery(
                "SELECT place FROM horse \n" +
                        "INNER JOIN race ON race.id = horse.race_id \n" +
                        "WHERE horse.id = race.betHorseNumber " +
                        "AND WHERE race.id = ?;")
                .setParameter(1, race_id);
    }

}
