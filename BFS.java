package application;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;
import java.util.*;

public class BFS {

	public Node path(Node root) {
		if (!root.isTarget()) {// check if the root is the target or not if not we will explore it
			ArrayDeque<Node> queue = new ArrayDeque<>();
			ArrayDeque<Node> visited = new ArrayDeque<>();
			queue.add(root);
			while (!queue.isEmpty()) {
				Node node = queue.poll();
				visited.add(node);
				List<Node> successors = node.create_chlidren();
				for (Node child : successors) {
					if (!visited.contains(child) && !queue.contains(child)) {
						if (child.isTarget()) {
							return child;
						}
						queue.add(child);
					}
				}
			}

		} else {
			return root;
		}

		return null;
	}
}
