package repository;

import java.util.ArrayList;

public abstract class BaseRepository<TDomain> {
    
    protected ArrayList<TDomain> datas;

    protected abstract TDomain Create(TDomain tDomain);

    protected abstract TDomain Read(int id);

    protected ArrayList<TDomain> Read(){
        return datas;
    }

    protected abstract TDomain Update(TDomain tDomain);

    protected abstract TDomain Delete(int id);
}
