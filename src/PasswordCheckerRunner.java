import java.util.Scanner;

public class PasswordCheckerRunner
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Choose a secure password that meets these requirements:");
        System.out.println("- Is at least 8 characters long");
        System.out.println("- Contains at least one uppercase letter");
        System.out.println("- Contains at least one lowercase letter");
        System.out.println("- Contains at least one numeric digit");
        System.out.println("- Contains at least one of these symbols: ! @ # $ % ^ & * ?");
        System.out.print("\nEnter your secure password: ");
        String password = scanner.nextLine();
        SecurePassword user = new SecurePassword(password);
        System.out.print(user.status());
        while (!user.isSecure())
        {
            System.out.print("\nPlease try again: ");
            password = scanner.nextLine();
            user.setPassword(password);
            System.out.println(user.status());
        }
    }
}