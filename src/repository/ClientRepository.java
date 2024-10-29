package repository;

import java.util.ArrayList;
import domain.Client;
import fakedb.ClientFakeDb;
import shared.Utility;

public class ClientRepository extends BaseRepository<Client> {

    private ClientFakeDb db;

    public ClientRepository(){
        this.db = new ClientFakeDb();
        this.datas = this.db.getTable();
    }

    @Override
    public Client Create(Client client) {

        client.setId(Utility.GetNextId(this.datas));
        
        this.datas.add(client);

        return client;
    }

    @Override
    public Client Read(int id) {
        return this.datas.get(id);
    }

    @Override
    public ArrayList<Client> Read() {
        return this.datas;
    }

    @Override
    public Client Update(Client client) {
        Client assClient =  this.Read(client.getId());

        if(assClient == null){
            return null;
        }

        assClient.setName(client.getName());
        assClient.setEmail(client.getEmail());
        assClient.setCPF(client.getCPF());
        assClient.setPhone(client.getPhone());

        return assClient;
    }

    @Override
    public Client Delete(int id) {
       Client assClient = this.Read(id);

       if(assClient == null){
            return null;
       }

       this.datas.remove(assClient);
       return assClient;
    }
}
