package application;

import java.util.*;

public class DFS {

 public Node Path(Node Start) {
     if (Start.isTarget()) {
         return Start;
     }

     Stack<Node> Stack = new Stack<>(); 
     ArrayDeque<Node> visited = new ArrayDeque<>();

     Stack.push(Start);

     while (!Stack.isEmpty()) {
         Node state = Stack.pop();
         visited.add(state);

         List<Node> successors = state.create_chlidren();
         for (Node child : successors) {
             if (!visited.contains(child) && !Stack.contains(child)) {
                 if (child.isTarget()) {
                     return child;
                 }
                 Stack.push(child);
             }
         }
     }
     return null;
 }
}
