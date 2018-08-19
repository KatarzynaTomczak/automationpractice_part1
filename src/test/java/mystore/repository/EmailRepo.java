package mystore.repository;

import java.util.TreeSet;

public class EmailRepo {

    private static EmailRepo ourInstance = new EmailRepo();

    public static EmailRepo getInstance() {
        return ourInstance;
    }

    private EmailRepo() {
    }

    private TreeSet<String> emailTree = new TreeSet<>();

    public void addEmail(String email){
        emailTree.add(email);
    }

    public TreeSet<String> getEmailTree(){
        return emailTree;
    }



}
