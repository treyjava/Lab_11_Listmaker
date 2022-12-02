import java.util.Scanner;
import java.util.ArrayList;

public class Main
{
    public static void main(String[] args)
    {
        ArrayList<String> itemList = new ArrayList<>();
        Scanner in = new Scanner(System.in);
        boolean done = false;
        String itemChoice = "";

        do
        {
            itemChoice = displayMenu(in, itemList);
            switch (itemChoice)
            {
                case "A":
                    addItem(in, itemList);
                    break;
                case "D":
                    deleteItem(in, itemList);
                    break;
                case "P":
                    displayItem(itemList);
                    break;
                case "Q":
                    if (SafeInput.getYNConfirm(in, "Are you sure you want to exit? "))
                    {
                        done = true;
                    }
                    break;
            }
        } while (!done);
    }

    public static void addItem(Scanner in, ArrayList itemList)
    {
        String itemAdd = SafeInput.getNonZeroLengthString(in, "Type then press enter to add");
        itemList.add(itemAdd);
    }

    public static void deleteItem(Scanner in, ArrayList itemList)
    {
        int itemDelete = SafeInput.getRangedInt(in, "Type list number then enter to delete an item ", 1, itemList.size());
        itemList.remove(itemDelete - 1);
    }

    public static void displayItem(ArrayList itemList)
    {
        for (int i = 0; i < itemList.size(); i++)
        {
            System.out.println(itemList.get(i));
        }
    }

    private static String displayMenu(Scanner in, ArrayList itemList)
    {
        if (itemList.isEmpty())
        {
            System.out.println("Empty List ");
        }
        else
        {
            System.out.println("Current list ");
            for (int i = 0; i < itemList.size(); i++)
            {
                System.out.printf("    %d. %s\n", i + 1 , itemList.get(i));
            }
        }
        return SafeInput.getRegExString(in, "Type then enter to select:\n    A: Add\n    D: Delete\n    P: Print\n    Q: Quit\n", "[AaDdPpQq]").toUpperCase();
    }
}