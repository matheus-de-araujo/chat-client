import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class ClienteTCP {
	
	public Message enviarDados(Message message) {
		ObjectOutputStream saida;
        ObjectInputStream entrada;
        
        Socket conexao;
        
        try {
			conexao = new Socket("localhost", 9000);
			System.out.println("conectado ao servidor na porta 9000" );
			saida = new ObjectOutputStream(conexao.getOutputStream());
			entrada = new ObjectInputStream(conexao.getInputStream());
			
			//enviando message para calcular imc
			saida.writeObject(message);
			
			// recebendo a resposta do servidor
			message = (Message) entrada.readObject();
			
			entrada.close();
			saida.close();
			conexao.close();
			
			return message;
			
		} catch (Exception e) {
			return null;
		}
	}

}
