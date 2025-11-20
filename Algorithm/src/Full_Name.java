public class Full_Name
{
    private Node head;
    private Node tail;
    private int size;

    public Full_Name()
    {
        head = null;
        tail = null;
        size = 0;
    }

    // ADD A SINGLE CHARACTER
    public void addElement(char letter, char part)
    {
        Node newNode = new Node(size + 1, letter, part);

        if (head == null)
        {
            head = newNode;
            tail = newNode;
        } else
        {
            tail.next = newNode;
            tail = newNode;
        }
        size++;
    }

    //ADD A WHOLE WORD
    public void addWord(String word, char part)
    {
        if (word == null || word.isEmpty()) return;

        String firstWord = word.split(" ")[0];

        for (char c : firstWord.toCharArray())
        {
            if (Character.isLetter(c))
            {
                addElement(c, part);
            }
        }
    }

    //PRINT FULL NAME
    public void printFullName()
    {
        if (head == null)
        {
            System.out.println("Full Name is empty.");
            return;
        }

        System.out.print("Full Name: ");
        Node temp = head;
        while (temp != null)
        {
            System.out.print(temp.letter);
            temp = temp.next;
        }
        System.out.println();
    }

    //Print nodes
    public void printNodes()
    {
        if (head == null)
        {
            System.out.println("No nodes available.");
            return;
        }

        Node temp = head;
        System.out.println("\n--- Linked List Details ---");
        while (temp != null)
        {
            System.out.println("Position: " + temp.position +
                    " | Letter: " + temp.letter +
                    " | Part: " + temp.part);
            temp = temp.next;
        }
    }

    // Remove a word
    public void removeWord(char part)
    {
        Node temp = head;
        Node prev = null;
        boolean removed = false;

        while (temp != null)
        {
            if (temp.part == part)
            {
                removed = true;

                if (temp == head)
                {
                    head = head.next;
                    temp = head;
                } else
                {
                    prev.next = temp.next;
                    temp = temp.next;
                }
                size--;
            } else
            {
                prev = temp;
                temp = temp.next;
            }
        }

        if (!removed)
        {
            System.out.println("No such part exists to remove.");
        } else
        {
            System.out.println("Removed successfully.");
        }

        // Fix tail
        tail = head;
        while (tail != null && tail.next != null)
            tail = tail.next;
    }

    // Frequency
    public int frequency(char letter)
    {
        letter = Character.toLowerCase(letter);
        int count = 0;

        Node temp = head;
        while (temp != null)
        {
            if (temp.letter == letter) count++;
            temp = temp.next;
        }
        return count;
    }

    // Find all positions
    public void find(char letter)
    {
        letter = Character.toLowerCase(letter);
        Node temp = head;
        int pos = 1;
        boolean found = false;

        System.out.print("Letter found at positions: ");

        while (temp != null)
        {
            if (temp.letter == letter)
            {
                System.out.print(pos + " ");
                found = true;
            }
            temp = temp.next;
            pos++;
        }

        if (!found)
            System.out.print("Not found.");

        System.out.println();
    }

    //Sort
    public void sort()
    {
        if (head == null) return;

        boolean swapped;
        do
        {
            swapped = false;
            Node temp = head;

            while (temp.next != null)
            {
                if (temp.letter > temp.next.letter)
                {
                    char c = temp.letter;
                    temp.letter = temp.next.letter;
                    temp.next.letter = c;
                    swapped = true;
                }
                temp = temp.next;
            }
        } while (swapped);

        System.out.println("Sorted successfully.");
    }

    // Clear list
    public void clear()
    {
        head = null;
        tail = null;
        size = 0;
    }
}