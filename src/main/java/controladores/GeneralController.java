package controladores;

import Data.IRepository;
import java.util.ArrayList;
import modelos.BaseEntity;

public abstract class GeneralController<T extends BaseEntity> implements IGeneralController<T> {

    protected IRepository<T> db;

    public GeneralController(IRepository<T> db) {
        this.db = db;
    }

    @Override
    public ArrayList<T> get() {
        return db.all();
    }

    @Override
    public boolean post(T objeto) {
        return db.add(objeto);
    }

    @Override
    public boolean put(T objeto) {
        return db.update(objeto);
    }

    @Override
    public boolean remove(int id) {
        return db.remove(id);
    }

}
    