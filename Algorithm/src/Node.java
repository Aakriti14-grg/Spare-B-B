public class Node {
    int position;
    char letter;
    char part;
    Node next;

    public Node(int position, char letter, char part)
    {
        this.position = position;
        this.letter = Character.toLowerCase(letter);
        this.part = part;
        this.next = null;
    }
}