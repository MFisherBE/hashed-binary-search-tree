// Michael Fisher



import java.util.Random;

class HBST<Key, Value>
{

    private Random generator = new Random();
    private class PairNode
    {
        private Key key;
        private Value value;
        private PairNode next;
        public PairNode(Key key, Value value, PairNode next)
        {
            this.key=key;
            this.value=value;
            this.next=next;
        }
    }

    private class TreeNode
    {
        private int hash;
        private PairNode pairs;
        private TreeNode left;
        private TreeNode right;
        public TreeNode(int hash, PairNode pairs, TreeNode left, TreeNode right)
        {
            this.hash=hash;
            this.pairs=pairs;
            this.left=left;
            this.right=right;
        }
    }

    private TreeNode root;
    private PairNode rootPN;


    public HBST()
    {
        root = new TreeNode(1000, null,null,null);
        generator = new Random();
    }

    public Value get(Key key)
    {
        Value returnVal;                    // Value (matched with key) that will be returned
        PairNode newPN = rootPN.next;       // Temporary new PairNode to use for comparisons

        // If the key passed in as a param is empty
        if(key == null)
        {
            // Throw an error
            throw new IllegalArgumentException("Key is empty.");
        }

        // If the key param passed in is not empty
        else
        {
            // While key from our comparison PairNode is not empty
            while(newPN.key != null)
            {
                // If our newPN key matches the key param
                if(newPN.key == key)
                {
                    returnVal = newPN.value;    // returnVal gets value from newPN
                    return returnVal;           // Return the value
                }

                // Else if no matching key was found in newPN...
                else
                {
                    newPN = newPN.next;         // iterate through to the next PairNode
                }
            }
            return null;                        // Return null if no matches were found
        }
    }

    public int height()
    {
        int countR = 0;                  // Int var to count height (non-empty TreeNodes)
        int countL = 0;
        TreeNode newTNR = root.right;    // Temporary TreeNode used to count non-empty Nodes
        TreeNode newTNL = root.left;

        // While newTNR is not empty
        while(newTNR != null)
        {
            countR++;                    // Increment count of height of HBST
            newTNR = newTNR.right;        // Iterate through to the next node down
        }
        while(newTNL != null)
        {
            countL++;
            newTNL = newTNL.left;
        }
        if(countL > countR)
        {
            return countL;
        }
        else
        {
            return countR;
        }
    }

    private int hash(Key key)
    {
        int temp;

        if(key == null)
        {
            return 0;
        }
        else
        {
            temp = key.hashCode();
            generator.setSeed(temp);
            return generator.nextInt();
        }
    }


    public boolean isEmpty() {

        return (root == null && root.left == null && root.right == null);
    }

    public boolean isEqual(Key left, Key right)
    {
        boolean Equal = false;
        if(left == right)
        {
            Equal = true;
        }
        return Equal;
    }

    public void put(Key key, Value value)
    {

        // As this method was described in the write up, it sounds like it's
        // asking us to use the "key" parameter to compare to find the right
        // PairNode and then pack the "value" parameter into that PairNode
        TreeNode putTN = root;

        // While the root Node is not empty
        while(root !=null)
        {
            // If key and value are both null
            if (key == null && value == null)
            {
                // if TreeNode key = key param
                if (putTN.pairs.key == key)
                {
                    // Associate value with that corresponding TreeNode value
                    putTN.pairs.value = value;
                }

                // if left TreeNode key = key param
                else if (putTN.left.pairs.key == key)
                {
                    // Associate value with that corresponding TreeNode value
                    putTN.left.pairs.value = value;
                }

                // If right TreeNode key = key param
                else if (putTN.right.pairs.key == key)
                {
                    // Associate value with that corresponding TreeNode value
                    putTN.right.pairs.value = value;
                }
            }

            // If key is null OR value is null
            else if (key == null || value == null)
            {
                // if TreeNode key = key param
                if (putTN.pairs.key == key)
                {
                    // Associate value with that corresponding TreeNode value
                    putTN.pairs.value = value;
                }

                // if left TreeNode key = key param
                else if (putTN.left.pairs.key == key)
                {
                    // Associate value with that corresponding TreeNode value
                    putTN.left.pairs.value = value;
                }

                // If right TreeNode key = key param
                else if (putTN.right.pairs.key == key)
                {
                    // Associate value with that corresponding TreeNode value
                    putTN.right.pairs.value = value;
                }
            }

            // Else if key and value both are not null
            else
            {
                // if TreeNode key = key param
                if (putTN.pairs.key == key)
                {
                    // Associate value with that corresponding TreeNode value
                    putTN.pairs.value = value;
                }

                // if left TreeNode key = key param
                else if (putTN.left.pairs.key == key)
                {
                    // Associate value with that corresponding TreeNode value
                    putTN.left.pairs.value = value;
                }

                // If right TreeNode key = key param
                else if (putTN.right.pairs.key == key)
                {
                    // Associate value with that corresponding TreeNode value
                    putTN.right.pairs.value = value;
                }
            }
            root = root.left;
        }
    }
}

class CornedBeefHash
{
    private final static String[] reserved =
            { "abstract",     "assert",       "boolean",     "break",
                    "byte",         "case",         "catch",       "char",
                    "class",        "const",        "continue",    "default",
                    "do",           "double",       "else",        "extends",
                    "false",        "final",        "finally",     "float",
                    "for",          "goto",         "if",          "implements",
                    "import",       "instanceof",   "int",         "interface",
                    "long",         "native",       "new",         "null",
                    "package",      "private",      "protected",   "public",
                    "return",       "short",        "static",      "super",
                    "switch",       "synchronized", "this",        "throw",
                    "throws",       "transient",    "true",        "try",
                    "var",          "void",         "volatile",    "while" };

    public static void main(String [] args)
    {
        HBST<Integer, Integer> intToInt = new HBST<Integer, Integer>();
        for (int key = -10; key <= 10; key += 1)
        {
            intToInt.put(key, key * key);
        }
        System.out.println(intToInt.height());
        for (int key = -10; key <= 10; key += 1)
        {
            System.out.format("%3d %3d", key, intToInt.get(key));
            System.out.println();
        }

        System.out.println();

        HBST<String, Integer> stringToInt = new HBST<String, Integer>();
        for (int index = 0; index < reserved.length; index += 1)
        {
            stringToInt.put(reserved[index], index);
        }
        System.out.println(stringToInt.height());
        for (int index = 0; index < reserved.length; index += 1)
        {
            String name = reserved[index];
            System.out.format("%02d %s", stringToInt.get(name), name);
            System.out.println();
        }
    }
}


