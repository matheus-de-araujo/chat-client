import java.io.IOException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws IOException {
		ClienteTCP clienteTCP = new ClienteTCP();
		Message message = new Message();
		Message messageReceived = new Message();
		Scanner scan = new Scanner(System.in);
		message.setFim(false);

		System.out.println("Bem vindo ao chat");
		System.out.println("Digite seu Nome");
		message.setNome(scan.next());

		while(!message.isFim()){
			System.out.println("Digite sua Mensagem (Ou quit para sair do chat)");
			message.setMessage(scan.next());

			if(message.getMessage().toUpperCase().equals("QUIT")){
				break;
			}
			
			messageReceived = clienteTCP.enviarDados(message);
			
			System.out.println(messageReceived.getNome() + " disse: " + messageReceived.getMessage());
		}

		clienteTCP.encerrarConexao();
		System.out.println(message.getNome() + " saiu do Chat!");

	}
}
