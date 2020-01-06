public class Node
{
    int costG, costF, costN;
    int positionX, positionY;
    String parent = null;

    public Node(int positionX, int positionY) //String parent)
    {
        this.positionX = positionX;
        this.positionY = positionY;
        // this.parent = parent;
    }

    public boolean CheckNodeEquality(Node nodeA, Node nodeB)
    {
        if(nodeA == nodeB)
        {
            return true;
        }
        return false;
    }
}