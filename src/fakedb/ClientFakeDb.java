package fakedb;

import domain.Client;

public class ClientFakeDb extends BaseFakeDb<Client> {
    
    public ClientFakeDb(){
        super();
    }

    @Override
    protected void FillTable() {
       this.table.add(
            new Client(
                GeneretedId(), 
                "Chrigor G.", 
                "123.456.789.00", 
                "chrigorcontato@gmail.com", 
                "(67) 9.9226-1238")
        );
    }
}
