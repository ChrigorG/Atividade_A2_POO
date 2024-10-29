package service;

import java.util.ArrayList;

import domain.Client;

public abstract class BaseService<TDomain> {
    
    protected abstract TDomain Create(Client client);

    protected abstract TDomain Read(int id);

    protected abstract ArrayList<TDomain> Read();

    protected abstract TDomain Update(Client client);

    protected abstract TDomain Delete(int id);
}
