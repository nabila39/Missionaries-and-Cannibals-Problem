package application;

import java.util.ArrayList;
import java.util.List;

public class Node {

	private int CLeft;
	private int MLeft;
	private int CRight;
	private int MRight;
	Position p = new Position();
	private Node parentState;

	public Node(int CLeft, int MLeft, Position p, int CRight, int MRight) {
		this.CLeft = CLeft;
		this.MLeft = MLeft;
		this.p = p;
		this.CRight = CRight;
		this.MRight = MRight;
	}

	public boolean isTarget() {
		if (CLeft == 0 && MLeft == 0) {
			return true;
		} else

			return false;

	}

	public boolean isValid() {
		if (MLeft >= 0 && MRight >= 0 && CLeft >= 0 && CRight >= 0 && (MLeft == 0 || MLeft >= CLeft)
				&& (MRight == 0 || MRight >= CRight)) {
			return true;
		}
		else
		return false;
	}

	public List<Node> create_chlidren() {
		List<Node> chlidrens = new ArrayList<Node>();
		if (p == Position.LEFT) {
			Cheeck(chlidrens, new Node(CLeft, MLeft - 2, Position.RIGHT, CRight, MRight + 2));
			Cheeck(chlidrens, new Node(CLeft, MLeft - 1, Position.RIGHT, CRight, MRight + 1));// Two // right.
			Cheeck(chlidrens, new Node(CLeft - 2, MLeft, Position.RIGHT, CRight + 2, MRight)); // Two cannibals																						// right.
			Cheeck(chlidrens, new Node(CLeft - 1, MLeft - 1, Position.RIGHT, CRight + 1, MRight + 1)); // One																// right.
			Cheeck(chlidrens, new Node(CLeft - 1, MLeft, Position.RIGHT, CRight + 1, MRight)); // One cannibal

		} else {
			Cheeck(chlidrens, new Node(CLeft + 1, MLeft, Position.LEFT, CRight - 1, MRight));
			Cheeck(chlidrens, new Node(CLeft, MLeft + 2, Position.LEFT, CRight, MRight - 2)); // Two // left.
			Cheeck(chlidrens, new Node(CLeft + 2, MLeft, Position.LEFT, CRight - 2, MRight)); // Two
			Cheeck(chlidrens, new Node(CLeft, MLeft + 1, Position.LEFT, CRight, MRight - 1)); // left.
			Cheeck(chlidrens, new Node(CLeft + 1, MLeft + 1, Position.LEFT, CRight - 1, MRight - 1)); // One
			
		}
		return chlidrens;
	}

	private void Cheeck(List<Node> chlidrens, Node Newchild) {
		if (Newchild.isValid()) {
			Newchild.setParentState(this);
			chlidrens.add(Newchild);
		}
	}

	public Node getParentState() {
		return parentState;
	}

	public void setParentState(Node parentState) {
		this.parentState = parentState;
	}

	@Override
	public String toString() {
		if (p == Position.LEFT) {
			return  CLeft + "," + MLeft + ",L," + CRight + "," + MRight ;
		} else {
			return   CLeft + "," + MLeft + ",R," + CRight + "," + MRight ;
		}
	}

	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof Node)) {
			return false;
		}
		Node s = (Node) obj;
		return (s.CLeft == CLeft && s.MLeft == MLeft && s.p == p && s.CRight == CRight && s.MRight == MRight);
	}
}