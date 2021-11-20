import java.io.IOException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws IOException {
		ClienteTCP clienteTCP = new ClienteTCP();
		Message message = new Message();
		Scanner scan = new Scanner(System.in);
		message.setFim(false);

		System.out.println("Bem vindo ao chat");
		System.out.println("Digite a qualquer momento a palavra quit para encerrar");

		while(!message.isFim()){
			System.out.println("Digite sua Mensagem");
			message.setMessage(scan.next());

			if(message.getMessage().toUpperCase().equals("QUIT")){
				break;
			}
			
			message = clienteTCP.enviarDados(message);
			
			System.out.println("Pessoa 2: " + message.getMessage());
		}

		clienteTCP.encerrarConexao();
		System.out.println("Chat Encerrado!");

	}
}
