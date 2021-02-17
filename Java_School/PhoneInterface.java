package intro;

public interface PhoneInterface {
	public abstract void sendCall();
	public abstract void receiveCall();
	public default void printLogo() {
		System.out.println("** Phone **");
	}
}
