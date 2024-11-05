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
        // Aqui estou fazendo de acordo com os elementos da lista
        // Se o usuario digitar 1 significa que ele quer o primerio elemento 
        // No caso o elemento "0" e assim por diante
        int index = id - 1;

        // Se o index for menor ou maior do que o suportado pela lista, retorna nulo
        if (index < 0 || index >= this.datas.size()) {
            return null;
        }
        return this.datas.get(index);
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
