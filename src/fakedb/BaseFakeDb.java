package fakedb;

import java.util.ArrayList;

import shared.Utility;

public abstract class BaseFakeDb<TDomain> {
    
    protected ArrayList<TDomain> table;

    protected BaseFakeDb(){
        this.table = new ArrayList<TDomain>();
    }

    protected int GeneretedId(){
        return Utility.GetNextId(this.table);
    }

    protected abstract void FillTable();

    public ArrayList<TDomain> getTable(){
        return this.table;
    }
}