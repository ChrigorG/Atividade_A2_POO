package service;

import java.util.ArrayList;

import domain.Client;
import repository.ClientRepository;

public class ClientService extends BaseService<Client> {

    private ClientRepository rp;

    public ClientService(){
        this.rp = new ClientRepository();
    }

    @Override
    public Client Create(Client client) {

        client = ValidatedClient(client);

        if(!client.getStatus())
            return client;
        
        return this.rp.Create(client);
    }

    @Override
    public Client Read(int id) {
        return this.rp.Read(id);
    }

    @Override
    public ArrayList<Client> Read() {
        return this.rp.Read();
    }

    @Override
    protected Client Update(Client client) {
        client = ValidatedClient(client);

        if(!client.getStatus())
            return client;

        return this.rp.Update(client);
    }

    @Override
    public Client Delete(int id) {
        return this.rp.Delete(id);
    }

    private Client ValidatedClient(Client client){

        if(client.getName() == null || client.getName().trim() == ""){
            client.setStatus(false);
            client.setMessage("O NOME do cliente não pode ser nulo ou vázio!");
            return client;
        }

        if(client.getEmail() == null || client.getEmail().trim() == ""){
            client.setStatus(false);
            client.setMessage("O EMAIL do cliente não pode ser nulo ou vázio!");
            return client;
        }

        if(client.getCPF() == null || client.getCPF().trim() == ""){
            client.setStatus(false);
            client.setMessage("O CPF do cliente não pode ser nulo ou vázio!");
            return client;
        }

        if(client.getPhone() == null || client.getPhone().trim() == ""){
            client.setStatus(false);
            client.setMessage("O TELEFONE do cliente não pode ser nulo ou vázio!");
            return client;
        }

        return client;
    }
}
