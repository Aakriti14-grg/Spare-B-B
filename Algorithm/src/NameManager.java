public class NameManager
{

    // backup copies
    private String firstBackup = "";
    private String middleBackup = "";
    private String lastBackup = "";

    // store original words
    public void backup(String f, String m, String l)
    {
        firstBackup = f;
        middleBackup = m;
        lastBackup = l;
        System.out.println("Backup saved.");
    }

    // restore original words
    public void restore(Full_Name list) {
        if (firstBackup.isEmpty() && lastBackup.isEmpty())
        {
            System.out.println("No backup found.");
            return;
        }

        list.clear(); // clear linked list

        list.addWord(firstBackup, 'F');
        if (!middleBackup.isEmpty())
            list.addWord(middleBackup, 'M');
        list.addWord(lastBackup, 'L');

        System.out.println("Name restored from backup.");
    }
}