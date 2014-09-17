package Hard;

import java.util.ArrayList;
import java.util.HashMap;

import java.util.*;
class SuffixTree
{
SuffixTreeNode root = new SuffixTreeNode();

public SuffixTree(String s) 
{

for(int i = 0; i < s.length(); i++) { String suffix = s.substring(i); root.insertString(suffix, i); } } public ArrayList getIndexes(String s) 
{
return root.getIndexes(s);
}
}

class SuffixTreeNode 
{
HashMap children = new HashMap();
char value;
ArrayList indexes = new ArrayList();


public SuffixTreeNode() { }

public void insertString(String s, int index) 
{
indexes.add(index);

if (s != null && s.length() > 0) 
{
value = s.charAt(0);
SuffixTreeNode child = null;

if (children.containsKey(value))
{
System.out.println("exist -" + value); 
child = (SuffixTreeNode) children.get(value);
}
else
{
System.out.println("1st time -" + value); 
child = new SuffixTreeNode();
children.put(value, child);
}

String remainder = s.substring(1);
child.insertString(remainder, index);
}
}

public ArrayList getIndexes(String s) 
{
if (s == null || s.length() == 0) 
{
return indexes;
}
else
{
char first = s.charAt(0);
if (children.containsKey(first)) 
{
String remainder = s.substring(1);
return ((SuffixTree) children.get(first)).getIndexes(remainder);
}
}
return null;
}
}

public class q88 
{
public static void main(String[] args) 
{
String testString = "ibabibsabs";//"mississippi";
String[] stringList = {"ib","bs"};//{"is", "sip", "hi", "sis"};
SuffixTree tree = new SuffixTree(testString);
for (String s : stringList)
{
ArrayList list = tree.getIndexes(s);
if (list != null) 
{
System.out.println(s + ": " + list.toString());
}
}
}
}
