package ua.fan.repository.hibernate;

import ua.fan.entity.Goods;
import ua.fan.repository.GoodsRepository;

public class GoodsRepositoryImpl extends AbstractHibernateRepository<Goods> implements GoodsRepository {
    protected void init() {
        aClass = Goods.class;
    }
}
