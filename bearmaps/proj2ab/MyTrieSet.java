package bearmaps.proj2ab;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.*;


public class MyTrieSet implements TrieSet61B
{
     private Node root;

    private class Node
    {
        char c;
        boolean isKey;
        HashMap<Character, Node> children;

        Node()
        {
            isKey = false;
            children = new HashMap<>();
        }
    }

    public MyTrieSet()
    {
        clear();
    }

    @Override
    public void clear() {
        root = new Node();

    }

    @Override
    public boolean contains(String key) {
        return contains(root,key);
    }

    private boolean contains(Node curr, String key)
    {
        if(key.isEmpty())
        {
            return curr.isKey;
        }

        char c = key.charAt(0);
        String rest = key.substring(1);
        Node newNode = curr.children.get(c);

        if(newNode == null)
        {
            return false;
        }
        else
            return contains(newNode, rest);
    }

    @Override
    public void add(String key) {
        add(root,key);
    }

    private void add(Node curr,String key)
    {
        if(key.isEmpty())
        {
            curr.isKey = true;
            return;
        }
        char c = key.charAt(0);
        String rest = key.substring(1);

        Node newNode = curr.children.get(c);

        if (newNode == null)
        {
            newNode = new Node();
            newNode.c = c;
            curr.children.put(c, newNode);
        }
        add(newNode, rest);

    }

    @Override
    public List<String> keysWithPrefix(String prefix) {
        ArrayList <String> results = new ArrayList<>();
        Node curr = root;
        for (int i = 0; i < prefix.length(); i++) {
            curr = curr.children.get(prefix.charAt(i));

            if(curr == null)
            {
                return new ArrayList<>();
            }
        }

        collectionHelper(curr,prefix,results);
        return results;
    }

    private void collectionHelper(Node n, String prefix, List<String> results)
    {

        if(n.isKey)
        {
            results.add(prefix);
        }

        Set<Character> keys = n.children.keySet();
        for(Character c: keys)
        {
            Node newNode = n.children.get(c);
            collectionHelper(newNode,prefix+newNode.c,results);
        }
    }

    @Override
    public String longestPrefixOf(String key) {
       Node curr = root;
       String prefix = "";
        for (int i = 0; i <key.length() ; i++) {
            Node newNode = curr.children.get(key.charAt(i));
            if(newNode == null)
            {
                break;
            }
            else
            {
                prefix = prefix +key.charAt(i);
            }
        }
        return prefix;
    }
}
