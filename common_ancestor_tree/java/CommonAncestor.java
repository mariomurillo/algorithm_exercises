import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Node {
  int value;
  Node father;
  List<Node> children = new ArrayList<>();

  public Node(int value) {
    this.value = value;
    this.father = null;
  }

  public List<Node> getChildren() {
      return children;
  }

  public void setValue(int value) {
      this.value = value;
  }

  public void setFather(Node father) {
      this.father = father;
  }

  public void addChild(Node child) {
    this.children.add(child);
    child.setFather(this);
  }

  @Override
  public String toString() {
      return "Node[value:" + value + ", children:" + children + "]";
  }
}

class CommonAncestor {
  public static void main(String args[]) {
    System.out.println(buildTreeSample());
  }

  private static Node buildTreeSample() {
    Node root = new Node(2);
    addNodes(root, Arrays.asList(7, 5));

    List<Node> children = root.getChildren();
    addNodes(children.get(0), Arrays.asList(2, 10, 6));
    addNodes(children.get(1), Arrays.asList(9));

    Node firstGrandChild = children.get(0).getChildren().get(2);
    addNodes(firstGrandChild, Arrays.asList(5, 11));

    Node secondGrandChild = children.get(1).getChildren().get(0);
    addNodes(secondGrandChild, Arrays.asList(4));

    return root;
  }

  private static void addNodes(Node father, List<Integer> nodeValues) {
    for (Integer value: nodeValues) {
      father.addChild(new Node(value));
    }
  }
}
