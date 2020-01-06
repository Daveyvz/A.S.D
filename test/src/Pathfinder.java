import java.util.ArrayList;

public class Pathfinder
{
    ArrayList<Node> closedList = new ArrayList<>();
    ArrayList<Node> openList = new ArrayList<>();
    Node start = new Node(0,0);
    Node currentNode, endNode;
    int lowestF = 99999;

    // call when obstructed or when the car receives a new route
    public ArrayList<Node> AStarPathfinder(Node currentNode, Node endNode)
    {
        this.currentNode = currentNode;
        this.endNode = endNode;
        start.costF = 0;

        openList.add(start);
        while (!openList.isEmpty())
        {
            for (Node node : openList)
            {
                if(node.costF < lowestF)
                {
                    lowestF = node.costF;
                    currentNode = node;
                    if(currentNode == endNode)
                    {
                        return closedList;
                    }
                }
            }
            openList.remove(currentNode);
            closedList.add(currentNode);
            GenerateChildren();
        }
        return openList;
    }

    public void GenerateChildren()
    {
        ArrayList<Node> children = new ArrayList<Node>();
        int positionParentX = currentNode.positionX;
        int positionParentY = currentNode.positionY;
        children.add(new Node(positionParentX, positionParentY + 1));
        children.add( new Node(positionParentX + 1, positionParentY));
        children.add( new Node(positionParentX, positionParentY - 1));
        children.add( new Node(positionParentX - 1, positionParentY));

        for (Node child: children)
        {
            if (closedList.contains(child))
            {
                continue;
            }

            child.costG = currentNode.costG + (currentNode.positionX - child.positionX) + (currentNode.positionY - child.positionY);
            child.costF = (endNode.positionX - child.positionX) + (endNode.positionY - child.positionY);
            child.costN = child.costG + child.costF;

            if(openList.contains(child))
            {
                Node nodeTemp = openList.get(openList.indexOf(child));
                if(nodeTemp.costG < child.costG)
                {
                    continue;
                }
            }
            openList.add(child);
        }
    }


    public int[] Bubblesort(int[] unsortedArray)
    {
        int arrayLength = unsortedArray.length;
        int temp = 0;
        for(int i = 0; i < arrayLength; i++ )
        {
            for(int k = 1; k < (arrayLength - i); k++)
            {
                if(unsortedArray[k-1] > unsortedArray[k])
                {
                    temp = unsortedArray[k - 1];
                    unsortedArray[i - 1] = unsortedArray[i];
                    unsortedArray[i] = temp;
                }
            }
        }
        return unsortedArray;
    }
}
