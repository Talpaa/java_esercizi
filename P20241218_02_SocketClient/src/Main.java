public class Main {

	public static void main(String[] args) {

		SocketClient client = new SocketClient();

		client.Run("localhost", 32456);
	}

}
