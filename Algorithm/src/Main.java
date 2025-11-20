import java.util.Scanner;

public class Main
{

    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        Full_Name nameList = new Full_Name();
        NameManager backup = new NameManager();

        System.out.print("Enter First Name: ");
        String f = sc.nextLine();
        nameList.addWord(f, 'F');

        System.out.print("Enter Middle Name (optional): ");
        String m = sc.nextLine();
        nameList.addWord(m, 'M');

        System.out.print("Enter Last Name: ");
        String l = sc.nextLine();
        nameList.addWord(l, 'L');

        backup.backup(f, m, l);

        int option;
        do
        {
            System.out.println("\n--- MENU ---");
            System.out.println("1. Print Full Name");
            System.out.println("2. Print Nodes");
            System.out.println("3. Find Letter Positions");
            System.out.println("4. Letter Frequency");
            System.out.println("5. Sort Letters");
            System.out.println("6. Remove First Name");
            System.out.println("7. Remove Middle Name");
            System.out.println("8. Remove Last Name");
            System.out.println("9.Add letter 'a' in the end");
            System.out.println("10. Restore Name From Backup");
            System.out.println("11. Exit");

            System.out.print("Enter option: ");
            option = sc.nextInt();

            switch (option)
            {
                case 1:
                    nameList.printFullName();
                    break;

                case 2:
                    nameList.printNodes();
                    break;

                case 3:
                    System.out.print("Enter letter: ");
                    nameList.find(sc.next().charAt(0));
                    break;

                case 4:
                    System.out.print("Enter letter: ");
                    System.out.println("Frequency: " + nameList.frequency(sc.next().charAt(0)));
                    break;

                case 5:
                    nameList.sort();
                    break;

                case 6:
                    nameList.removeWord('F');
                    break;

                case 7:
                    nameList.removeWord('M');
                    break;

                case 8:
                    nameList.removeWord('L');
                    break;

                case 9:
                    nameList.addElement('a', 'L');
                    System.out.println("Letter 'a' added to the end of last name.");
                    break;

                case 10:
                    backup.restore(nameList);
                    break;

                case 11:
                    System.out.println("Exiting program...");
                    break;

                default:
                    System.out.println("Invalid option.");
            }

        } while (option != 11);

        sc.close();
    }
}