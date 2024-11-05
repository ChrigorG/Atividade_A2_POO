package view;

import java.util.ArrayList;
import java.util.Scanner;
import domain.Client;
import service.ClientService;
import shared.Utility;

public class Menu {
    
    private ClientService clientService;
    private int idAssistant = 0;
    private Scanner scanner; 

    public Menu(){
        this.clientService = new ClientService();
        this.scanner = new Scanner(System.in);
    }

    public void MenuOfOptions(){
        int value = -1;

        while (value != 0) {
            try{
                Utility.ClearConsole();
                System.out.println("------------ Sistema de Clientes ------------\n");
                System.out.println("Menu: \n"
                    + "1 - Buscar um cliente especifico \n"
                    + "2 - Buscar todos os clientes \n"
                    + "3 - Cadastrar um cliente \n"
                    + "4 - Atualizar um cliente \n"
                    + "5 - Deletar um cliente \n"
                    + "0 - Sair do sistema \n"
                );

                System.out.print("Informe uma opção: ");
                value = this.scanner.nextInt();
                this.scanner.nextLine(); // Consome a nova linha (\n) residual do NextInt()

                switch (value) {
                    case 1:
                        GetClient();
                        break;
                    case 2:
                        GetAllClient();
                        break;
                    case 3:
                        CreateClient();
                        break;
                    case 4:
                        UpdateClient();
                        break;
                    case 5:
                        DeleteClient();
                        break;
                    case 0:
                        Utility.ClearConsole();
                        System.out.println("\nSistema sendo finalizado, bye bye...\n");
                        break;
                    default:
                        System.out.println("\nOps, informe um opção válida!");
                        break;
                }
            }catch(Exception ex){
                System.out.println("\nOps, por favor, informe uma opção válida... Vamos tentar de novo!");
            }
        }
    }

    private void GetClient(){
        try{
            Utility.ClearConsole();

            System.out.print("Informe o código de um cliente: ");

            this.idAssistant = this.scanner.nextInt();
            
            Client client = this.clientService.Read(this.idAssistant);
            
            if(client == null){
                System.out.println("Cliente não encontrado...");
            }else{
                this.PrintClient(client);
            }
        }catch(Exception ex){
            this.MessageError(ex.getMessage());
        }finally{
            this.FinallyFunction();
            this.scanner.nextLine();
        }
    }

    private void GetAllClient(){
        try{
            Utility.ClearConsole();

            ArrayList<Client> listClients = this.clientService.Read();
            if(listClients.size() <= 0){
                System.out.println("\n\nNenhum registro encontrado!!");
            }

            for (Client client : listClients) {
                this.PrintClient(client);
            }
        }catch(Exception ex){
            this.MessageError(ex.getMessage());
        }finally{
            this.FinallyFunction();
        }
    }

    private void CreateClient(){
        try {
            Utility.ClearConsole();
            Client client = new Client();
            System.out.println("Informe os dados do Cliente a ser cadastrado:");
            
            System.out.print("Nome: ");
            client.setName(this.scanner.nextLine());

            System.out.print("CPF: ");
            client.setCPF(this.scanner.nextLine());

            System.out.print("Email: ");
            client.setEmail(this.scanner.nextLine());

            System.out.print("Telefone: ");
            client.setPhone(this.scanner.nextLine());

            client = this.clientService.Create(client);

            if(!client.getStatus()){
                System.out.println(client.getMessage());
            }else{
                System.out.println("Cliente cadastrado com sucesso!!");
            }

        }catch(Exception ex){
            this.MessageError(ex.getMessage());
        }finally{
            this.FinallyFunction();
        }
    }

    private void UpdateClient(){
        try {
            Utility.ClearConsole();
            System.out.print("Informe o código do cliente: ");
            this.idAssistant = this.scanner.nextInt();
            this.scanner.nextLine(); // Consome a nova linha (\n) residual do NextInt()

            Client client = this.clientService.Read(this.idAssistant);

            if(client == null){
                System.out.println("Cliente não encontrado...");
            }else{        

                System.out.print("Nome: ");
                client.setName(this.scanner.nextLine());

                System.out.print("CPF: ");
                client.setCPF(this.scanner.nextLine());

                System.out.print("Email: ");
                client.setEmail(this.scanner.nextLine());

                System.out.print("Telefone: ");
                client.setPhone(this.scanner.nextLine());

                client = this.clientService.Update(client);

                if(!client.getStatus()){
                    System.out.println(client.getMessage());
                }else{
                    System.out.println("Cliente utualizado com sucesso!!");
                }
            }
        }catch(Exception ex){
            this.MessageError(ex.getMessage());
        }finally{
            this.FinallyFunction();
        }
    }

    private void DeleteClient(){
        try {
            Utility.ClearConsole();
            System.out.print("Informe o código do cliente a ser deletado: ");
            this.idAssistant = this.scanner.nextInt();

            Client client = this.clientService.Read(this.idAssistant);

            if(client == null){
                System.out.println("Cliente não encontrado...");
            }else{ 
                client = this.clientService.Delete(client.getId());
                System.out.println("Dados do cliente que foi deletado:\n");
                System.out.println("Código: " + client.getId());
                System.out.println("Nome: " + client.getName());
                System.out.println("CPF: " + client.getCPF());
                System.out.println("Email: " + client.getEmail());
                System.out.println("Telefone: " + client.getPhone());
            }
        }catch(Exception ex){
            this.MessageError(ex.getMessage());
        }finally{
            this.FinallyFunction();
            this.scanner.nextLine();
        }
    }

    private void FinallyFunction(){
        this.PressAnyKeyForContinue();
        this.idAssistant = 0;
    }

    private void PressAnyKeyForContinue(){
        try {
            System.out.print("\n\nPressione qualquer tecla para continuar...");
            this.scanner.nextLine();
        }catch(Exception ex){
            this.MessageError(ex.getMessage());
        }
    }

    private void PrintClient(Client client){
        System.out.println("\n\n------------------------------");
        System.out.println("Código: " + client.getId());
        System.out.println("Nome: " + client.getName());
        System.out.println("Email: " + client.getEmail());
        System.out.println("Telefone: " + client.getPhone());
    }

    private void MessageError(String message){
        System.out.println("Ops, não conseguimos atender sua solicitação, erro: " + message);
    }
}
